package com.dmis.top.spark.simple

object Simple6 {
  def main(args: Array[String]) {
    println(g())

    val firstArg = "A"

    var result = firstArg match {
      case "A" => "I am A"
      case "B" => "I am B"
      case "C" => "I am C"
      case _ => "what?"
    }
    
    println(result)
    
    
  }

  def g(): Int = try { 1 } finally {

  }
}