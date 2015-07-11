
package com.dmis.top.scala.simple30

import scala.actors.Actor

/**
 * Created by Administrator on 2015/3/23.
 */
object ActorTest2 extends App {
  Actor.receive {
    case msg => println("receive message:" + msg)
  }


  Actor.actor{
    Thread.sleep(1000)
    NameResolver !("127.0.0.2", this)
  }.start()

}

