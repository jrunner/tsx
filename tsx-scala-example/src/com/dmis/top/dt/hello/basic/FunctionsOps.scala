package com.dmis.top.dt.hello.basic

import scala.io.Source

/**
 * Created by yangpengfei on 2015/7/12.
 */
object FunctionsOps {
  def main(args: Array[String]) {
    processData("d:\\oraysl.status", 5)

    var increase = (x: Int) => x + 1
    increase(10)
    increase = (x: Int) => x + 999
    println(increase(2))

    val f = (_: Int) + (_: Int)
    println(f(5, 19))
  }

  def processData(filename: String, width: Int): Unit = {
    def processLine(line: String): Unit = {
      if (line.length > width)
        println(filename + ":" + line.length)
    }
    val source = Source.fromFile(filename)
    source.getLines().foreach(processLine(_))
  }
}
