package com.dmis.top.scala.simple27.recipe

import com.dmis.top.scala.simple27.food.Food

/**
 * aiker
 * 2015/2/7
 */
class Recipe(
              val name: String,
              val ingredients: List[Food],
              val instrucions: String) {
  override def toString: String = name.toString
}
