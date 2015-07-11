package com.dmis.top.spark.simple

object Simple7 {
  def main(args: Array[String]) {
    println(multiTable());
  }

  //以序列形式返回一行乘法表
  def makeRowSeq(row: Int) = for (col <- 1 to 10) yield {
    val prod = (row * col).toString
    val padding = " " * (4 - prod.length)
    padding + prod
  }

  // 以字符串形式返回一行乘法表
  def makeRow(row: Int) = makeRowSeq(row).mkString

  //以字符串形式返回乘法表，记录占一行字符串
  def multiTable() = {
    val tableSeq = for (row <- 1 to 10) yield makeRow(row);

    tableSeq.mkString("\n")
  }
}






















