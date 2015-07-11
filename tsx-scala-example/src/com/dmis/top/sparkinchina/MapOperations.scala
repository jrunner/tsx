package com.dmis.top.sparkinchina

/**
 * Created by ypf on 2015/4/15.
 */
object MapOperations {

  def main(args: Array[String]) {
    val peoples = Map("ypf" -> 29, "jln" -> 28)

    for ((k, v) <- peoples) {
      println("k:" + k + ",v:" + v)
    }

    for ((k, _) <- peoples) {
      println("k:" + k )
    }

  }

}
