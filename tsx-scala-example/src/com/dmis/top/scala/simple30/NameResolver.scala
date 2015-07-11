package com.dmis.top.scala.simple30

import java.net.{UnknownHostException, InetAddress}

import scala.actors.Actor

/**
 * aiker
 * 2015/2/8
 */
object NameResolver extends Actor {
  def act(): Unit = {
    react {
      case (name: String, actor: Actor) =>
        sender ! getIp(name)
        act()
      case "exit" =>
        println("退出")
      case msg =>
        println("unhandled message:" + msg)
        act()
    }
  }

  def getIp(name: String): Option[InetAddress] = {
    try {
      Some(InetAddress.getByName(name))
    } catch {
      case _: UnknownHostException => None
    }
  }

  def main(args: Array[String]) {
    println("start...")
    NameResolver.start()
    NameResolver !("www.baidu.com", Actor.self)
    println("end!")
    NameResolver !("exit", Actor.self)
    NameResolver !("127.0.0.1", Actor.self)

    Actor.self.receiveWithin(10 * 1000) { case x => println("receiveWithin:" + x) }

    //NameResolver !("127.0.0.2", this)
  }
}
