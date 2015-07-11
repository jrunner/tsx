package com.dmis.top.spark.simple

import scala.io.Source

/**
 * aiker
 * 2015/1/8
 *
 * 从文件中读取文本
 */
object Simple2 {

  def main(args: Array[String]) {
    val filename = "d:\\zk.txt"
    val file = Source.fromFile(filename, "GBK");

    val lines = Source.fromFile(filename, "GBK").getLines().toList;
    //println(lines);

    var maxLength = 0;
    for (line <- lines)
      maxLength = maxLength.max(winthOfLength(line));

    println(maxLength)
    println("-------");

    val longestLine = lines.reduceLeft(
      (a, b) => if (a.length > b.length) a else b)
    println(winthOfLength(longestLine));
    // for (line <- Source.fromFile(filename, "GBK").getLines()) println(line);

    println("-------");
    for (line <- lines) {
      val numSpaces = maxLength - winthOfLength(line);
      val padding = " " * numSpaces;

      println(padding + line.length() + "|" + line);
    }

  }

  def winthOfLength(s: String) = s.length;

}
