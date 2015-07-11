package com.dmis.top.scala.simple24

/**
 * aiker
 * 2015/2/6
 */
object UpperCase {

  //是否为大写
  def unapply(s:String):Boolean = s.toUpperCase == s

  def main(args: Array[String]) {
    val v = new Test();
    v.getVv;

    println(Twice("xy"))
    //println("q" @ UpperCase())

    println(UpperCase.unapply("AA"))

    println(userTwiceUpper("XYZ1XYZ1@163.com"))
  }

  def userTwiceUpper(s:String) = s match {
    case EMail(Twice(x @ UpperCase()), domain) => "match:" + x +" in domain " + domain
    case _ => "no match"
  }
}
