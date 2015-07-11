package com.dmis.top.scala.simple30

import scala.actors.Actor

/**
 * aiker
 * 2015/2/8
 */
object SillyActor extends Actor {
  def act() {
    for (i <- 1 to 50) {
      println("I'm acting " + i)
      Thread.sleep(1000)
    }
  }

  def main(args: Array[String]) {
    SillyActor.start();
    SeriousActor.start()
  }
}
