package com.dmis.top.scala.simple26

/**
 * aiker
 * 2015/2/7
 */
object Test {
  def main(args: Array[String]) {
    val yearMade = 1955
    val v = <a>
      {if (yearMade < 2000) <t>
        {yearMade}
      </t>
      else xml.NodeSeq.Empty}
    </a>

    println(v)

    val test = <a>
      {"hello" + ",world" + (5 + 5)}
    </a>
    println(test)
  }
}
