package com.dmis.top.scala.simple30

import scala.actors.Actor

/**
 * aiker
 * 2015/2/8
 */
abstract class Clock extends Actor {
  private var running = false
  private var currentTime = 0
  private var agenda: List[WorkItem] = List()
  private var allSimulants: List[Actor] = List()
  private var busySimulants: Set[Actor] = Set.empty

}

case class WorkItem(time: Int, msg: Any, target: Actor)

case class AfterDelay(time: Int, msg: Any, target: Actor)

case object Start

case object Stop