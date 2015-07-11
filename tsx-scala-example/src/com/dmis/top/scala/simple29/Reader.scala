package com.dmis.top.scala.simple29

import java.io.{IOException, BufferedReader, FileReader}

/**
 * aiker
 * 2015/2/8
 */
class Reader(fname:String) {

  private val in = new BufferedReader(new FileReader(fname))

  @throws(classOf[IOException])
  def read() = in.read
}
