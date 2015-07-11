package com.dmis.top.crazyjvm.week3

/**
 * aiker
 * 2015/3/10
 */
object LocalFunction extends App {
  def test(flag: => Boolean): Unit = {
    println(flag)
  }

  def test1(flag: Boolean): Unit = {
    println(flag)
  }

  test(1 > 2)
  test1(1 > 2)
}
