package com.dmis.top.scala.simple

/**
 * aiker
 * 2015/1/25
 */
class UniformElement(ch: Char, override val width: Int, override val height: Int) extends Element {

  private val line = ch.toString * width


  def invokeDemo(e: Element) {
    e.demo()
  }

  override def contents: Array[String] = Array()
}

