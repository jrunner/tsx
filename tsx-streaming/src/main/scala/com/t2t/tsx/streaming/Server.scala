package com.t2t.tsx.streaming

import java.net.{Socket, ServerSocket}


/**
 * Created by ypf on 2014/12/28.
 */

import java.net._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent._

object Server {

  //接收处理client请求
  def handleClient(s: Socket): Unit = {
    val in = s.getInputStream
    val out = s.getOutputStream
    while (s.isConnected) {
      val buffer = Array[Byte](4)
      in.read(buffer)
      out.write("Pong".getBytes)
    }
  }

  def main(args: Array[String]) {
    val server = new ServerSocket(1202)
    while (true) {
      val s: Socket = server.accept()
      println(s.getPort)
      future {
        handleClient(s)
      }
    }
  }
}
