package com.dmis.top.crazyjvm.week4

/**
 * aiker
 * 2015/3/15
 */
object Bounds extends App {

  val p = new Pair("A", "B")
  println(p.smaller())

  val s1 = new Student("A")
  val s2 = new Student("B")

  //val p1 = new Pair[Person](s1, s2)
  //println(p1.replaceFirst(p1))
}

class Pair[T <: Comparable[T]](val a: T, val b: T) {
  def smaller() = if (a.compareTo(b) < 0) a else b

  //def replaceFirst[R >: T](newFirst: R) = new Pair(newFirst, b)
}

class Person[T](name: String, age: Int) {

}

class Student(name: String) extends Person(name, 1)