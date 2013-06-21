package com.scalding.textprocessing.job

import com.twitter.scalding.Job
import com.twitter.scalding.Args
import com.twitter.scalding.TextLine
import com.twitter.scalding.Tsv
import com.scalding.textprocessing.counting._

class NgramJob(args : Args) extends Job(args) {
  
  implicit val n = args("n").toInt
  
  TextLine( args("input") )
  	.flatMap('line -> 'ngram) { line : String => CountingTools.ngrams(CountingTools.tokenize(line)).map{ _.fold("")(_+" "+_) } }
  	.groupBy('ngram) { _.size }
    .write( Tsv( args("output") ) )
    
}