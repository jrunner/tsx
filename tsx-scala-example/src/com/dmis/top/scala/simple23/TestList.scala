package com.dmis.top.scala.simple23

/**
 * aiker
 * 2015/2/4
 */
object TestList {
  def main(args: Array[String]) {
    val a1 = List(1, 2, 3, 4, 5);

    a1.filter(x => x != 3).map(x => x * 2).flatMap(x => x match{
        case 2 => List(2.1, 2.2, 2.3)
        case op => List(op)
      }
    ).foreach(println)
  }
}
