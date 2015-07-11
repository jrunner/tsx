package com.dmis.top.scala.simple12

/**
 * aiker
 * 2015/1/31
 */
trait CharSequence {
  def chartAt(index: Char): Char

  def length: Int

  def subSequence(start: Int, end: Int)

  def toString: String
}
