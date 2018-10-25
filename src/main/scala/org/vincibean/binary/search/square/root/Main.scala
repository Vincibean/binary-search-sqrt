package org.vincibean.binary.search.square.root

import scala.annotation.tailrec

object Main {

  implicit class DoubleOps(d1: Double) {
    def ~=(d2: Double): Boolean = (d2 - epsilon) <== d1 <== (d2 + epsilon)
    def <==(d2: Double) = new {
      def <==(d3: Double): Boolean = d1 <= d2 && d2 <= d3
    }
  }

  val epsilon: Double = 0.000000001

  def sqrt(d: Double): Double = {

    @tailrec
    def loop(min: Double, max: Double): Double = {
      val mean = (min + max) / 2
      val res = mean * mean
      if (res ~= d) {
        mean
      } else if (res > d + epsilon) {
        loop(min, mean)
      } else {
        loop(mean, max)
      }
    }

    def inverse(d: Double): Double = 1 / d

    if (d < 0) {
      Double.NaN
    } else if (d < 1) {
      inverse(sqrt(inverse(d)))
    } else {
      loop(0, d)
    }
  }

}
