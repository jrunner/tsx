package com.dmis.top.sparkinchina

/**
 * Created by ypf on 2015/4/22.
 */
abstract class SumTemplate[T] {
  def add(x: T, y: T): T

  def unit: T
}


object ImplicitObjectOperatitions {
  def main(args: Array[String]) {
    implicit object SumString extends SumTemplate[String] {
      override def add(x: String, y: String): String = x concat y

      override def unit: String = ""
    }

    implicit object SumInt extends SumTemplate[Int] {
      override def add(x: Int, y: Int): Int = x + y

      override def unit: Int = 0
    }

    implicit def sum[T](list: List[T])(implicit template: SumTemplate[T]): T = {
      if (list.isEmpty)
        template.unit
      else
        template.add(list.head, sum(list.tail))
    }


    println(sum(List(1,2,3)))
    println(sum(List("yang","pengfei")))
  }
}
