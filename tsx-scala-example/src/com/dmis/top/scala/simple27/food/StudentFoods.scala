package com.dmis.top.scala.simple27.food

/**
 * aiker
 * 2015/2/8
 */
trait StudentFoods {

  object Pear extends Food("Pear")

  def adllFoods = List(Apple, Pear)

  def allCategory = Nil

}
