package com.dmis.top.spark.simple

import com.dmis.top.spark.simple.ChecksumAccumulator.calculate

object Summer {
  def main(args: Array[String]) {
    val arr = Array("a", "b", "c");
    for (a <- arr)
      println(a + "" + calculate(a))
  }
}