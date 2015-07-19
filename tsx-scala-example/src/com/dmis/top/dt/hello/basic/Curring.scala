package com.dmis.top.dt.hello.basic

/**
 * Created by Administrator on 2015/7/12.
 */
object Curring {
  def main(args: Array[String]) {
    val a = Array(1, 3)
    val b = Array(1, 3)

    println(a.corresponds(b)(_.equals(_)))
  }
}
