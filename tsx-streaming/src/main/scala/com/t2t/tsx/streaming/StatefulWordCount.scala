package com.t2t.tsx.streaming

import org.apache.spark.{SparkContext, SparkConf}
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.streaming.StreamingContext._

/**
 * title：
 * auther：ypf
 * 测试时间：2015-07-06
 * 测试结果：ok
 * 参数：127.0.0.1 10110
 */
object StatefulWordCount {

  def main(args: Array[String]) {

    println("参数：" + args.mkString("\t"))

    val updateFunc = (values: Seq[Int], state: Option[Int]) => {
      val currentCount = values.foldLeft(0)(_ + _)
      val previousCount = state.getOrElse(0)
      Some(currentCount + previousCount)
    }

    val conf = new SparkConf().setAppName("StatefulWordCount").setMaster("local[2]")
    val sc = new SparkContext(conf)

    //创建StreamingContext
    val ssc = new StreamingContext(sc, Seconds(5))
    ssc.checkpoint(".")

    //获取数据
    val lines = ssc.socketTextStream(args(0), args(1).toInt)
    val words = lines.flatMap(_.split(","))
    val wordCounts = words.map(x => (x, 1))

    //使用updateStateByKey来更新状态
    val stateDstream = wordCounts.updateStateByKey[Int](updateFunc)
    stateDstream.print()
    ssc.start()
    ssc.awaitTermination()
  }
}
