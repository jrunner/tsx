package com.dmis.top.scala.simple30

import scala.actors.Actor._

/**
 * aiker
 * 2015/2/8
 */
object ActorTest1 extends App {
  val echoActor = actor {
    while (true) {
      receive {
        case msg => println("receive message:" + msg)
      }
    }
  }

  echoActor ! "ypf"
  echoActor ! "ypf1"
}
