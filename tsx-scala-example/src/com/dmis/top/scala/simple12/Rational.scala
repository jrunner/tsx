package com.dmis.top.scala.simple12

/**
 * aiker
 * 2015/1/31
 */
class Rational(n: Int, d: Int) extends Ordered[Rational] {
  private val g = gcd(n.abs, d.abs)
  val number: Int = n / g;
  val demon: Int = d / g;

  override def toString = number + "/" + demon;

  // 获取最大公约数
  private def gcd(a: Int, b: Int): Int = {
    if (b == 0)
      a
    else
      gcd(b, a % b)
  }

  override def compare(that: Rational): Int = this.n * that.demon - that.number * this.d
}
