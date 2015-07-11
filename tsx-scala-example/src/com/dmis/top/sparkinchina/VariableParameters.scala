package com.dmis.top.sparkinchina

/**
 * Created by ypf on 2015/4/15.
 */
class VariableParameters {

}

object VariableParameters {


  def helloSpark(name: String = "Spark"): Unit = {
    println(name)
  }

  def sum(args: Int*): Int = {
    var sum = 0;
    for (arg <- args)
      sum += arg
    println("sum:"+sum)
    sum
  }

  def sum(x: Int, y: Int): Int = {
    x + y
  }

  def main(args: Array[String]) {
    println(sum(1))
    println()
    println(sum(1, 2))
    println()
    println(sum(1, 2, 3))
  }
}
