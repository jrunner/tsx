package com.dmis.top.crazyjvm.week2

/**
 * aiker
 * 2015/3/4
 */
abstract class Human() {
  def say

  val gender: String = ""
}

class Person3(val name: String, val age: Int) extends Human {
  println("Person3  init")

  override val gender: String = "男"

  def say {
    println("say:" + name)
  }
}

class Student3(val n: String, val a: Int, val g: String) extends Person3(n, a) {
  println("Student3 init")

  override def say {
    println("student say:" + name)
  }
}

object Person3 extends App {
  val p = new Person3("pp", 30)
  p.say

  val s = new Student3("ss", 10, "男")
  s.say
}
