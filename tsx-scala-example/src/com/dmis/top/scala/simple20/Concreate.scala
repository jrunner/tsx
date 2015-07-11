package com.dmis.top.scala.simple20

/**
 * aiker
 * 2015/2/1
 *
 * Abstract的具体实现需要对每种抽象成员填入定义
 */
class Concreate extends Abstract {
  override type T = String

  //方法transform
  override def transform(x: T): T = x + x

  override val initial: T = "ypf"
  override var current: T = initial

  List
}
