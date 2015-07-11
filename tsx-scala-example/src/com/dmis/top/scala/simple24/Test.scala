package com.dmis.top.scala.simple24

import scala.beans.BeanProperty

/**
 * aiker
 * 2015/2/5
 */
class Test {

  @BeanProperty
  val vv = 1;

  def isEmail(s: String): Boolean = {
    true
  }

  def domain(s: String): Boolean = {
    true
  }

  def user(s: String): Boolean = {
    true
  }
}
