package com.dmis.top.dt.hello.basic

import scala.collection.immutable.TreeMap
import scala.collection.mutable

/**
 * Created by Administrator on 2015/7/16.
 */
object Map_Set_Ops {
  def main(args: Array[String]) {
    val data = mutable.Set.empty[Int]
    data ++= List(1, 2, 3)
    data += 3
    println(data)
    data.clear()
    println(data)

    val map = mutable.Map.empty[String, String]
    map += ("a" -> "xx")
    println(map)

    val treeset = mutable.TreeSet(3, 1, 5, 0)
    println(treeset)

    val treemap = TreeMap("a" -> "xxx", "c" -> "ypf", "b" -> "jln")
    println(treemap)
  }
}
