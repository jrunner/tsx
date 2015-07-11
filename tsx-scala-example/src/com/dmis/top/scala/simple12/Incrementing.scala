package com.dmis.top.scala.simple12

/**
 * aiker
 * 2015/1/31
 */
trait Incrementing extends IntQueue {
  abstract override def put(x: Int) {
    super.put(x)
  }
}

trait Filtering extends IntQueue {
  abstract override def put(x: Int) = {
    if (x >= 0) super.put(x)
  }
}