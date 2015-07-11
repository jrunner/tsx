package com.dmis.top.scala.simple27.browser

import com.dmis.top.scala.simple27.database.{Database, SimpleDatabase}
import com.dmis.top.scala.simple27.food.Food

/**
 *
 * 带val字段的Browser类(抽象数据库)
 * aiker
 * 2015/2/7
 *
 * 模拟浏览器
 */
abstract class Browser {
  val database: Database;

  def recipesUsing(food: Food) = database.allRecipes.filter(r => r.ingredients.contains(food))

  def displayCategory(category: database.FoodCategory) {
    println(category)
  }
}
