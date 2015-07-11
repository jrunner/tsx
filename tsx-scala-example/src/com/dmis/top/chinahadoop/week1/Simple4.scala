package com.dmis.top.chinahadoop.week1

/**
 * aiker
 * 2015/2/18
 * 编写一个循环，将整数数组中的相邻元素置换，如: Array(1,2,3,4,5)变为Array(2,1,4,3,5)
 */
object Simple4 {
  def main(args: Array[String]) {
    val a = Array(1, 2, 5, 4, 3)
    val result = for (i <- 0 until a.size) yield {
      //偶数数组
      if (a.size % 2 == 0) {
        if (i % 2 == 0) a(i + 1) else a(i - 1)
      }
      //奇数数组
      if (a.size % 2 != 0) {
        if (i == a.size - 1) a(i)
        else if (i % 2 == 0) a(i + 1)
        else a(i - 1)
      }
    }
    println(result)
  }
}
