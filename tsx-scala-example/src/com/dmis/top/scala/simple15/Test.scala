package com.dmis.top.scala.simple15

/**
 * aiker
 * 2015/1/31
 */
object Test {
  def main(args: Array[String]) {
    val p = simplifyTop(UpOp("-", UpOp("-", Var("-10"))))
    println(p)
    val pp = simplifyTop(BinOp("+", Var("x"), Number(0)))
    println(pp)
    val pp2 = simplifyTop(BinOp("+", Var("x"), Number(1)))
    println(pp2)

    println("----")

    run1(0)
    run1(List(1, 2, 2))
    run1(List(0, 2, 3))

    println("----")
    run2((1, 2, 3))

    println("----")
    run3("yangpengfei")
    run3(2)
    run3(2.0)

    println("----")
    println("a".isInstanceOf[String])

  }

  //元组匹配模式
  def run2(expr: Any) = expr match {
    case (a, b, c) => println("1")
    case _ => println("end")
  }

  //类型模式
  def run3(any: Any) = any match {
    case s: String => println("string:" + s.length)
    case s: Int => println("int:" + s)
    case _ => println("ok")
  }

  def run1(expr: Any) = expr match {
    case 0 => println("zero")
    //case op => println("something:" + op)
    case List(1, _, _) => println("list:" + expr)
    case _ => println("ok")
  }

  def simplifyTop(expr: Expr) = expr match {
    case UpOp("-", UpOp("-", e)) => "1" //双重负号
    case BinOp("+", e, Number(0)) => "2" //加0
    case BinOp("*", e, Number(1)) => "3" //乘1
    case BinOp(_, _, _) => "4"
    case _ => expr
  }

}
