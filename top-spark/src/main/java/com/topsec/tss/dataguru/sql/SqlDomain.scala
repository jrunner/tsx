package com.topsec.tss.dataguru.sql

import java.sql.{DriverManager, ResultSet}

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}

import scala.collection.mutable.HashMap

case class Domain(id: String, icp_code: String, company_name: String, contact: String,
                  domain_name: String, icp_date: String, contact_id_card: String, phone: String,
                  email: String, website_add: String, website_name: String
                   ) extends HashMap


object SqlDomain {
  def main(args: Array[String]) {

    val conf = new SparkConf().setAppName("SqlDomain").setMaster("local")
    val sc = new SparkContext(conf)

    val sqlContext = new SQLContext(sc)
    import sqlContext._

    val path = "hdfs://bdm.node:8020/tmp/domain/domain_icp_0";

    val tbl: RDD[Domain] = sc.textFile(path)
      .map(_.split("\t")).map(p => Domain(p(0), p(1), p(2), p(3), p(4), p(5), p(6), p(7), p(8), p(9), p(10)))
    tbl.registerAsTable("DOMAIN") //区分大小写

    val e = sqlContext.sql("SELECT * FROM DOMAIN")
    e.saveAsTextFile("hdfs://bdm.node:8020/tmp/domain-export")
    println("总数:" + e.count())
    sc.stop()
  }


}