package com.t2t.tsx.streaming

import java.net._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent._
import scala.concurrent.duration._

object Client {

  def ping(timesToPing: Int): Unit = {
    val socket = new Socket("w22.node", 1202)
    val out = socket.getOutputStream
    val in = socket.getInputStream
    for (i <- 0 until timesToPing) {
      out.write("Ping".getBytes)
      val buffer = Array[Byte](4)
      in.read(buffer)
    }
    socket.close
  }

  def main(args: Array[String]) {
    var totalPings = 1000
    var concurrentConnections = 10
    var pingsPerConnection: Int = totalPings / concurrentConnections
    var actualTotalPings: Int = pingsPerConnection * concurrentConnections

    val t0 = (System.currentTimeMillis()).toDouble
    var futures = (0 until concurrentConnections).map { _ =>
      future(ping(pingsPerConnection))
    }

    Await.result(Future.sequence(futures), 1 minutes)
    val t1 = (System.currentTimeMillis()).toDouble
    println("时间:" + 1000 * (t1 - t0) / actualTotalPings)
  }
}