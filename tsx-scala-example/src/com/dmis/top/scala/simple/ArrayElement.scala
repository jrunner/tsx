package com.dmis.top.scala.simple

/**
 * aiker
 * 2015/1/25
 */
class ArrayElement(args: Array[String]) extends Element {

  override def demo() {
    println("ArrayElement's implementation invoked")
  }

  final def hello(): Unit = {
    println("hello!")
  }

  override def contents: Array[String] = args;
}
