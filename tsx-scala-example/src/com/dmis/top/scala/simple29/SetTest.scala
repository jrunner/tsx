package com.dmis.top.scala.simple29

import org.junit.Test
import org.junit.Assert.assertEquals

/**
 * aiker
 * 2015/2/8
 */
class SetTest {

  @Test
  def testMultiAdd(): Unit ={
    val set = Set() + 1 + 2 + 3 + 4 + 5 + 6
    println(set.foreach(println))
    println();
    println(set.size)
    assertEquals(3,set.size)
  }

}
