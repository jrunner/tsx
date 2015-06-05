/*
 * ypf
 */
package com.topsec.tss.spark

import scala.util.Random


object LocalPi {
  def main(args: Array[String]) {


    var count = 1
    for (i <- 1 to 100000) {
      val x = Random.nextInt(10) * 2 - 1
      val y = Random.nextInt(100) * 2 - 1
      if (x * x + y * y < 1) count += 1
    }
    println("Pi is roughly " + 4 * count / 100000.0)

  }
}
