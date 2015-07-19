package com.dmis.top.dt.hello.type_parameter

import scala.reflect.ClassTag

/**
 * Created by yangpengfei on 2015/7/16.
 */
class TypeParameterization {

}

class Triple[F: ClassTag, S, T](val f: F, val s: S, val t: T)

object TypeParameterization {
  def main(args: Array[String]) {
    val triple = new Triple("Spark", 3, 3.14)
    val bigdata = new Triple[String, String, Char]("Spark", "Hadoop", 'R')
    println(triple)
    println(bigdata)

    def getData[T](list: List[T]) = list(list.length / 2)

    println(getData(List("Spark", "scala", "python")))

    val f = getData[Int] _

    println(f(List(1, 2, 3, 4)))

    def foo[A, B](f: A => List[A], b: A) = f(b)

    println(foo((x: Int) => List(x), 2))
  }
}
