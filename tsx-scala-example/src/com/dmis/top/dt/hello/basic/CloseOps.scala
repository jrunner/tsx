package com.dmis.top.dt.hello.basic

/**
 * Created by Administrator on 2015/7/12.
 */
object CloseOps {
  def main(args: Array[String]) {
    def add(more: Int) = {
      println(more)
      (x: Int) => more + x
    }
    val a = add(2)
    println(a(3))

    def added(more: Int) =  (x: Int) => more + x
    println(added(5)(8))
  }
}
