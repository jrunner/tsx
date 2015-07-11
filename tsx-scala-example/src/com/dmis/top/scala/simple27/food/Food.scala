package com.dmis.top.scala.simple27.food

/**
 * aiker
 * 2015/2/7
 */
abstract class Food(val name: String) {
  override def toString = name;
}


object Apple extends Food("Apple")

object Orange extends Food("Orange")

object Cream extends Food("Cream")

object Sugar extends Food("Sugar")
