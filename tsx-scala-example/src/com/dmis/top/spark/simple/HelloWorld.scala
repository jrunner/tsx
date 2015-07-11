package com.dmis.top.spark.simple

/**
 * ypf
 * 2015/1/3
 */
object HelloWorld {
  def main(args: Array[String]) {
    println("Hello, world!")
    println(max(2, 1))
  }

  def max(x: Int, y: Int): Int = (
    if (x > y)
      x
    else
      y
    )

}