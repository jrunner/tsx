package com.dmis.top.crazyjvm.week3

/**
 * aiker
 * 2015/3/8
 */
class Test {

}

object LocalFunctionTest extends App {
  def add3(x: Int, y: Int, z: Int): Int = {
    def add2(x: Int, y: Int): Int = {
      x + y
    }

    add2(add2(x, y), z)
  }

  def add33(x: Int, y: Int, z: Int): Int = {
    def add2(): Int = {
      x + y
    }

    add2()
  }

  println(add33(1, 2, 3))
}
