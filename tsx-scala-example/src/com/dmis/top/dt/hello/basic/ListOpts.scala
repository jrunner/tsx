package com.dmis.top.dt.hello.basic

/**
 * Created by Administrator on 2015/7/16.
 */
object ListOpts {
  def main(args: Array[String]) {
    println(List.apply(1, 2, 3))
    println(List.make(3, 5))
    println(List.range(1, 4))
    println(List.range(4, 1, -1))

    println("abcd".toList.zip(List(1, 2)))
    println(List.concat(List(1, 2), List(2)))

    print(List.map2(List(2, 4), List(3, 6))(_ * _))
  }
}
