package com.t2t.tsx

/**
 * Created by yangpengfei on 2015/7/6.
 */
class Persion(val name: String, val age: Int) {
  println("this is constructor of person")

  val school = "t2t"

  def sleep1(): String = {
    return " 8 hours"
  }

  def sleep2(): String = {
    return " 9 hours"
  }

  override def toString: String = "I am  persion"
}

class Worker(name: String, age: Int, val scalary: Long) extends Persion(name, age) {
  println("this is constructor of worker")
  override val school: String = "Spark"

  override def toString: String = "I am  worker"
}

object OverridOper {
  def main(args: Array[String]) {
    val w = new Worker("spark", 6, 10000)
        println(w.school)
        println(w.sleep)
  }
}