package org.vincibean.binary.search.square.root

import org.specs2.Specification
import org.specs2.specification.core.SpecStructure
import org.vincibean.binary.search.square.root.Main._

class MainSpec extends Specification {
  override def is: SpecStructure =
    s2"""
        Finding out the square root with the binary search algorithm must
          return NaN for invalid numbers ${ Main.sqrt(-1D).isNaN must beTrue }
          return ~2 when 4.0 is given ${ (Main.sqrt(4.0) ~= 2.0) must beTrue }
          return ~4 when 16.0 is given ${ (Main.sqrt(16.0) ~= 4.0) must beTrue }
          return ~31.622776 when 1000 is given ${ (Main.sqrt(1000.0) ~= Math.sqrt(1000.0)) must beTrue }
          return ~1000 when 1000000 is given ${ (Main.sqrt(1000000.0) ~= Math.sqrt(1000000.0)) must beTrue }
          work with a big number ${ (Main.sqrt(Math.sqrt(Double.MaxValue / 2)) ~= Math.sqrt(Math.sqrt(Double.MaxValue / 2))) must beTrue }
      """

}
