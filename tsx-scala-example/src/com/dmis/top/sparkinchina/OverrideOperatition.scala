package com.dmis.top.sparkinchina

/**
 * Created by ypf on 2015/4/16.
 */
class OverrideOperatition {

}

class PersonOverride(val name: String, val age: Int) {
  val school = "BJ"
}

class Worker(name: String, age: Int, salary: Long) extends PersonOverride(name, age) {
  println("This is subclass of Person,Primary construnct of worker")

  override val school = "SH"
}

object OverrideOperatition {
  def main(args: Array[String]) {
    val v = new Worker("ypf", 10, 1222)
    println(v.school)
  }
}
