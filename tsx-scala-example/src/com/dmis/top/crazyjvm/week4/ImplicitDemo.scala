package com.dmis.top.crazyjvm.week4

import java.io.File

import scala.io.Source

/**
 * aiker
 * 2015/3/15
 */
object ImplicitDemo extends App {


  //new File("").read
  println("ok")

  import Context._

  AAA.print("ypf")("x")

  println(1.add2)
  println("ok!")
}

object AAA {
  def print(content: String)(implicit prefix: String) {
    println(prefix + ":" + content)
  }
}

class RichFile(file: File) {
  def read = Source.fromFile(file.getPath).mkString
}

object Context {
  implicit def file2RichFile(file: File): RichFile = new RichFile(file)

  implicit val xxx: String = "hello"

  implicit class HH(x: Int) {
    def add2 = x + 2
  }

}
