package com.t2t.tsx.streaming

import org.apache.spark.streaming.kafka.KafkaUtils
import org.apache.spark.{SparkContext, SparkConf}
import org.apache.spark.streaming.{Minutes, Milliseconds, Seconds, StreamingContext}
import org.apache.spark.streaming.StreamingContext._
import org.apache.spark.storage.StorageLevel

/**
 * title：Hdfs文件演示
 * auther：ypf
 * 测试时间：2015-07-07
 * 测试结果：ok
 * 参数：w22.node grouptest test 2
 */
object KafkaWordCount {

  def main(args: Array[String]) {
    println("参数：" + args.mkString("\t"))
    StreamingHelper.setStreamingLogLevels()

    val conf = new SparkConf().setAppName("KafkaWordCount").setMaster("local[2]")
    val sc = new SparkContext(conf)
    val ssc = new StreamingContext(sc, Seconds(5))

    val Array(zkQuorum, group, topics, numThreads) = args
    ssc.checkpoint("checkpoint")

    val topicpMap = topics.split(" ").map((_, numThreads.toInt)).toMap
    val lines = KafkaUtils.createStream(ssc, zkQuorum, group, topicpMap).map(_._2)
    val words = lines.flatMap(_.split("\\s+"))
    val wordCounts = words.map(x => (x, 1)).reduceByKey(_ + _)
    wordCounts.print()

    ssc.start()
    ssc.awaitTermination()
  }

}
