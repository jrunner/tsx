package com.dmis.top.scala.simple12

/**
 * aiker
 * 2015/1/29
 */
class Frog extends Animal with Philosophical with HasLegs {
  override def toString = "green"

  override def philosophize() {
    println("It's aim't easy being," + toString + "!");
  }
}
