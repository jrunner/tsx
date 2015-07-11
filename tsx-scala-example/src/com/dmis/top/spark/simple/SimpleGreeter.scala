package com.dmis.top.spark.simple

/**
 * ypf
 * 2015/1/3
 */
class SimpleGreeter {
  val greeting = "Hello,World";

  def greet() = println(greeting)
}

object SimpleGreeter {
  def main(args: Array[String]) {
    val g = new SimpleGreeter()
    g.greet();
  }
}