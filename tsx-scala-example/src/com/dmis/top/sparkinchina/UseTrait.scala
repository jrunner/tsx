package com.dmis.top.sparkinchina

/**
 * Created by ypf on 2015/4/16.
 */
class UseTrait {

}


object UseTrait extends App {

  System.setProperty("scala.time", "true-y") //这里非空就会打印total

  for (arg <- this.args) println(arg)

}
