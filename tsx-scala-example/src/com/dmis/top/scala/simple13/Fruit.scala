package com.dmis.top.scala.simple13

/**
 * aiker
 * 2015/1/31
 */
abstract class Fruit(s: String, c: String) {
  val name: String = s;
  val color: String = c;
}

object Fruit {

  object Apple extends Fruit("apple", "red")

  object Orange extends Fruit("orange", "orange")

  object Pear extends Fruit("Pear", "yellowish")

  val menu = List(Apple, Orange, Pear)

  def showFruit(fruit: Fruit): Unit = {
    import fruit._
    println(name + " are " + color)
  }

  def main(args: Array[String]) {
    showFruit(Fruit.Apple)
    showFruit(Fruit.Orange)
  }

}
