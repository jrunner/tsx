package com.dmis.top.scala.simple27.database

import com.dmis.top.scala.simple27._
import com.dmis.top.scala.simple27.food._
import com.dmis.top.scala.simple27.recipe._

/**
 *
 * Database的子对象SimpleDatabase
 * aiker
 * 2015/2/7
 * 模拟数据库
 */
object SimpleDatabase extends Database with StudentFoods with StudentRecipe{
  def allFoods = List(Apple, Orange, Cream, Sugar)

  private val categories = List(
    FoodCategory("Fruits", List(Apple, Orange)),
    FoodCategory("misc", List(Cream, Sugar))
  )
  def allCategories = categories
}
