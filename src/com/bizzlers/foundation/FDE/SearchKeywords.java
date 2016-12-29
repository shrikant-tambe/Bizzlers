package com.bizzlers.foundation.FDE;

import java.util.Vector;


/**
 * @author Shrikant
 * @version 1.0
 *
 * This class invokes main threads
 * 
 */

public class SearchKeywords {
	
	/**
	 * Processed keyword vector
	 * @param keyword
	 */
	
	 ProcessMatchedSet processMatchedSetInstance = new ProcessMatchedSet();
	 ThreadMain ts , tf ;
	 boolean isSecond = false;
  public void getSearchResults(Vector<String> keyword){
		 try {
		 
			// System.out.println("\n ::::::::::  Following is List of Items found :::::::::::::: \n");
			 
			 /* Search starting with first keyword */
			 
			 
			 
			  ts = new ThreadMain( keyword , this );
			 
			 tf = new ThreadMain( keyword , this );
			 tf.start();
			 
			 
			 
			 /* replace first keyword with second keyword */
			 if(keyword.size() >= 2) {
			 keyword.add(0,keyword.elementAt(1));
			 keyword.remove(2);

			 /* Search starting with second keyword */
			 isSecond = true ;
			 ts.start();
			 
			 }
			 
			
			 
			 if(isSecond == false ){
				 while(tf.isAlive() == true )
					 ;
			 }
			 else{
				 while(tf.isAlive() == true && ts.isAlive()== true  )
					 ;
			 }
			 
			 //processMatchedSetInstance.getMoreMatched().size() < 1
			 
			
		 }	 
		 catch(Exception e){
		 		e.printStackTrace();		
	 	}  
  }//method
  
  public ProcessMatchedSet getProcessMatchedSet(){
	
		return processMatchedSetInstance ;
	}
	
  
  
}// class