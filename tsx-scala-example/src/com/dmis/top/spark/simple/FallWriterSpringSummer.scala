package com.dmis.top.spark.simple

import com.dmis.top.spark.simple.ChecksumAccumulator.calculate

object FallWriterSpringSummer extends App {

  for (s <- List("fall", "winter", "spring"))
    println(s + ":" + calculate(s));

}