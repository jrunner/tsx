package com.dmis.top.crazyjvm.week2

/**
 * aiker
 * 2015/3/4
 */
class Basic2 {

}

class Person {
  val age = 10
  var name: String = _
  var sex: String = "男"

  private var test = "haha"
  private[this] var test1 = "haha1"
}

object Person {
  def main(args: Array[String]) {
    val p = new Person
    p.name = "ypf"
    p.sex = "boy"
    p.test
    println(p)
  }
}


class Person21 {
  def this(age: Int, name: String) {
    this
  }
}

class Person22(age: Int, val name: String) {
  var gender: String = _

  def this(age: Int, name: String, gender: String) {
    this(age, name)
    this.gender = gender
  }
}