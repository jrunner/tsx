package com.dmis.top.sparkinchina

/**
 * Created by ypf on 2015/4/21.
 */
object Variance {
  def main(args: Array[String]) {
    val obj:Object = "hello,spark!";
    val s:String = "hello,spark!";
    new Variance[Object](100).fun(s)
  }
}

class Variance[-T](t: Int) {
  def fun(t: T): Unit = {
    println(t)
  }
}
