package com.topsec.tss.com.topsec.tss.spark

import org.apache.spark.SparkContext._
import org.apache.spark.{SparkConf, SparkContext}

import scala.collection.mutable.ListBuffer

/**
 * Created by chenchao on 14-3-1.
 */
class Analysis {

}

object Analysis {

  def main(args: Array[String]) {

    if (args.length != 3) {
      println("Usage : java -jar code.jar dependency_jars file_location save_location")
      System.exit(0)
    }

    val jars = ListBuffer[String]()
    args(0).split(',').map(jars += _)

    val conf = new SparkConf()
    conf.setMaster("spark://n21.com:7077")
      .setSparkHome("/opt/hdfs/spark-1.2.0-bin-hadoop2.4")
      .setAppName("analysis")
      .setJars(jars)
      .set("spark.executor.memory", "10m")

    val sc = new SparkContext(conf)
    val data = sc.textFile(args(1))

    data.cache

    println("---------------------------------")
    println(data.count)

    data.filter(_.split(' ').length == 3).map(_.split(' ')(1)).map((_, 1)).reduceByKey(_ + _)
      .map(x => (x._2, x._1)).sortByKey(false).map(x => (x._2, x._1)).saveAsTextFile(args(2))

    sc.stop()
  }

}
