package com.dmis.top.scala.simple32

/**
 * Created by ypf on 2015/3/23.
 */

import scala.swing._
import java.io.File
import scala.swing.event.ButtonClicked

object FirstSwingApp extends SimpleSwingApplication {

  override def top = new MainFrame {
    title = "First Swing App"
    contents = new Button {
      text = "Click me"
    }
  }

}