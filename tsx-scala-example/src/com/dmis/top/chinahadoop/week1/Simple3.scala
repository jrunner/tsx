package com.dmis.top.chinahadoop.week1

/**
 * aiker
 * 2015/2/18
 * 编写一个过程countdown(n:Int),打印n-1的数字,(n>1)
 */
object Simple3 {
  def main(args: Array[String]) {
    countdown(18);
  }

  def countdown(n: Int) = if (n > 0) 0.until(n).foreach(println)
}
