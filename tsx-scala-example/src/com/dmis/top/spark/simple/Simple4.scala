package com.dmis.top.spark.simple

import java.io.File

object Simple4 {

  def main(args: Array[String]): Unit = {
    println(gcdLoop(15, 17))

    val fileHere = (new java.io.File("D:/test")).listFiles();
    for (file <- fileHere)
      println(file)

    println("---------")
    for (i <- 1 until 4)
      println(i)

    println("---------")
    for (
      i <- 0 to fileHere.length - 1 if (fileHere(i).getName().endsWith("c")); if (fileHere(i).getName().endsWith("c"))
    ) println(fileHere(i))

    println("---------")

    grep(".*gcd.*", fileHere)
  }

  def grep(pattern: String, fileHere: Array[File]) = {
    for (
      file <- fileHere if file.getName().endsWith(".scala");
      if file.isFile();
      line <- fileLines(file) if line.trim().matches(pattern)
    ) println(file + ":" + line.trim())
  }

  def fileLines(file: File) = scala.io.Source.fromFile(file).getLines.toList

  def gcdLoop(x: Long, y: Long): Long = {
    var a = x;
    var b = y;
    while (a != 0) {
      var temp = a;
      a = b % a;
      b = temp;
    }
    b
  }

}