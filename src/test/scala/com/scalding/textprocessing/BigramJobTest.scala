package com.scalding.textprocessing

import org.specs2.mutable.Specification
import com.twitter.scalding._

class BigramJobTest extends Specification with TupleConversions {
  "A Bigram job" should {
    JobTest("com.snowplowanalytics.hadoop.scalding.BigramJob").
      arg("input", "inputFile").
      arg("output", "outputFile").
      source(TextLine("inputFile"), List("0" -> "ab! bc, cd. ab",
    		  							 "1" -> "bc #cd ab de, ef",
    		  							 "2" -> "ef ab de ab bc cd",
    		  							 "3" -> "ab cd ef de")).
      sink[(String,Int)](Tsv("outputFile")){ outputBuffer =>
        val outMap = outputBuffer.toMap
        "identificar los bigramas y contarlos" in {
        	println("valores:")
        	outMap.keys.foreach(x=>println(x+"->"+outMap(x)))
//          outMap("ab bc") must be_==(2)
//          outMap("bc cd") must be_==(3)
//          outMap("cd ab") must be_==(1)
//          outMap("ab de") must be_==(1)
//          outMap("de ef") must be_==(1)
//          outMap("ef ef") must be_==(1)
//          outMap("ef ab") must be_==(1)
//          outMap("ef de") must be_==(1)
//          outMap("de ab") must be_==(1)
//          outMap("ab cd") must be_==(1)
        }
      }.
      run.
      finish
  }
}