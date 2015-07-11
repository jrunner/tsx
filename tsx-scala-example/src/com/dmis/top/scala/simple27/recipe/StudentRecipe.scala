package com.dmis.top.scala.simple27.recipe

import com.dmis.top.scala.simple27.food._

/**
 * aiker
 * 2015/2/8
 *
 * 带有自身类型的SimpleReipes
 */
trait StudentRecipe {
  this: StudentFoods =>

  object FruitSalad extends Recipe(
    "fruit salad", List(Apple, Pear), "Mix it all together"
  )

  def allRecipes = List(FruitSalad)

}
