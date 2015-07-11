package com.dmis.top.scala.simple13 {

package navigation {

private[simple13] class Navigation {
  protected[navigation] def useStartChart() {}

  class LegOfJourney {
    private[Navigation] val distance = 100
  }

  private[this] var speed = 200
}

}

package launch {

import com.dmis.top.scala.simple13.navigation.Navigation

class Vehicle {
  private[launch] val guide = new Navigation

}

}

}

