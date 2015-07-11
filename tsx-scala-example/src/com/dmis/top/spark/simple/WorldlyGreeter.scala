package com.dmis.top.spark.simple

/**
 * Administrator
 * 2015/1/3
 */
class WorldlyGreeter(greeting: String) {
  def greet() = {
    val worldlyGreeting = WorldlyGreeter.worldify(greeting)
    println(worldlyGreeting)
  }
}

object WorldlyGreeter {
  def worldify(s: String) = s + ", world!"
}

object WorldlyApp {
  def main(args: Array[String]) {
    val wg = new WorldlyGreeter("Hello")
    wg.greet()
  }
}