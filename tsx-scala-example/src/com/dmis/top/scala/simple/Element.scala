package com.dmis.top.scala.simple

/**
 * aiker
 * 2015/1/25
 */
abstract class Element {
  def contents: Array[String];

  def width = if (height == 0) 0 else contents(0).length;

  def height = contents.length;

  def above(that: Element): Element = new ArrayElement(this.contents ++ that.contents)

  def beside(that: Element): Element = {
    new ArrayElement(
      for ((line, line2) <- this.contents zip that.contents) yield line + line2
    )
  }

  override def toString = contents mkString "\n"

  def demo() {
    println("Element's implementation invoked")
  }
}

object Element {


  def elem(line: String): Element = new LineElement(line)

  def elem(chr: Char, width: Int, height: Int): Element = new UniformElement(chr, width, height)

  private class LineElement(s: String) extends Element {
    val contents = Array(s);
    override val width = s.length;
    override val height = 1;
  }

  private class UniformElement(ch: Char, override val width: Int, override val height: Int) extends Element {
    private val line = ch.toString * width

    override def contents: Array[String] = Array()
  }

}
