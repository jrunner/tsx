package com.dmis.top.scala.simple24

/**
 * aiker
 * 2015/2/5
 */
object EMail {

  def apply(user: String, domain: String) = user + "@" + domain

  def unapply(str: String): Option[(String, String)] = {
    val parts = str.split("@")
    if (parts.length == 2) Some(parts(0), parts(1)) else None
  }

  def main(args: Array[String]) {
    val v = EMail.unapply("yangpengfei@topsec.com")
    v.foreach(x => println(x._1))
    println(v.get._1)
    println(v.get._2)

    EMail.unapply(EMail("yang","com.cn")).foreach(x => println(x._2))
  }

}
