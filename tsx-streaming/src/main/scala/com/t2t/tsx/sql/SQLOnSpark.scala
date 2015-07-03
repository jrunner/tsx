package com.t2t.tsx.sql

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}

case class Person(name: String, age: Int)

object SQLOnSpark {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("SQLOnSpark").setMaster("local")
    val sc = new SparkContext(conf)

    val sqlContext = new SQLContext(sc)
    import sqlContext._

    val people: RDD[Person] = sc.textFile("hdfs://w22.node:9000/user/root/examples/src/main/resources/people.txt").map(_.split(",")).map(p => Person(p(0), p(1).trim.toInt))
    people.registerAsTable("people")

    val teenagers = sqlContext.sql("SELECT name,age FROM people WHERE age >= 10 and age <= 19")
    teenagers.map(t => "Name: " + t(0) + "," + t(1)).collect().foreach(println)

    sc.stop()
  }

}