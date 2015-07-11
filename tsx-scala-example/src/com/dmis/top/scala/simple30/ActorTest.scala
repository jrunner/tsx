package com.dmis.top.scala.simple30

import scala.actors.Actor._

/**
 * aiker
 * 2015/2/8
 */
object ActorTest extends App {
  val echoActor = actor {
    for (i <- 1 to 5) {
      println("to be or not to be. " + i)
      Thread.sleep(1000)
    }
  }
}
