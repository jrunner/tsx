package com.dmis.top.spark.simple

class Simple3 {
  private var sum = 0;

  def add(b: Byte) = sum += b;

  def checksum() = ~(sum & 0xFF) + 1

}

object Simple3 {
  def main(args: Array[String]) {

    println(1 + 2);

    val a = new Simple3();
    a.sum = 3;

    println(a.sum);

    val b = new Simple3();
    b.add(2);
    println(b.checksum)
    println(b.sum);
  }
}