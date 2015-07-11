package com.dmis.top.crazyjvm.week2

/**
 * aiker
 * 2015/3/6
 */
class Basic4 {

}

class AppTest {
  def apply() = println("class AppTest apply")

  def test(): Unit = {
    println("class AppTest test")
  }
}

object AppTest {
  def apply() = println("object AppTest apply")

  def static {
    println("I'am static")
  }

  def test(): Unit = {
    println("object AppTest test")
  }
}

object Basic4 {
  def main(args: Array[String]) {
    AppTest.static
    AppTest.test()
    println("------------")
    val v = AppTest
    v.test()
    v();
    println("-----------")
    val t = new AppTest()
    t.test()
    t()
  }
}
