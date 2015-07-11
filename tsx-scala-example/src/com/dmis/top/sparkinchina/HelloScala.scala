package com.dmis.top.sparkinchina

/**
 * Created by ypf on 2015/4/15.
 */
class HelloScala {

}

object HelloScala {
  def main(args: Array[String]) {
    val n = 99

    try {
      val half = if (n % 2 == 0) n / 2 else throw new RuntimeException("N must be event!")
    }
    catch {
      case e:Exception => println("有问题，我知道了。" + e.getMessage)
    }

    println("ok")
  }

  def doWhile(): Unit = {
    var line = ""
    do {
      line = "1";
      println(line)
    } while (line != "")
  }
}