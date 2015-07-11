package com.dmis.top.sparkinchina


/**
 * Created by ypf on 2015/4/19.
 */
package bobscrocks {
  package navigation {

    private[sparkinchina] class Navigator {
      protected def useChart(){}
      private[this] val speed = 100
      private val speed1 = 300

      class LegOfJourney{
        private val distance = 200
      }
    }

    package launch{
      object Vehicle{
        private val guide = new Navigator
      }
    }

  }

}


object PackageOperatition extends App {
  import bobscrocks.navigation._

  println("ok")

  private val guide = new Navigator

}
