package com.topsec.tss.dataguru.stream

import org.apache.spark.{SparkContext, SparkConf}
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.streaming.StreamingContext._

object StatefulWordCount {
  def main(args: Array[String]) {
    val host = "127.0.0.1"; //ip地址
    val port = 12345; //端口

    val updateFunc = (values: Seq[Int], state: Option[Int]) => {
      val currentCount = values.foldLeft(0)(_ + _)
      val previousCount = state.getOrElse(0)
      Some(currentCount + previousCount)
    }

    val sc = new SparkConf().setAppName("StatefulWordCount").setMaster("local[2]")
    val ssc = new StreamingContext(sc, Seconds(5)) //创建StreamingContext(5秒进行一次数据切割)
    ssc.checkpoint(".")

    //获取数据
    val lines = ssc.socketTextStream(host, port)
    val words = lines.flatMap(_.split(","))
    val wordCounts = words.map(x => (x, 1))

    //使用updateStateByKey来更新状态
    val stateDstream = wordCounts.updateStateByKey[Int](updateFunc)
    stateDstream.print()
    ssc.start()
    ssc.awaitTermination()
  }
}
