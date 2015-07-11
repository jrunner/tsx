package com.dmis.top.scala.simple27

import com.dmis.top.scala.simple27.database.SimpleDatabase

/**
 * aiker
 * 2015/2/7
 */
object Test {
  def main(args: Array[String]) {
    val apple = SimpleDatabase.foodNamed("Apple").get
    println(apple.name)

  }
}
