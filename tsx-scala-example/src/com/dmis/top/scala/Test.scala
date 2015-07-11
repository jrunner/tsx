package com.dmis.top.scala

/**
 * aiker
 * 2015/2/2
 */
class Test {

}

case class Person(name: String, isMale: Boolean, childrens: Person*)

object Test {
  def main(args: Array[String]) {
    val lara = new Person("Lara", false)

    val bob = new Person("Bob", true)

    val julie = new Person("Julie", false, lara, bob)

    val persons = List(lara, bob, julie)

    println(julie.childrens(1).name)
    println(persons(2).name)

    println(persons.filter(op => true).length)
    persons.filter(op => !op.isMale).flatMap(
      op => (op.childrens.map(c => (op.name + "," + c.name)))
    ).foreach(println)


    val vv = for (p <- persons;
                  if !p.isMale; c <- p.childrens
    ) yield p.name + "," + c.name

    vv.foreach(println(_))
  }
}
