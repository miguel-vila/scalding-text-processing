package com.scalding.textprocessing.counting

object CountingTools {
  
  def tokenize(text : String) : List[String] = {
    text.toLowerCase.replaceAll("[^a-zA-Z0-9\\s]", "").split("\\s+").toList.filter(_.length>0)
  }
    
  def pairs(array: List[String]) : List[(String,String)] = 
    array match {
    	case Nil => Nil
    	case _::Nil => Nil
    	case x::(y::arrayp) => (x,y)::pairs(y::arrayp)
  	}
  
  type NgramList = List[List[String]]
    
  def ngrams(list: List[String])(implicit n: Int) : NgramList = {
	    def ngramsHelperFunction(list: List[String], acc: NgramList) : NgramList =
		    if(list.size<n) acc
		    else {
		      val (l,r) = list.splitAt(n)
		      ngramsHelperFunction(r, l :: acc)
		    }
	    ngramsHelperFunction(list, Nil)
    }
}