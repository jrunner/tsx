package com.dmis.top.scala.simple30

import java.net.{InetAddress, UnknownHostException}

import scala.actors.Actor

/**
 * Created by Administrator on 2015/3/23.
 */
object EctActor extends Actor {
  def getIp(name: String): Option[InetAddress] = {
    try {
      Some(InetAddress.getByName(name))
    } catch {
      case _: UnknownHostException => None
    }
  }

  override def act(): Unit = {
    loop {
      react {
        case (name: String, actor: Actor) => actor ! getIp(name)
      }
    }
  }
}
