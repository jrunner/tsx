package com.dmis.top.spark.simple

import scala.io.Source

object Simple8 {
  def main(args: Array[String]) {
    val filename = "d:\\zk.txt";
    val width = 55;
    processFile(filename, width);
  }

  def processFile(filename: String, width: Int) {
    val source = Source.fromFile(filename)
    for (line <- source.getLines) processLine(filename, width, line)
  }

  def processLine(filename: String, width: Int, line: String) {
    if (line.length() > width)
      println(filename + ":" + line.trim()+":"+line.length())
  }
}