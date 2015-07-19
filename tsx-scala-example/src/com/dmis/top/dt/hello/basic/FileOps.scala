package com.dmis.top.dt.hello.basic

import java.io.{File, PrintWriter}

import scala.io.Source

/**
 * Created by ypf on 2015/6/24.
 */
object FileOps {
  def main(args: Array[String]) {

    val file = Source.fromURL("http://bill.jr.jd.com/buy/list.htm?from=jrad_91774&loc=2")
    for (line <- file.getLines())
      println(line)
    file.close()

    println("文件输出")
    println(new File("test.txt").getAbsolutePath)
    val writer = new PrintWriter(new File("test.txt"))
    1.to(10).foreach(writer.println(_))
    writer.close()

    println("控制台输入：")
    val v = Console.readLine()
    println("结果:" + v)
  }
}
