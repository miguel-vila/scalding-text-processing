package com.scalding.textprocessing

import org.specs2.mutable.Specification
import com.scalding.textprocessing.counting._

class CountingToolsTest extends Specification{
  
  "CountingTools" should {
    val list = List("a","b","c","c","a","b")
    "Computar bigramas de una lista de Strings" in {
      CountingTools.pairs(list) must be_==(List(("a","b"),("b","c"),("c","c"),("c","a"),("a","b")))
    }
    "Tokenizar correctamente" in {
      CountingTools.tokenize("ab! bc, cd. ab") must be_==(List("ab","bc","cd","ab"))
    }
  }

}