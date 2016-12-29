package com.bizzlers.foundation.FDE;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;


/** 
 * @author Shrikant
 * @version 1.0
 * 
 * This thread searches keyword in product/service/tag
 *
 */
  class ThreadPST extends Thread {
	  Connection connection = null;
	  Statement smt ;
	  java.sql.ResultSet rsProductServiceTag ;
	  DisplySearchResult displaySearchResult ;
	  String token,name,description , tableName;
	  int  service_category, id;
	  Vector<String> keywords;
	  ClassResultSet resultSet = null ;
	  SearchKeywords searchKeywords = null ;

	 public ThreadPST(Vector<String> keys ,SearchKeywords serKeywordInstance, String tName ){
		 connection=DataManager.getInstance().getConnection();
		 this.keywords = keys;
		 if(keywords.size() < 1)
			 token=null;
		 else
			 token = (String)keywords.firstElement();
		 tableName= tName;
		 this.searchKeywords = serKeywordInstance ;
	 }

	 public void run() {
        try {
      
        	if(token.isEmpty() == false){
    	      smt = connection.createStatement();
    	      rsProductServiceTag = smt.executeQuery("select * from bizzlers."+tableName+"s");
              
    	      while(rsProductServiceTag.next())   {
    	    	 
    	    	   name =rsProductServiceTag.getString(tableName+"_name").toLowerCase();
 
    	    	  	/* if we found exact match here  then process it...
    	    	  	 * we can go on comparing each letter if we have to deal with 
    	    	  	 * spelling mistake */ 
    	    	  	if(name.contains(token))	{
    	    	  		
    	    	  		resultSet = new ClassResultSet();
    	    	  		/*
    	    	  		 * 1:Id
    	    	  		 * 2:name
    	    	  		 * 3:caterory_id
    	    	  		 * 4:description
    	    	  		 */
    	    	  		resultSet.setFieldOne(rsProductServiceTag.getInt(1));
    	    	  		resultSet.setFieldTwo(rsProductServiceTag.getString(2));
    	    	  		resultSet.setFieldThree(rsProductServiceTag.getString(3));
    	    	  		resultSet.setFieldFour(rsProductServiceTag.getString(4));
    	    	  		
    	    	  		
    	    	  		if (tableName.equals("product"))
    	    	  			resultSet.setDataType(1);
    	    	  		else if (tableName.equals("service"))
    	    	  			resultSet.setDataType(2);
    	    	  		else if (tableName.equals("tag"))
    	    	  			resultSet.setDataType(3);
    	    	  		
        	    	  		searchKeywords.processMatchedSetInstance.addToMatched(resultSet ,keywords);
    	    	  		 
    	    	  	} // if 
    	    	  	
    	    	  	
    	         } // while
    	      
    	     // ThreadMain.getProcessMatchedSetInstance().processRemainingSet();
    	      
    	      //this.interrupt();
    	      
    	      smt.close();
        	}
         } //try
        
        catch(SQLException sqlException)	{
        	sqlException.printStackTrace();
 	    }  
        
      }//Method run finishes
    
  }// Class ThreadS ends

