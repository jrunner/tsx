package com.dmis.top.scala.simple

/**
 * aiker
 * 2015/1/25
 */
class LineElement(s: String) extends Element {

  val contents = Array(s);

  override val width = s.length;

  override val height = 1;

  override def demo() {
    println("LineElement's implementation invoked")
  }
}
