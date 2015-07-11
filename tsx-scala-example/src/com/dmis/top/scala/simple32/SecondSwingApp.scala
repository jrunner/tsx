package com.dmis.top.scala.simple32

import scala.swing._

/**
 * Created by ypf on 2015/3/23.
 */
object SecondSwingApp extends SimpleSwingApplication {
  def top = new MainFrame {
    title = "Second Swing App"
    val button = new Button {
      text = "点击我！"
    }
    val label = new Label {
      text = "没有按钮注册！"
    }

    contents = new BoxPanel(Orientation.Vertical) {
      contents += button
      contents += label
      border = Swing.EmptyBorder(30, 30, 10, 30)
    }
  }
}
