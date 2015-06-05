package com.t2t.tsx

/**
 * ypf
 * 2015/1/19
 */

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql._
import org.apache.spark.sql.hive.HiveContext
import scala.io.Source._

object HiveOnSpark {

  case class Record(key: Int, value: String)

  def main(args: Array[String]) {
    val sparkConf = new SparkConf().setAppName("HiveFromSpark").setMaster("local")
    val sc = new SparkContext(sparkConf)

    val hiveContext = new HiveContext(sc)

    import hiveContext._
    sql("set hive.security.authorization.enabled=false")
    // setup enough cached rows
    sql("set spark.sql.inMemoryColumnarStorage.batchSize=1000000000")
    // must have the following line to fix the parquet serde issue
    sql("set spark.sql.hive.convertMetastoreParquet=true")
    // sql("set spark.sql.codegen=true") this made performance worse
    sql("show tables")

    //查询有多少行数据
    //hiveContext.hql("Select count(*) from SOGOUQ").collect().foreach(println)
    //显示前10行数据
    //hiveContext.hql("select * from SOGOUQ limit 10").collect().foreach(println)
    //session查询次数排行榜
    //hiveContext.hql("select WEBSESSION,count(WEBSESSION) as cw from SOGOUQ group by WEBSESSION order by cw desc limit 10").collect().foreach
    // (println)

    //hiveContext.hql("select c.theyear,count(distinct a.ordernumber),sum(b.amount) from tblStock a join tblStockDetail b on a.ordernumber=b.ordernumber join tbldate c on a.dateid=c.dateid group by c.theyear order by c.theyear").collect().foreach(println)

    sc.stop()
    println("ok!")
  }

}
