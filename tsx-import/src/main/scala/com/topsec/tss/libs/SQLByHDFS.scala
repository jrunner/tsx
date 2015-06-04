package com.topsec.tss.libs

import org.apache.hadoop.hbase.HBaseConfiguration
import org.apache.hadoop.hbase.client.Result
import org.apache.hadoop.hbase.io.ImmutableBytesWritable
import org.apache.hadoop.hbase.mapreduce.TableInputFormat
import org.apache.hadoop.hbase.util.Bytes
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}

/**
 * ypf
 * 2015/3/12
 *
 * 2015.03.12(周四) 示例，HBase->HDFS->Spark RDD->HDFS
 */
object SQLByHDFS {

  val sc = new SparkConf().setAppName("HBaseSimple1").setMaster("local[2]").setExecutorEnv("executor-memory","1g")
  val ssc = new SparkContext(sc)
  val hdfsPathName = "hdfs://bdm.node:8020/tmp/search"
  val resultPathName = "hdfs://bdm.node:8020/tmp/search-result1"
  val SPLIT = ","

  def main(args: Array[String]) {
    val conf = HBaseConfiguration.create()
    conf.addResource("hbase-site.xml")
    conf.addResource("core-site.xml")

    //读取hdfs,注册表,保存结果
    println("task2()")
    task2()

    println("停止SparkContext.");
    ssc.stop();
    println("执行完成!");
  }

  def get(op: (ImmutableBytesWritable, Result))(name: String) = {
    Bytes.toString(op._2.getValue("0".getBytes(), name.getBytes)) + SPLIT
  }


  def task2() {
    val sqlContext = new SQLContext(ssc)
    import sqlContext._

    println("读取hdfs")
    val tbl: RDD[TblDomain] = ssc.textFile(hdfsPathName).map(_.split(SPLIT)).map(p => TblDomain(p(1), p(2), p(3)))
    tbl.registerTempTable("TblDomain") //区分大小写

    println("注册表")
    val e = sqlContext.sql("SELECT * FROM TblDomain where IP like '42.120%'")
    e.cache()
    val r = e.saveAsTextFile(resultPathName)
    //println("总数:" + e.count())

  }
}


