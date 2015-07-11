package com.dmis.top.scala.simple29

import java.util

/**
 * aiker
 * 2015/2/8
 */
abstract class SetAndType {
  type Elem

  val set: Set[Elem]

  def javaSet2ScalaSet[T](jset: util.Collection[T]): SetAndType = {
    var sset = Set.empty[T]

    val iter = jset.iterator();
    while (iter.hasNext) {
      sset += iter.next()
    }

    return new SetAndType {
      type Elem = T
      val set: Set[Elem] =sset
    }
  }
}


