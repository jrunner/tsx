package com.dmis.top.scala.simple16

/**
 * aiker
 * 2015/1/31
 */
object Test1 {
  def main(args: Array[String]) {
    val v = List(1, 3, 4, 5);
    println(v.map(_ + 1))
    val vv = List("ypf","2")
    println(vv.flatMap(_.split(" ")))
  }
}
