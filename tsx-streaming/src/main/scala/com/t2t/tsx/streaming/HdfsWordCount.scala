package com.t2t.tsx.streaming

/**
 * Created by ypf on 2015/7/4.
 */

import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD
import org.apache.spark.streaming.dstream.ForEachDStream
import org.apache.spark.streaming.{Time, Seconds, StreamingContext}
import org.apache.spark.streaming.StreamingContext._

/**
 * title：Hdfs文件演示
 * auther：ypf
 * 测试时间：2015-01-02
 * 测试结果：ok
 */
object HdfsWordCount {

  def main(args: Array[String]) {
    val sparkConf = new SparkConf().setAppName("HdfsWordCount").setMaster("local[2]")
    // Create the context
    val ssc = new StreamingContext(sparkConf, Seconds(20))

    val lines = ssc.textFileStream("D:/tmp/data/")
    // val lines = ssc.textFileStream("hdfs://w22.node:9000/tmp/data")
    val words = lines.flatMap(_.split(" "))
    val wordCounts = words.map(x => (x, 1)).reduceByKey(_ + _)
    wordCounts.print()
    ssc.start()
    ssc.awaitTermination()
  }

}
