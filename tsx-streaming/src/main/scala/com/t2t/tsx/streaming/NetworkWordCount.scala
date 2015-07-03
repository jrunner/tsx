package com.t2t.tsx.streaming

import org.apache.spark.storage.StorageLevel
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.streaming.StreamingContext._

/**
 * ypf
 * 测试时间：2015-01-02
 * 测试结果：ok
 * 参数：local 127.0.0.1 10110 10
 */
object NetworkWordCount {
  def main(args: Array[String]) {
    if (args.length < 4) {
      System.err.println("Usage: NetworkWordCount <master> <hostname> <port> <seconds>\n In local mode, <master> should be 'local[n]' with n > 1")
      System.exit(1)
    }

    println("参数" + args.mkString("\t"))
    println(System.getenv("SPARK_HOME"))

    StreamingHelper.setStreamingLogLevels()

    // 新建StreamingContext
    val sc = new StreamingContext(args(0), "NetworkWordCount", Seconds(args(3).toInt), System.getenv("SPARK_HOME"))

    // 使用这个context, 我们可以创建一个DStream， 代表来自TCP源的流数据。需要指定主机名和端口(如 127.0.0.1 和 9999).
    val lines = sc.socketTextStream(args(1), args(2).toInt)
    val words = lines.flatMap(_.split(" "))
    val wordCounts = words.map(x => (x, 1)).reduceByKey(_ + _)
    wordCounts.print()
    sc.start()
    sc.awaitTermination()
  }
}

