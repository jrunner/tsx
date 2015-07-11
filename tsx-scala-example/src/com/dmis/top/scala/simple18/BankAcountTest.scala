package com.dmis.top.scala.simple18

/**
 * aiker
 * 2015/2/1
 */
object BankAcountTest {
  def main(args: Array[String]) {
    val account = new BankAccount()
    account.deposit(100)
    account.withdraw(80)
    println(account.balance)
  }
}
