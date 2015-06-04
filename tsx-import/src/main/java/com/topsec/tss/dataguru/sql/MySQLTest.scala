package com.topsec.tss.dataguru.sql

/**
 * aiker
 * 2015/1/19
 */

import java.sql.{DriverManager, ResultSet}

object MySQLTest {

  def main(args: Array[String]) {

    Class.forName("com.mysql.jdbc.Driver")
    val conn = DriverManager.getConnection("jdbc:mysql://192.168.72.192.168.72.21:3306/hive", "hive", "hive")
    try {

      val statement = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE)
      val prep = conn.prepareStatement("insert into saledata (theyear,qty,amount) values (\"2003\",2,30.25)")
      prep.executeUpdate()
      val rs = statement.executeQuery("select theyear,qty,amount from saledata")
      while (rs.next) {
        val theyear = rs.getString("theyear")
        val qty = rs.getString("qty")
        val amount = rs.getString("amount")
        println("theyear: %s, qtyname: %s, amount: %s".format(theyear, qty, amount))
      }
    } catch {
      case e: Exception => e.printStackTrace
    }
    conn.close
  }
}








