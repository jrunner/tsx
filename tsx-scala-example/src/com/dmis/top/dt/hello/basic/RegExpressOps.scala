package com.dmis.top.dt.hello.basic

/**
 * Created by yangpengfei on 2015/7/11.
 */
object RegExpressOps {
  def main(args: Array[String]) {
    val regex = """([0-9]+)""".r
    val numPattern = "[0-9]+".r

    regex.findAllIn("yangpengfei1343jiaoluona15210").foreach(println)

    val numitemPattern = "([0-9]+) ([a-z]+)".r
    val numitemPattern(num, item) = "99 hadoop"

    "2379 scala" match {
      case numitemPattern(num, item) => println(num + "--" + item)
      case _ => println("none")
    }
  }
}
