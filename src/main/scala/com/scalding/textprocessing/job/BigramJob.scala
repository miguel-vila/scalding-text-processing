package com.scalding.textprocessing.job

import com.twitter.scalding._
import com.scalding.textprocessing.counting._

class BigramJob(args : Args) extends Job(args) {
  TextLine( args("input") )
  	.flatMap('line -> 'bigram) { line : String => CountingTools.pairs(CountingTools.tokenize(line)).map(bigram => bigram._1+" "+bigram._2) }
  	.groupBy('bigram) { _.size }
    .write( Tsv( args("output") ) )

}