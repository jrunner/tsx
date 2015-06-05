package com.t2t.tsx.sql

import org.apache.spark.sql.hive.HiveContext
import org.apache.spark.{SparkConf, SparkContext}

/**
 * ypf
 * 2015/06/05
 * 测试通过，此前未通过的原因是，引用了apache-hive的jar，去掉问题则顺利解决
 */
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
    sql("show tables").foreach(println)

    println("查询有多少行数据")
    hql("Select count(*) from invites").collect().foreach(println)
    println("显示前10行数据")
    hql("select * from invites limit 10").collect().foreach(println)
    //session查询次数排行榜
    //hiveContext.hql("select WEBSESSION,count(WEBSESSION) as cw from SOGOUQ group by WEBSESSION order by cw desc limit 10").collect().foreach
    // (println)

    //hiveContext.hql("select c.theyear,count(distinct a.ordernumber),sum(b.amount) from tblStock a join tblStockDetail b on a.ordernumber=b.ordernumber join tbldate c on a.dateid=c.dateid group by c.theyear order by c.theyear").collect().foreach(println)

    sc.stop()
    println("ok!")
  }

}
