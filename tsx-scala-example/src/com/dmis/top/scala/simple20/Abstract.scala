package com.dmis.top.scala.simple20

/**
 * aiker
 * 2015/2/1
 */
trait Abstract {
  //类型T
  type T

  //方法transform
  def transform(x: T): T

  //不可变字面量
  val initial: T
  //可变字面量
  var current: T
}
