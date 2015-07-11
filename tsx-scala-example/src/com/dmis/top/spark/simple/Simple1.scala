package com.dmis.top.spark.simple

/**
 * Aiker
 * 2015/1/7
 */
object Simple1 {
  def main(args: Array[String]) {
    printlnArgs(args);

    printlnArgsFunc(args);

    printlnArgsFunc2(args);

    formatArgs(args);
  }

  //指令式编程, 使用了var变量
  def printlnArgs(args: Array[String]): Unit = {
    var i = 0;
    while (i < args.length) {
      println(args(i));
      i += 1;
    }
  }

  //函数式编程,通过去掉变量val的办法把代码变得更像函数
  def printlnArgsFunc(args: Array[String]): Unit = {
    for (arg <- args) println(arg);
  }

  def printlnArgsFunc2(args: Array[String]): Unit = {
    args.foreach(println)
  }

  def formatArgs(args: Array[String]) = args.mkString("\n")
}
