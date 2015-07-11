package com.dmis.top.scala.simple27.food

/**
 * aiker
 * 2015/2/8
 *
 * 食品分类的特质
 */
trait FoodCategories {

  case class FoodCategory(name: String, foods: List[Food])

  def allCategories: List[FoodCategory]
}
