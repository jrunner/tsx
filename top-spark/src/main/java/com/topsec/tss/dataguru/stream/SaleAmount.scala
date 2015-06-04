package com.topsec.tss.dataguru.stream

import org.apache.spark.{SparkContext, SparkConf}
import org.apache.spark.streaming.{Milliseconds, Seconds, StreamingContext}
import org.apache.spark.streaming.StreamingContext._
import org.apache.spark.storage.StorageLevel

/**
 * qryStockDetail.txt文件定义了订单明细
 * 订单号，行号，货品，数量，单价，金额
 *
 * 功能描述：实时统计最近5秒钟的销售额
 */
object SaleAmount {
  def main(args: Array[String]) {
    val host = "127.0.0.1" //ip地址
    val port = 12345 //端口

    val sc = new SparkConf().setAppName("SaleAmount").setMaster("local[2]")
    val ssc = new StreamingContext(sc, Seconds(5)) //最近5秒钟的销售额

    val lines = ssc.socketTextStream(host, port, StorageLevel.MEMORY_AND_DISK_SER)
    val words = lines.map(_.split(",")).filter(_.length == 6)
    val wordCounts = words.map(x => (1, x(5).toDouble)).reduceByKey(_ + _)

    wordCounts.print()
    ssc.start()
    ssc.awaitTermination()
  }
}

