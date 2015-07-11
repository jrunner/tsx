package com.dmis.top.gson

import com.google.gson.Gson

import scala.collection.mutable.{Map => MMap}

/**
 * Created by ypf on 2015/5/17.
 */
object GsonTest {
  def main(args: Array[String]) {
    var param: Map[String, String] = Map.empty
    val m = MMap[String, String]()
    m += ("孟娜" -> "00")
    m += ("鲍悦" -> "02")
    m += ("常浩" -> "03")
    m += ("杨鹏飞" -> "04")
    param = Map.empty ++ m

    println(new Gson().toJson(Map("a" -> 1, "b" -> 2)))

    val l = Array(
      Map("id" -> 1, "name" -> "John"),
      Map("id" -> 2, "name" -> "Dani")
    )

    println(new Gson().toJson(l))

    val v = Array(new Student("ypf",10,"男"),new Student("jln",18,"女"))
    println(new Gson().toJson(v))

  }

  case class Student(name: String, age: Int, sex: String)

}
