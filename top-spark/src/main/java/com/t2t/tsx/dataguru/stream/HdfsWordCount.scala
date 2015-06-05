package com.topsec.tss.dataguru.stream

import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD
import org.apache.spark.streaming.StreamingContext._
import org.apache.spark.streaming.{Seconds, StreamingContext, Time}
import org.datanucleus.store.types.simple.Date

/**
 * aiker
 * 2015/1/192.168.72.21
 */
object HdfsWordCount {
  def main(args: Array[String]) {
    val sc = new SparkConf().setAppName("HdfsWordCount").setMaster("local[2]")
    val ssc = new StreamingContext(sc, Seconds(20))

    //val path = "hdfs://n21.com:9000/user/root/examples/src/main/resources/people.txt";
    val path = "D:/A/";
    val lines = ssc.textFileStream(path)
    val words = lines.flatMap(_.split(" "))
    val wordCounts = words.map(x => (x, 1)).reduceByKey(_ + _)
    wordCounts.print();

    ssc.start()
    ssc.awaitTermination()
  }
}