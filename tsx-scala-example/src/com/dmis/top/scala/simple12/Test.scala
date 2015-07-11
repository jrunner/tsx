package com.dmis.top.scala.simple12

/**
 * aiker
 * 2015/1/29
 */
object Test {
  def main(args: Array[String]) {
    var f = new Frog;
    println(f)
    val phil: Philosophical = f
    println("===============")
    phil.philosophize()
    println("===============")
    f.hasLegs()
  }
}
