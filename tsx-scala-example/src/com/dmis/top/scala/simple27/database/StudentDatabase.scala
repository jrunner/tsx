package com.dmis.top.scala.simple27.database

import com.dmis.top.scala.simple27.food._
import com.dmis.top.scala.simple27.recipe._

/**
 * aiker
 * 2015/2/8
 */
object StudentDatabase extends Database with StudentFoods with StudentRecipe {

  object FrozenFood extends Food("FrozenFood")

  object HeatItUp extends Recipe(
    "heat it up", List(FrozenFood), "Microwave the 'food' for 10 minutes."
  )

  override def allFoods: List[Food] = List(FrozenFood)

  private val categories = List(
    FoodCategory("FrozenFood", List(FrozenFood))
  )

  override def allCategories = categories

}
