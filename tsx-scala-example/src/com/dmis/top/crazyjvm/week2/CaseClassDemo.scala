package com.dmis.top.crazyjvm.week2

/**
 * aiker
 * 2015/3/8
 */
object CaseClassDemo extends App {
  def m(p: PersonDemo): Unit = {
    p match {
      case TeacherDemo(_) => println("this is TeacherDemo")
      case StudentDemo("A") => println("this is StudentDemo")
      case StudentDemo(_) => println("this is StudentDemo _")
      case _ => println("no match")
    }
  }

  m(StudentDemo("AB"))

  val mm = Map(1 -> 10)
  mm.get(1) match {
    case Some(op) => println(op)
    case None => println("no match key")
  }

  mm.get(10) match {
    case Some(op) => println(op)
    case None => println("no match key")
  }
}

abstract class PersonDemo

case class TeacherDemo(name: String) extends PersonDemo

case class StudentDemo(name: String) extends PersonDemo



