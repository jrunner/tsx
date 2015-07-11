package com.dmis.top.scala.simple27.database

import com.dmis.top.scala.simple27.food.{Food, FoodCategories}
import com.dmis.top.scala.simple27.recipe.Recipe

/**
 * aiker
 * 2015/2/7
 * 带抽象方法的Database类
 * 模拟数据库
 *
 * 混入了FoodCategories特质的Database
 */
abstract class Database extends FoodCategories {
  def allFoods: List[Food]

  def allRecipes: List[Recipe]

  def foodNamed(name: String) = allFoods.find(p => p.name == name)
}
