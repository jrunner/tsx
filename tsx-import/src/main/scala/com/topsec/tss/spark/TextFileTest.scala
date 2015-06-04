package com.topsec.tss.spark

import org.apache.spark._

/**
 * ypf
 */
object TextFileTest {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("TextFileTest").setMaster("local[2]").set("spark.executor.memory", "10m")
    var sc = new SparkContext(conf)

    val path = "hdfs://n21.com:9000/jstg/@JS@ClassByEventType@Bot_or_Trojan@#917MT_B_IP_201301090000.txt"
    //val path = "D:\\zk.txt";
    val rdd = sc.textFile(path);
    val result = rdd.cache().count();

    println("--------------------------")
    println(result)
    println("--------------------------")

    sc.stop()
  }
}
