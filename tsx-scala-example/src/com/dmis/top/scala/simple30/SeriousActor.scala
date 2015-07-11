package com.dmis.top.scala.simple30

import scala.actors.Actor

/**
 * aiker
 * 2015/2/8
 */
object SeriousActor extends Actor{
  def act() {
    for (i <- 1 to 5) {
      println("to be or not to be. " + i)
      Thread.sleep(1000)
    }
  }

  def main(args: Array[String]) {
    SeriousActor.start();
  }
}
