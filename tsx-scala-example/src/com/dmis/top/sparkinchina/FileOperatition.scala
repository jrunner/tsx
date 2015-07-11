package com.dmis.top.sparkinchina

import scala.io.Source

/**
 * Created by ypf on 2015/4/19.
 */
object FileOperatition {

  def main(args: Array[String]) {
    val file = Source.fromURL("http://www.cpifcl.com/index.html")
    for (line <- file) {
      println(line)
    }
  }

  def testURL(): Unit ={
    val file = Source.fromURL("http://www.cpifcl.com/index.html")
    for (line <- file.getLines()) {
      println(line)
    }
  }

  def testFile(): Unit ={
    var file = Source.fromFile("D:/zk.txt")
    for (line <- file.getLines()) {
      println(line)
    }
  }

}
