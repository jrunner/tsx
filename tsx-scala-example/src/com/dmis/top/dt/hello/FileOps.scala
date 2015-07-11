package com.dmis.top.dt.hello

import scala.io.Source

/**
 * Created by ypf on 2015/6/24.
 */
object FileOps {
  def main(args: Array[String]) {
    val file = Source.fromURL("http://bill.jr.jd.com/buy/list.htm?from=jrad_91774&loc=2")
    for (line <- file.getLines())
      println(line)
  }
}
