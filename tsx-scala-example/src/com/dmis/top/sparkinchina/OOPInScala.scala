package com.dmis.top.sparkinchina

/**
 * Created by ypf on 2015/4/14.
 */
class OOPInScala {

}

/**
 *
 * @param name 姓名 var和val生命可以被外界访问
 * @param age 年龄
 */
class Person(var name: String, val age: Int) {
  println("this is the person")

  var gender: String = _
  private var sex: String = _

  def this(name: String, age: Int, gender: String) {
    this(name, age)
    this.gender = gender
  }

  val University = "YPF"

  var a: String = _
  var b: String = null

  def sayHello(): Unit = {
    println(this.name + "," + this.age + "," + this.gender)
  }
}

class Student(name: String, age: Int, val major: String) extends Person(name, age) {
  println("this is student")
  override val University: String = "JLN"

  override def toString: String = "hello,this is student!"


}

/**
 * 方法都是静态类型的
 */
object OOPInScala {
  def main(args: Array[String]) {
    val s = new Student("aiker", 20, "computer")
    println(s.toString)
    println(s.University)

    val p = new Person("a", 11, "boy")
    println(p.a == p.b)
    p.sayHello()
    p.gender = "1";
    println()

  }
}
