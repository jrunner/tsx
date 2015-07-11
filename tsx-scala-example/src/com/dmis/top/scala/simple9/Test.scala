package com.dmis.top.scala.simple9

import java.io.{PrintWriter, File}
import java.util.Date

/**
 * aiker
 * 2015/2/18
 */
object Test {
  def main(args: Array[String]) {
    val file = new File("""D:\test.txt""")
    withPrint(file)(w => w.println(new Date()))
    println("ok")

  }

  def withPrint(file: File)(op: PrintWriter => Unit) {
    val writer = new PrintWriter(file)
    op(writer)
    writer.close()
  }

}
