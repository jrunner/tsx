package com.dmis.top.crazyjvm.week1

/**
 * aiker
 * 2015/3/2
 */
object WeekOne {
  def add(x: Int, y: Int): Int = {
    println(x + "," + y)
    x + y
  }

  def add() = {
    println("say hello")
  }

  def add(els: Int*) = {
    var v = 0;
    els.foreach(a => v = v + a)
    v
  }

  def main(args: Array[String]) {
    println(add(1, 2, 3))
    println("----5")
    println(add(x = 2, y = 3))
    println(add(y = 3, x = 2))
    println(add())
    println(add(2, 3))
    add

    for (i <- Range(1, 10, 2) if (i == 5 || i == 7))
      println(i)

    sayName("jln")
    sayName()
  }

  def sayName(name: String = "ypf"): Unit = {
    println("hello," + name)
  }
}
