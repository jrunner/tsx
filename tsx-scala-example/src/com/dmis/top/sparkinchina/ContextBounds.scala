package com.dmis.top.sparkinchina

/**
 * Created by ypf on 2015/4/22.
 */

class Pair[T: Ordering](val a: T, val b: T) {
  def smaller(implicit ordered: Ordering[T]) = if (ordered.compare(a, b) < 0) a else b
}

//Word:Ordering->Ordering[Word]
class Word(val length: Int) {

}

trait WordOrdering extends Ordering[Word] {
  override def compare(x: Word, y: Word): Int = if (x.length > y.length) 0 else 1
}

object ContextBounds {
  def main(args: Array[String]) {
    val p = new Pair[Int](3, 1)
    println(p.smaller)

    implicit object WordX extends WordOrdering
    val w1 = new Word(111)
    val w2 = new Word(112)
    val pp = new Pair[Word](w1, w2)
    println(pp.smaller.length)
  }
}

class ContextBounds {

}
