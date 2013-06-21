package com.scalding.textprocessing.job

import com.twitter.scalding._
import com.scalding.textprocessing.counting._

class WordCountJob(args : Args) extends Job(args) {
  TextLine( args("input") )
    .flatMap('line -> 'word) { line : String => CountingTools.tokenize(line) }
    .groupBy('word) { _.size }
    .write( Tsv( args("output") ) )

}