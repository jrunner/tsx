package com.dmis.top.dt.hello.basic

/**
 * Created by ypf on 2015/6/24.
 */
object MapOps {
  def main(args: Array[String]) {
    val peoples = Map("ypf" -> 29, "jln" -> 28)

    for ((k, v) <- peoples) {
      println("k:" + k + ",v:" + v)
    }

    for ((k, _) <- peoples) {
      println("k:" + k)
    }

  }

}
