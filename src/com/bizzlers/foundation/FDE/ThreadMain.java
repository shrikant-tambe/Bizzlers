package com.bizzlers.foundation.FDE;

import java.util.Vector;

/**
 * @author Shrikant
 * @version 1.0
 *
 * This thread responsible for searching all keywords containing in vertor input set
 * 
 */


public class ThreadMain extends Thread{

	Vector<String> keywords ;

	// for each main thread there would be separate processor 
	
	SearchKeywords searchKeywords = null ;
	
	public ThreadMain(Vector<String> keyw , SearchKeywords serKeywordsInstance) {
		this.keywords=keyw;
		this.searchKeywords = serKeywordsInstance ;
		
	try {
		
		
		ThreadPST threadProducts = new ThreadPST(keywords, serKeywordsInstance , "product");
		threadProducts.start();
		
	    ThreadPST threadServices = new ThreadPST(keywords, serKeywordsInstance , "service" );
	    threadServices.start();

	    ThreadPST threadTag = new ThreadPST(keywords, serKeywordsInstance ,"tag");
	    threadTag.start();
	  
	    ThreadB threadB =  new ThreadB(keywords , serKeywordsInstance );
	    threadB.start();
	    
	    
	    while(threadProducts.isAlive() && threadServices.isAlive() && threadTag.isAlive() && threadB.isAlive() ) ;
	    
	    
	}
	catch(IllegalThreadStateException illegalThreadStateException){
		illegalThreadStateException.printStackTrace();
	}
	
	} // constructor;
	

}
