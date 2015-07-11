package com.dmis.top.scala.simple7

/**
 * aiker
 * 2015/2/28
 */
class MatchTest {

}

object MatchTest {
  def main(args: Array[String]) {
    a1("ypf")
    a1("jln")
    a1("")
    println("---")
    println(a2("jln"))
  }

  def a1(arg: String) = {
    arg match {
      case "ypf" => println(this)
      case "jln" => println("I'm jiao luo na")
      case _ => println("error")
    }
  }

  def a2(arg: String) = {
    val v = arg match {
      case "ypf" => this + ""
      case "jln" => "I'm jiao luo na"
      case _ => "error"
    }
    v
  }
}