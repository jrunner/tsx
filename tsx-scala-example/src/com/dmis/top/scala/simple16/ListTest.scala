package com.dmis.top.scala.simple16

/**
 * aiker
 * 2015/1/31
 */
object ListTest {
  def main(args: Array[String]) {
    var list = List(2, 5, 19, 19, 3, 1);
    val v = isort(list)
    println(v)
    println(sum(v))
    println(product(v))

    println(("0" /: v)(_ + "=" + _))

    println(v.sortWith(_ < _))

  }

  def isort(xs: List[Int]): List[Int] = {
    if (xs.isEmpty)
      Nil
    else {
      insert(xs.head, isort(xs.tail));
    }
  }

  def insert(x: Int, xs: List[Int]): List[Int] = {
    if (xs.isEmpty || x <= xs.head)
      x :: xs
    else
      xs.head :: insert(x, xs.tail)
  }

  def sum(xs: List[Int]): Int = (0 /: xs)(_ + _)

  def product(xs: List[Int]): Int = (1 /: xs)(_ * _)
}
