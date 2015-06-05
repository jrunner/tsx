package com.topsec.tss.dataguru.sql

/**
 * aiker
 * 2015/1/19
 */

import org.apache.hadoop.hbase.HBaseConfiguration
import org.apache.spark.sql.hive.LocalHiveContext
import org.apache.spark.{SparkConf, SparkContext}

object HiveOnSpark {

  case class Record(key: Int, value: String)

  def main(args: Array[String]) {
    val sparkConf = new SparkConf().setAppName("HiveFromSpark").setMaster("local")
    val sc = new SparkContext(sparkConf)

    val hiveContext = new LocalHiveContext(sc)
    //hiveContext.hql("CREATE DATABASE default")
    //hiveContext.hql("use default")
    //查看表
    hiveContext.hql("show tables").collect().foreach(println)
    //查询有多少行数据
    hiveContext.hql("Select count(*) from SOGOUQ").collect().foreach(println)
    //显示前10行数据
    hiveContext.hql("select * from SOGOUQ limit 10").collect().foreach(println)
    //session查询次数排行榜
    hiveContext.hql("select WEBSESSION,count(WEBSESSION) as cw from SOGOUQ group by WEBSESSION order by cw desc limit 10").collect().foreach(println)

    //hiveContext.hql("select c.theyear,count(distinct a.ordernumber),sum(b.amount) from tblStock a join tblStockDetail b on a.ordernumber=b.ordernumber join tbldate c on a.dateid=c.dateid group by c.theyear order by c.theyear").collect().foreach(println)

    sc.stop()
    println("ok!")
  }

}
