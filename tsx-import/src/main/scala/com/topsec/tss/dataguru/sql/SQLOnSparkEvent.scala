package com.topsec.tss.dataguru.sql

import java.sql.{DriverManager, ResultSet}

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}

import scala.collection.mutable.HashMap

case class RawEvent(EVENT_TYPE: String, EVENT_TYPE_CODE: String, SOURCE_TYPE: String, SOURCE: String,
                    DETAIL_ID: String, BASE_TYPE: String, SUB_TYPE: String, DETAIL_TYPE: String,
                    EXT_TYPE: String, TIME: String, DD: String, HOUR: String,
                    S_IP_T: String, S_IP_N: String
                     ) extends HashMap

/**
  <entry name="SOURCE_TYPE" value="$_fields.get(0)" alias="来源类别" type="string"/>
	<entry name="SOURCE" value="$_fields.get(1)" alias="来源" type="string"/>
	<entry name="DETAIL_ID" value="$_fields.get(2)" alias="事件详细类型编码" type="long"/>
	<entry name="BASE_TYPE" value="$_fields.get(3)" alias="事件基本类型" type="string"/>
	<entry name="SUB_TYPE" value="$_fields.get(4)" alias="事件子类型" type="string"/>
	<entry name="DETAIL_TYPE" value="$_fields.get(5)" alias="事件详细类型" type="string"/>
	<entry name="EXT_TYPE" value="$_fields.get(6)" alias="事件扩展类型" type="string"/>
	<entry name="TIME" value="$_date.dateStr2long($_fields.get(7),'yyyy-MM-dd HH:mm:ss')" alias="完整时间" type="date" merge="false"/>
	<entry name="DD" value="$_fields.get(8)" alias="日期" type="long"/>
	<entry name="HOUR" value="$_fields.get(9)" alias="小时" type="int" merge="false"/>
	<entry name="S_IP_T" value="$_fields.get(10)" alias="源IP地址" type="string"/>
	<entry name="S_IP_N" value="$_fields.get(11)" alias="源IP数值" type="long"/>
  */
object SQLOnSparkEvent {
  def main(args: Array[String]) {

    val conf = new SparkConf().setAppName("SQLOnSparkEvent").setMaster("local")
    val sc = new SparkContext(conf)

    val sqlContext = new SQLContext(sc)
    import sqlContext._

    var path = "hdfs://n21.com:9000/jstg/@JS@ClassByEventType@Bot_or_Trojan@#917MT_B_IP_201301090000.txt";
    path =  "hdfs://tss.node:9000/jstg/@JS@ClassByEventType@Bot_or_Trojan@#917MT_B_IP_201301090000.txt";

    val event: RDD[RawEvent] = sc.textFile(path)
      .map(_.split("<--->")).map(p => RawEvent("木马僵尸受控", "ac", p(0), p(1), p(2), p(3), p(4), p(5), p(6), p(7), p(8), p(9), p(10), p(11)))
    event.registerAsTable("EVENT") //区分大小写

    val e = sqlContext.sql("SELECT * FROM EVENT")
    println("事件总数:" + e.count())
    sc.stop()
  }


}