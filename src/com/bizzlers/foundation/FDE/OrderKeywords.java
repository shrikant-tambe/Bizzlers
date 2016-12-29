
package com.bizzlers.foundation.FDE;


import java.util.Iterator;
import java.util.Vector;

public class OrderKeywords {


	//TODO make order according to meaningful stopwords
	

	
	// returns index of next stopword if exist otherwise index of last element+1
	
	public int getNextStopwordIndex(int curretPosition , Vector<String> input){
		
		String s ;
		for(int i=curretPosition+1 ; i < input.size() ; i ++)
		{
			s =input.elementAt(i);
		if(s.equals("for")||s.equals("to")||s.equals("with") || s.equals("has") || s.equals("had") 
				|| s.equals("having") || s.equals("have") || s.equals("contain") || s.equals("contains") 
				|| s.equals("containing") || s.equals("by") || s.equals("of") || s.equals("at") || s.equals("from") 
				|| s.equals("within") || s.equals("in") || s.equals("into") || s.equals("on")|| s.equals("onto"))
			
				return i;
		}
		
		return input.size();
	}
	
	
	// returns index of previous stopword if exist otherwise -1
	
	public int getPrevStopwordIndex(int curretPosition , Vector<String> input){
		
		String s ;
		for(int i= curretPosition-1 ; i  >= 0 ; i --)
		{
			s =input.elementAt(i);
		if(s.equals("for")||s.equals("to")||s.equals("with") || s.equals("has") || s.equals("had") 
				|| s.equals("having") || s.equals("have") || s.equals("contain") || s.equals("contains") 
				|| s.equals("containing") || s.equals("by") || s.equals("of") || s.equals("at") || s.equals("from") 
				|| s.equals("within") || s.equals("in") || s.equals("into") || s.equals("on")|| s.equals("onto"))
			
				return i;
		}
		
		return -1 ;
	}
	
	/**
	 * 
	 * @param Vector containing keywords
	 * @return vector after shuffling
	 * 
	 */
	
