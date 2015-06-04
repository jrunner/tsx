package com.topsec.tss.sql

import java.io.{PrintWriter, OutputStreamWriter, IOException, BufferedOutputStream}
import java.util.concurrent.{TimeUnit, Executors}
import java.net.ServerSocket

/**
 * ypf
 * 测试时间：2015-01-02
 * 测试结果：ok
 * 参数：10110 3000
 */
object LoggerAgentServer {

  def generateContent(index: Int): String = {
    import scala.collection.mutable.ListBuffer
    val charList = ListBuffer[Char]()
    for (i <- 65 to 90) {
      charList += i.toChar
    }
    val charArray = charList.toArray
    charArray(index).toString
  }

  def index = {
    import java.util.Random
    val rdm = new Random
    //rdm.nextInt(26)
    rdm.nextInt(7)
  }

  def main(args: Array[String]) {
    if (args.length != 2) {
      System.err.println("Usage: <port> <millisecond>")
      System.exit(1)
    }

    println("start...")
    val server = new ServerSocket(args(0).toInt)
    println("created socket");

    val x1: Int = 0;

    while (true) {
      //x1 += 1;
      println("go:" + x1);

      val thread: Thread = new Thread() {
        println("Thread:" + run + x1);

        override def run() = {
          val socket = server.accept()
          println("Got client connected from: " + socket.getInetAddress)
          val out = new PrintWriter(socket.getOutputStream(), true)
          while (true) {
            Thread.sleep(args(1).toLong)
            val content = generateContent(index)
            println(content)
            out.write(content + '\n')
            out.flush()
          }
          socket.close()
        }
      }
      println("thread.start()");
      thread.start();
    }
  }
}