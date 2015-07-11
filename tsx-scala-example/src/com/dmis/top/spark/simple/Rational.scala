package com.dmis.top.spark.simple

class Rational(n: Int, d: Int) {

  def this(n: Int) = this(n, 3)

  require(d != 0)
  println("created " + n + "/" + d)

  private val g = gcd(n.abs, d.abs)

  val number: Int = n / g;
  val demon: Int = d / g;

  // println(66 % 42) //42,24
  // println(42 % 24) //24,18
  // println(24 % 18) //18,6
  // 获取最大公约数
  private def gcd(a: Int, b: Int): Int = {
    if (b == 0)
      a
    else
      gcd(b, a % b)
  }

  override def toString = number + "/" + demon;

  //add该为+
  def +(that: Rational): Rational = new Rational(number * that.demon + demon * that.number, demon * that.demon);
  def +(i: Int): Rational = new Rational(number + i * demon, demon)

  //cheng改为*
  def *(that: Rational): Rational = new Rational(number * that.number, demon * that.number)
  def *(i: Int): Rational = new Rational(number * i, demon)

  def lessThan(that: Rational) = this.number * that.demon < this.demon * that.number;

  //求最大值
  def max(that: Rational) = if (this.lessThan(that)) that else this

}

object Rational {
  def main(args: Array[String]) {
    //隐式转换
    implicit def intToRational(x: Int) = new Rational(x)
    
    val x = new Rational(8, 10)
    var y = new Rational(2, 10);
    println(x + y)
    println(x * y)
    println(x + 1)
    println(x * 2)
    println(2 * x)

  }
}