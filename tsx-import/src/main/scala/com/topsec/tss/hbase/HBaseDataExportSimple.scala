package com.topsec.tss.hbase

import org.apache.hadoop.hbase.mapreduce.TableInputFormat;
import org.apache.hadoop.hbase.HBaseConfiguration
import org.apache.hadoop.hbase.util.Bytes
import org.apache.spark.rdd.MappedRDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * aiker
 * 2015/1/28
 *
 * 2015.03.12(周四) 示例，将Hbase上的数据通过Spark导出.
 */
object HBaseDataExportSimple {

  def main(args: Array[String]) {
    val sc = new SparkConf().setAppName("HBaseDataExportSimple").setMaster("local")
    val ssc = new SparkContext(sc)

    val conf = HBaseConfiguration.create()
    conf.addResource("hbase-site.xml")
    conf.set(TableInputFormat.INPUT_TABLE, "TSS.JOB_MONITOR")

    val hBaseRDD = ssc.newAPIHadoopRDD(conf, classOf[TableInputFormat],
      classOf[org.apache.hadoop.hbase.io.ImmutableBytesWritable],
      classOf[org.apache.hadoop.hbase.client.Result])
    println("===============");
    println("总数：" + hBaseRDD.count())
    //    hBaseRDD.foreach(op => println("value:" + op))
    hBaseRDD.foreach(v => println("value:" + Bytes.toString(v._1.get()) + "," + Bytes.toString(v._2.getValue("0".getBytes(), "SOURCE_FILE".getBytes))))
    val mappedRDD = hBaseRDD.map(v => Bytes.toString(v._1.get()) + "," + Bytes.toString(v._2.getValue("0".getBytes(), "SOURCE_FILE".getBytes)))
    mappedRDD.saveAsTextFile("hdfs://bdm.node:8020/tmp/monitor3")
    println("===============ok!");
    System.exit(0)
  }
}
