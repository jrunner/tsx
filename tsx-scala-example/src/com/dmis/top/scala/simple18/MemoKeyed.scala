package com.dmis.top.scala.simple18

/**
 * aiker
 * 2015/2/1
 */
class MemoKeyed extends Keyed {
  private var keyCache: Option[Int] = None

  override def computeKey: Int = {
    if (!keyCache.isDefined) keyCache = Some(super.computeKey)
    keyCache.get
  }
}