	public Vector<String> orderKeywords(Vector<String> key)
	{
	
		Vector<String> orderedKeywords = new Vector<String>();
		Vector<String> orderedKeywordsProprty = new Vector<String>();
		Vector<String> orderedKeywordsMinor = new Vector<String>();
		 boolean isDefault = true ;
		
		for(int i = 0 ; i < key.size() ; i ++ ){
				
				String keyw = null ;
			  
				keyw =key.elementAt(i);
			
				
				   int mainCounter = 0 ;
				   int propertyCounter = 0 ;
				   int minorCounter = 0 ;
			  
			
			  if ("for".equals(keyw) || "to".equals(keyw))  { 
				  
				  isDefault = false ;
				  
				  //before stopword to main
				  
				  for(int c = getPrevStopwordIndex(i, key)+1 ; c < i ; c++){
					   
					  orderedKeywords.add(mainCounter, key.elementAt(c));
					  mainCounter ++ ;
					  
				  }
		    	
				  
				  // after stopword to property
		    	  
		    	  int lim = getNextStopwordIndex(i, key);
		    	  
		    	  for(int c = i+1 ; c < lim ; c ++)
		    	  {
		    		   orderedKeywordsProprty.add(propertyCounter , key.elementAt(c));
		    		   propertyCounter ++ ;
		    		  i++;
		    	  }
				  
			  }
			  
			  	// defines special properties of main keyword 
		      else if ("with".equals(keyw) || "has".equals(keyw) || "had".equals(keyw) || "having".equals(keyw) 
		    		  || "have".equals(keyw)|| "contain".equals(keyw) || "containing".equals(keyw) || "contains".equals(keyw)){
		    	  
		    	  
		    	  isDefault = false ;
		    	  
		    	  //words before stopwords to main
		    	  
		    	  for(int c = getPrevStopwordIndex(i, key)+1 ; c < i ; c++){
					   
					  orderedKeywords.add(mainCounter, key.elementAt(c));
					  mainCounter ++ ;
					  
				  }
		    	  
		    	  
		    	     
		    	  //words after stopword  to property
		    	  
		    	  int lim = getNextStopwordIndex(i, key);
		    	  
		    	  for(int c = i+1 ; c < lim ; c ++)
		    	  {
		    		   orderedKeywordsProprty.add(propertyCounter , key.elementAt(c));
		    		   propertyCounter ++ ;
		    		  i++;
		    	  }
		    	
		      }
			  
			    
			  //defines minor details about properties
		      else if ("by".equals(keyw) || "of".equals(keyw) || "at".equals(keyw) || "from".equals(keyw) || "within".equals(keyw)) {
		    	  
		    	  /*isDefault = false ;
		    	  
		    	  //words before stopwords to main
		    	  
		    	  for(int c = getPrevStopwordIndex(i, key)+1 ; c < i ; c++){
					   
					  orderedKeywords.add(mainCounter, key.elementAt(c));
					  mainCounter ++ ;
					  
				  }
		    	  
		    	  // after stopwords to minor
		    	  
		    	  int lim = getNextStopwordIndex(i, key);
		    	  
		    	  for(int c = i+1 ; c < lim ; c ++)
		    	  {
		    		  
		    		  orderedKeywordsMinor.add(minorCounter, key.elementAt(c));
		    		  minorCounter ++ ;
		    		  i++;
		    	  }*/
		    	  
 isDefault = false ;
		    	  
		    	  //words before stopwords to poperty
		    	  
		    	  for(int c = getPrevStopwordIndex(i, key)+1 ; c < i ; c++){
					   
		    		  
		    		  orderedKeywordsProprty.add(propertyCounter, key.elementAt(c));
					  propertyCounter ++ ;  
				  }
		    	  
		    	  
		    	  	// after stopwords to minor
		    	 
		    	  
		    	  int lim = getNextStopwordIndex(i, key);
		    	  
		    	  for(int c = i+1 ; c < lim ; c ++)
		    	  {
		    		  
		    		  orderedKeywordsMinor.add(minorCounter, key.elementAt(c));
		    		  minorCounter ++ ;
		    		  i++;
		    	  }
		    	  
		      }			  
		    	    
		      
			  
		      else if ( "in".equals(keyw) ||  "into".equals(keyw) || "on".equals(keyw) || "onto".equals(keyw))   {
		    	  
		    	  
		    	  isDefault = false ;
		    	  
		    	  //words before stopwords to poperty
		    	  
		    	  for(int c = getPrevStopwordIndex(i, key)+1 ; c < i ; c++){
					   
		    		  
		    		  orderedKeywordsProprty.add(propertyCounter, key.elementAt(c));
					  propertyCounter ++ ;  
				  }
		    	  
		    	  
		    	  	// after stopwords to minor
		    	 
		    	  
		    	  int lim = getNextStopwordIndex(i, key);
		    	  
		    	  for(int c = i+1 ; c < lim ; c ++)
		    	  {
		    		  
		    		  orderedKeywordsMinor.add(minorCounter, key.elementAt(c));
		    		  minorCounter ++ ;
		    		  i++;
		    	  }
		    	  
		      }			  
			  		  
		} 
	
		// if no meaningful stopwords exist then shuffle them as last , first , and remaining
		
		if(isDefault == true){
			
			if ( key.size() > 0 ){			
				orderedKeywords.add(key.firstElement());
					key.remove(0);
				}
			
			if ( key.size() > 0 ){
			orderedKeywords.add(key.lastElement());
			  key.remove(key.size()-1);
			}
			
			
			
		    Iterator<String> iter = key.iterator();
			while (iter.hasNext())
			      orderedKeywords.add(iter.next());
			
		}
		// append all keywords to ordered set
		else{
			
			orderedKeywords.addAll(orderedKeywordsProprty);
			orderedKeywords.addAll(orderedKeywordsMinor);
			
		}
				    
		return orderedKeywords;
	}
		
}
