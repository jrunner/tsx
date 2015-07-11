package com.dmis.top.scala.simple29

import org.junit.{Test, Ignore}

/**
 * aiker
 * 2015/2/8
 */
object Tests {
  @Ignore
  def testData = List(0,1,-1,5,-5)

  @Test
  def test1: Unit ={
    assert(testData ==(testData.head::testData.tail))
  }

  def test2: Unit ={
    assert(testData.contains(testData.head))
  }
}
