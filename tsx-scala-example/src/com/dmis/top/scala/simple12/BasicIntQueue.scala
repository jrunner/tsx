package com.dmis.top.scala.simple12

import scala.collection.mutable.ArrayBuffer

/**
 * aiker
 * 2015/1/31
 */
class BasicIntQueue extends IntQueue {
  private val buf = new ArrayBuffer[Int]

  override def get(): Int = buf.remove(0)

  override def put(x: Int) = {
    buf += x
  }
}
