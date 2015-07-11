package com.dmis.top.scala.simple12

/**
 * aiker
 * 2015/1/31
 */
object BasicIntQueueTest {
  def main(args: Array[String]) {

    println("----")
    val q = (new BasicIntQueue with Incrementing with Filtering)
    q.put(-2)
    q.put(1)
    q.put(3)
    println(q.get())
    println(q.get())
  }
}
