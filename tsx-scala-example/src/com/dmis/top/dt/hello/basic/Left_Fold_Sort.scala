package com.dmis.top.dt.hello.basic

/**
 * Created by Administrator on 2015/7/16.
 */
object Left_Fold_Sort {
  def main(args: Array[String]) {
    println((1 to 5).foldLeft(6)(_ + _))
    println((6 /: (1 to 5))(_ + _))

    println(((1 to 5) :\ 6)(_ + _))


    println(List(1, -2, 5, 6, 10).sortWith(_ > _))
  }
}
