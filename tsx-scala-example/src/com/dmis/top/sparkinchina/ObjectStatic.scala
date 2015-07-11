package com.dmis.top.sparkinchina

/**
 * Created by ypf on 2015/4/16.
 */
class ObjectStatic {

}

object People {
  def getArgs(args: Array[String]): Unit = {
    println("println Args")
  }
}

object ObjectStatic {
  def main(args: Array[String]) {
    People.getArgs(args)
  }
}
