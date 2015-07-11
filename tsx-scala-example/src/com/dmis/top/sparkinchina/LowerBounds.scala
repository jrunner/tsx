package com.dmis.top.sparkinchina

/**
 * Created by ypf on 2015/4/21.
 */
object LowerBounds {

  def main(args: Array[String]) {

    val t1 = new TeacherBounds(30)
    val t2 = new TeacherBounds(20)

    val p = new PersonBounds(40)
    val s = new StudentBounds(40)

    val cc = new CompareLower(t1, t2);

    println(cc.replace(p))
    println(cc.replace(s))
  }
}

class CompareLower[T](val num1: T, val num2: T) {
  def replace[U >: T](f: U) = new CompareLower(f, num2)
}

class PersonBounds(ID: Int)

class TeacherBounds(ID: Int) extends PersonBounds(ID)

class StudentBounds(ID: Int) extends PersonBounds(ID)

