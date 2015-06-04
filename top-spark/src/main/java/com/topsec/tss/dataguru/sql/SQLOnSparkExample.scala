package com.topsec.tss.dataguru.sql

import java.sql.{DriverManager, ResultSet}

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}

import scala.collection.mutable.HashMap

case class MyHashMap(N0: String, N1: String, N2: String, N3: String, N4: String) extends HashMap

/**
CREATE TABLE `tbl_event` (
	`id`  int NOT NULL AUTO_INCREMENT ,
	`n0`  varchar(255) NULL ,
	`n1`  varchar(255) NULL ,
	`n2`  varchar(255) NULL ,
	`n3`  varchar(255) NULL ,
	`n4`  varchar(255) NULL ,
	PRIMARY KEY (`id`)
) DEFAULT CHARSET=utf8;

  入库出错，原因是数据库不能接收中文，修改下即可
  */
object SQLOnSparkExample {
  def main(args: Array[String]) {

    val conf = new SparkConf().setAppName("SQLOnSparkExample").setMaster("local")
    val sc = new SparkContext(conf)

    val sqlContext = new SQLContext(sc)
    import sqlContext._

    val people: RDD[MyHashMap] = sc.textFile("hdfs://n21.com:9000/jstg/@JS@ClassByEventType@Worm@#SINKHOLE_201301100000.txt")
      .map(_.split("<--->")).map(p => MyHashMap(p(0), p(1), p(2), p(3), p(4)))
    people.registerAsTable("Worm") //区分大小写

    val teenagers = sqlContext.sql("SELECT * FROM Worm")
    val list = teenagers.filter(t => !t.contains("来源类别"))
    list.map(t => t(0) + "," + t(1) + "," + t(2) + "," + t(3) + "," + t(4)).collect().foreach(println)
    list.foreach(println)
    list.foreach(t => save(t(0).toString, t(1).toString, t(1).toString, t(1).toString, t(4).toString))
    sc.stop()
  }

  def save(n0: String, n1: String, n2: String, n3: String, n4: String) {

    Class.forName("com.mysql.jdbc.Driver")
    val conn = DriverManager.getConnection("jdbc:mysql://192.168.72.99:3306/top?useUnicode=true&amp;characterEncoding=utf8", "top", "top")
    try {

      val statement = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE)
      val sql = "insert into tbl_event (n0,n1,n2,n3,n4) values ('" + n0 + "','" + n1 + "','" + n2 + "','" + n3 + "','" + n4 + "')";
      println(sql)
      val prep = conn.prepareStatement(sql)
      prep.executeUpdate()
      val rs = statement.executeQuery("select count(*) from tbl_event")
      while (rs.next) {
        println("总数：" + rs.getInt(1))
      }
    } catch {
      case e: Exception => e.printStackTrace
    }
    conn.close
  }

}