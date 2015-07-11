package com.dmis.top.sparkinchina

/**
 * Created by ypf on 2015/4/19.
 */
class PrivateOperatition {

  private[this] val v = 1
  protected[this] val value = 2

  def add(op:PrivateOperatition): Unit ={

  }
}

class SubPrivateOperatition extends PrivateOperatition{

  override def add(op:PrivateOperatition): Unit ={
  }
}

object PrivateOperatition extends App {


}