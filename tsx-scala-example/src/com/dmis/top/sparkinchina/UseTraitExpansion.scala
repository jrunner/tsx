package com.dmis.top.sparkinchina

/**
 * Created by ypf on 2015/4/18.
 */
class UseTraitExpansion {

}

trait Logger {
  def log(msg: String): Unit = {
    println("msg:" + msg)
  }
}

class ConsoleLogger extends Logger {
  def console(msg: String): Unit = {
    log(msg)
  }
}

trait TraitLogger {
  def log(msg: String): Unit = {
    println("TraitLogger msg::" + msg)
  }
}

trait ConcreateLogger {

  def log(msg: String): Unit = {
    println("ConcreateLogger msg::" + msg)
  }

}

class Text {

}

object UseTraitExpansion extends App {
  var log = new ConsoleLogger
  log.console("jiaojiao")

  var v = new Text with TraitLogger
  v.log("ypf")
}
