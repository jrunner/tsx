package com.topsec.tss.dataguru.stream

import org.apache.spark.{SparkContext, SparkConf}
import org.apache.spark.storage.StorageLevel
import org.apache.spark.streaming._
import org.apache.spark.streaming.StreamingContext._

object WindowWordCount {
  def main(args: Array[String]) {

    val host = "127.0.0.1"; //ip地址

    val port = 12345; //端口

    val dualA = 5 * 3; //必须是5的倍数，即3个rdd

    val dualB = 5 * 2; //发送时间间隔ms，十秒中滑动一次

    val sc = new SparkConf().setAppName(this.getClass.getName).setMaster("local[2]")
    val ssc = new StreamingContext(sc, Seconds(5)) //创建StreamingContext(5秒进行一次数据切割)
    ssc.checkpoint(".")

    // //获取数据
    val lines = ssc.socketTextStream(host, port, StorageLevel.MEMORY_ONLY_SER)
    val words = lines.flatMap(_.split(","))

    //windows操作
    val wordCounts = words.map(x => (x, 1)).reduceByKeyAndWindow((a: Int, b: Int) => (a + b), Seconds(dualA), Seconds(dualB))
    //val wordCounts = words.map(x => (x , 1)).reduceByKeyAndWindow(_+_, _-_,Seconds(args(2).toInt), Seconds(args(3).toInt))

    wordCounts.print()
    ssc.start()
    ssc.awaitTermination()
  }
}