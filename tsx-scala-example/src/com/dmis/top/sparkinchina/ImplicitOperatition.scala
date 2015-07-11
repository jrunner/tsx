package com.dmis.top.sparkinchina

import java.io.File

import scala.io.Source

/**
 * Created by ypf on 2015/4/21.
 */
class RichFile(val file: File) {
  def readAll = Source.fromFile(file).getLines().mkString("\r\n")
}


object Conversion {
  implicit def fileToRichFile(file: File) = new RichFile(file)

  implicit class Calculator(op: Int) {
    def add(y: Int) = 1 + y
  }
}

object ImplicitOperatition extends App {

  import Conversion._

  val file = new File("D:\\zk.txt")
  println(file.readAll)
  println("ok")


  println(1.add(10))


}

//1. 新系统CRM，和传统的可能不一样（类似广东外网系统）
//2. 现场问题
//3. 高铁及地址, 2015-04-21 xia wu 2点
//4. 工信通，张乃强
//5. 有问题，提出来
//6. 全网流量传输协议，去掉了全部流量那一列。
//7. 找黄星解决hive
//   13466564295，南汇-上海电信园区-秀沿西路 [上海市浦东新区-中国电信公司上海信息园区中国电信学]
