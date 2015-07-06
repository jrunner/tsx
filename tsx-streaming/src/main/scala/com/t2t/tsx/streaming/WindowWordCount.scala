package com.t2t.tsx.streaming

import org.apache.spark.{SparkContext, SparkConf}
import org.apache.spark.storage.StorageLevel
import org.apache.spark.streaming._
import org.apache.spark.streaming.StreamingContext._

/**
 * title：
 * auther：ypf
 * 测试时间：2015-07-06
 * 测试结果：ok
 * 参数：127.0.0.1 10110 5
 */
object WindowWordCount {
  def main(args: Array[String]) {
    println("参数：" + args.mkString("\t"))

    val conf = new SparkConf().setAppName("WindowWordCount").setMaster("local[2]")
    val sc = new SparkContext(conf)

    //创建StreamingContext
    val ssc = new StreamingContext(sc, Seconds(5))
    ssc.checkpoint(".")

    //获取数据
    val lines = ssc.socketTextStream(args(0), args(1).toInt, StorageLevel.MEMORY_ONLY_SER)
    val words = lines.flatMap(_.split(" "))

    //windows操作
    val wordCounts = words.map(x => (x, 1)).reduceByKeyAndWindow((a: Int, b: Int) => (a + b), Seconds(args(2).toInt), Seconds(args(3).toInt))
    //val wordCounts = words.map(x => (x , 1)).reduceByKeyAndWindow(_+_, _-_,Seconds(args(2).toInt), Seconds(args(3).toInt))

    wordCounts.print()
    ssc.start()
    ssc.awaitTermination()
  }
}

