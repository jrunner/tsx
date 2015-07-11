package com.dmis.top.spark.simple

/**
 * aiker
 * 2015/1/25
 */
object MyAssert {

  var assertionsEnable = true;

  def myAssert(predicate: () => Boolean): Unit = {
    if (assertionsEnable && !predicate()) {
      throw new AssertionError()
    }
  }

  def byNameAssert(predicate: => Boolean) =
    if (assertionsEnable && !predicate) {
      throw new AssertionError()
    }

  def byNameAssert1(predicate: Boolean) =
    if (assertionsEnable && !predicate) {
      throw new AssertionError()
    }

  def main(args: Array[String]) {
    myAssert(() => 5 > 3)
    byNameAssert(5 > 3)
    byNameAssert1(5 > 3)

    println("ok!")
  }

}
