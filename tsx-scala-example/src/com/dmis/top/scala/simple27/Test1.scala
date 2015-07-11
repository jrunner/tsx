package com.dmis.top.scala.simple27

import com.dmis.top.scala.simple27.browser.{StudentBrower, SimpleBrower}
import com.dmis.top.scala.simple27.database.{SimpleDatabase, StudentDatabase}

/**
 * aiker
 * 2015/2/8
 */
object Test1 {
  def main(args: Array[String]) {
    val category = SimpleDatabase.allCategories.head
    category.foods.foreach(println)
    SimpleBrower.displayCategory(category)
    println("------------------------")
    val category1 = StudentDatabase.allCategories.head
    category1.foods.foreach(println)
    StudentBrower.displayCategory(category1)
  }
}
