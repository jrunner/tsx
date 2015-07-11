package com.dmis.top.chinahadoop.week1

/**
 * aiker
 * 2015/2/18
 *
 * 一个数字如果为整数，则它的signum为1；如果为负数则signum为-1；如果为0，则signnum为0.编写一个函数计算这个值值
 */
object Simple1 {
  def main(args: Array[String]) {
    val s = signum(-8.2)
    println(s)
  }

  def signum(num: Double): Int = if (num > 0) 1 else if (num == 0) 0 else -1
}
