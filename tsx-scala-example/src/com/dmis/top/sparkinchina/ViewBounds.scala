package com.dmis.top.sparkinchina

/**
 * Created by ypf on 2015/4/21.
 */
object ViewBounds {
  def main(args: Array[String]) {
    val c = new CompareView[Int](1,2);
    println(c.compare)
  }
}

class CompareView[T <% Comparable[T]](val num1: T, val num2: T) {
  def compare = if (num1.compareTo(num2) > 0) num1 else num2

}
