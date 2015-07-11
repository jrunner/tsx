package com.dmis.top.sparkinchina

/**
 * Created by ypf on 2015/4/21.
 */
object UpperBounds {
  def main(args: Array[String]) {
    val c = new CompareUpper[String]("S1","S2");
    println(c.compare)
  }
}

class CompareUpper[T <: Comparable[T]](val num1: T, val num2: T) {
  def compare = if (num1.compareTo(num2) > 0) num1 else num2

}


