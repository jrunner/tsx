package com.dmis.top.scala.simple30

/**
 * Created by Administrator on 2015/3/24.
 */
class TestA {
  def act() {}

  def start(): Unit = {
    act()
  }

}

object Test {

  def receive[Int](f: PartialFunction[Any, Int]): Int = f(1)


  def main(args: Array[String]) {


    receive({
      case msg => println("receive message:" + msg)
    })



  }


}
