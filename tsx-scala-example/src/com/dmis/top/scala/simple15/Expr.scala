package com.dmis.top.scala.simple15

/**
 * aiker
 * 2015/1/31
 */
abstract class Expr

case class Var(name: String) extends Expr

case class Number(num: Double) extends Expr

case class UpOp(operator: String, arg: Expr) extends Expr

case class BinOp(operator: String, left: Expr, rigth: Expr) extends Expr

