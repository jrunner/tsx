package com.dmis.top.scala.simple23

/**
 * aiker
 * 2015/2/3
 */
case class Book(title: String, authors: String*)


object Book {
  def main(args: Array[String]) {
    val books = List(
      Book("scala Action", "jam", "ak", "jcc"),
      Book("scala编程", "张三", "李四", "王五"),
      Book("钢铁是怎么样炼成的", "保尔", "李四", "张三丰")
    )

    //查询姓为张的作者的书
    val vv = for (
      b <- books;
      a <- b.authors if (a.startsWith("张"))
    ) yield b.title
    println(vv)

    //查询所有包含scala的书
    val v1 = for (
      b <- books if (b.title indexOf ("scala")) >= 0
    ) yield b.title
    println(v1)

    //查询至少写过两边书的作者
    val v2 = for (b1 <- books; b2 <- books if b1 != b2;
                  a1 <- b1.authors; a2 <- b2.authors if (a1 == a2)) yield a1
    println(v2)

    //高阶函数
    val v22 = for (b1 <- books; b2 <- books.filter(x => b1 != x);
                   a1 <- b1.authors; a2 <- b2.authors.filter(x => a1 == x)) yield a1
    println("v22：" + v22)

    val v3 = for (b <- books.tail if b != books.head) yield b
    println(v3)
    println(books.tail)

    println(books.map(x => x))
  }

  def removeDuplicates[T](xs: List[T]): List[T] = {
    if (xs.isEmpty) xs
    else xs.head :: removeDuplicates(xs.tail.filter(x => x != xs.head))
  }
}