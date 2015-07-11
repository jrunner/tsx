package com.dmis.top.crazyjvm.week1

/**
 * aiker
 * 2015/3/3
 */
object Test {

  def main(args: Array[String]) {
    val a = Array(5, 2, 3, 1, 15)
    for (i <- 0 until a.length)
      println(a(i))

    for (i <- a)
      println(a)

    val m = Map("AA" -> 20, "BB" -> 12, "CC" -> 29)
    for ((k, v) <- m) {
      println(k + ":" + v)
    }
  }

}
