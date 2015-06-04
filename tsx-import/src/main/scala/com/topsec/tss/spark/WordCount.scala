package com.topsec.tss.spark

import org.apache.spark._
import SparkContext._

/**
 * aiker
 * 2015/1/13
 */
object WordCount {

  def main(args: Array[String]) {
    val sparkConf = new SparkConf().setAppName("WordCount").setMaster("local")

    val spark = new SparkContext(sparkConf)
    val file = spark.textFile("hdfs://n21.com:9000/spark/input/201501060000.txt")

    val counts = file.flatMap(_.split("<--->"))
      .map((_, 1))
      .reduceByKey(_ + _)
    counts.saveAsTextFile("hdfs://n21.com:9000/spark/result/201501060001")
    counts.foreach(println)
    println("-------------------")
  }

}
