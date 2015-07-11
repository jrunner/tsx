package com.dmis.top.spark.simple

/**
 * Administrator
 * 2015/1/3
 */
class FancyGreeter(greeting: String) {
  def greet() = println(greeting)
}

object FancyGreeter {
  def main(args: Array[String]) {
    val g = new FancyGreeter("Salutations, world")
    g.greet
  }
}