package com.dmis.top.sparkinchina.actor

import java.net.{InetAddress, UnknownHostException}

import com.dmis.top.sparkinchina.actor.HeloActor._

import scala.actors.Actor

/**
 * aiker
 * 2015/2/8
 */
object HelloActor extends Actor {
  override def act(): Unit = {
    while (true) {
      receive {
        case msg: Int => println("receive int:" + msg)
        case msg => println("receive:" + msg)
      }
    }
  }
}

object NameResolverActor extends Actor {
  def act(): Unit = {
    react {
      case Net(name: String, actor: Actor) => sender ! getIp(name)
      case "exit" => println("退出")
      case msg => println("unhandled message:" + msg)
        act
    }
  }

  def getIp(name: String): Option[InetAddress] = {
    try {
      Some(InetAddress.getByName(name))
    } catch {
      case _: UnknownHostException => None
    }
  }

}

case class Net(name:String,actor:Actor)
object ActorOperatition {
  def main(args: Array[String]) {
    println("start...")
    NameResolverActor.start
    NameResolverActor !("www.baidu.com", Actor.self)
    println("end!")

    Actor.self.receiveWithin(10 * 1000) { case x => println("receiveWithin:" + x) }

    HelloActor.start

    //NameResolver !("127.0.0.2", this)
  }
}
