package com.dmis.top.sparkinchina.actor

import scala.actors.Actor

/**
 * Created by ypf on 2015/4/21.
 */
class ActorInScala {

}

object HeloActor extends Actor {
  override def act(): Unit = {
    while (true) {
      receive {
        case msg: Int => println("receive int:" + msg)
        case msg => println("receive:" + msg)
      }
    }
    for (i <- 1 to 10) {
      println(i)
      Thread.sleep(2 * 1000)
    }
  }


}

object ActorInScala {

  def main(args: Array[String]) {
    HeloActor.start()

    HeloActor ! "this is a actor"
    HeloActor ! "this is a actor1"
    HeloActor ! 2
    //    val sendactor = Actor.actor{
    //      for (i <- 1 to 10) {
    //        println(i)
    //        Thread.sleep(2 * 1000)
    //      }
    //    }
  }

}