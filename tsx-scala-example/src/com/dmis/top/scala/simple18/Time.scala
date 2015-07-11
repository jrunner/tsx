package com.dmis.top.scala.simple18

/**
 * aiker
 * 2015/2/1
 */
class Time {
  private[this] var h = 12

  private[this] var m = 12

  def hour: Int = h

  def minute: Int = m

  def hour_=(x: Int) {
    require(0 <= x && x < 24)
    h = x
  }

  def minute_=(x: Int) {
    require(0 <= x && x < 60)
    m = x
  }

  override def toString: String = hour + ":" + minute
}
