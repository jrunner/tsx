package com.dmis.top.scala.simple27

import com.dmis.top.scala.simple27.browser.Browser
import com.dmis.top.scala.simple27.database.{Database, StudentDatabase, SimpleDatabase}

/**
 * aiker
 * 2015/2/8
 */
object GotApples {
  def main(args: Array[String]) {
    val arg = "student"
    val db: Database = if (arg == "student") StudentDatabase else SimpleDatabase

    object browser extends Browser {
      val database = db;
    }

    val apple = db.foodNamed("Apple").get
    browser.recipesUsing(apple).foreach(println)

    val test = db.foodNamed("FrozenFood").get
    browser.recipesUsing(test).foreach(println)

  }
}
