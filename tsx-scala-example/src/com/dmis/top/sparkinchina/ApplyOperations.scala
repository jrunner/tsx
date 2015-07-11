package com.dmis.top.sparkinchina

/**
 * Created by ypf on 2015/4/16.
 */
class ApplyOperations {

}

class ApplyTest {
  def apply(): Unit = {
    println("class ApplyTest test!")
  }

  def sayHello(): Unit = {
    println("hello apply!")
  }
}

object ApplyTest {
  def apply() = new ApplyTest()


  def run(): Unit = {
    println("object ApplyTest run!")
  }
}

object ApplyTestT {
  def apply(): Unit = {
    println("object ApplyTestT test!")
  }
}

object ApplyOperations extends App {
  new ApplyTest()()

  val vv = new ApplyTest()
  vv()

  val v = new ApplyTest()
  val d = ApplyTest()

  println()
  ApplyTest;
  println()

  val e = ApplyTestT()
  val e1 = ApplyTestT()

  println("1.")
  ApplyTest()()//第一个()调到了object ApplyTest的apply方法,第二个()掉到了class ApplyClass的apply方法
  println("2.")
  ApplyTest() //只调到了object ApplyTest的apply方法
}
