package com.dmis.top.spark.simple

import java.io.File

object Simple5 {

  def main(args: Array[String]): Unit = {
    val filesHere = (new java.io.File("D:/test")).listFiles();
    val files = scalaFiles(filesHere);
    println(files.length)

    println(forLineLengthds(filesHere).length)
  }

  def scalaFiles(filesHere: Array[File]) = {
    for {
      file <- filesHere
      if file.getName().endsWith(".scala")
    } yield file
  }

  def forLineLengthds(filesHere: Array[File]) = {
    for {
      file <- filesHere
      if file.getName().endsWith(".scala");
      if file.isFile();

      line <- fileLines(file)
      trimmed = line.trim()
      if trimmed.matches(".*for.*")

    } yield trimmed.length()
  }

  def fileLines(file: File) = scala.io.Source.fromFile(file).getLines.toList
}