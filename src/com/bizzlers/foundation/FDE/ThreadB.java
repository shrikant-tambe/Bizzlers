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
  class ThreadB extends Thread {
	  Connection connection = null;
	  Statement smt , statementCategory;
	  java.sql.ResultSet rsBusiness , rsCategory ;
	  DisplySearchResult displaySearchResult ;
	  String token,name,tagline ,  foundedPlace , website ,categoryName ;
	  int  id;
	  Vector<String> keywords;
	  ClassResultSet resultSet = null ;
	  SearchKeywords searchKeywords = null ;
	 public ThreadB(Vector<String> keys , SearchKeywords serKeywordsInstance ){
		 connection=DataManager.getInstance().getConnection();
		 this.keywords = keys;
		 this.searchKeywords = serKeywordsInstance ;
		 
		 if(keywords.size() < 1)
			 token=null;
		 else
			 token = (String)keywords.firstElement();
		 
	 }

	 public void run() {
        try {
        	
        	if(token.isEmpty() == false){
      
    	      smt = connection.createStatement();
    	      rsBusiness = smt.executeQuery("select * from bizzlers.business");
              
    	      while(rsBusiness.next())   {
    	    	 
    	    	  	name = rsBusiness.getString("b_name");
    	    	  	tagline = rsBusiness.getString("tagline");
    	    	  	foundedPlace = rsBusiness.getString("founded_place");
    	    	  	website = rsBusiness.getString("website");
    	    	  	
    	    	  	name = name + foundedPlace + tagline + website ;
    	    	  	
    	    	  	/* if we found exact match here  then process it...
    	    	  	 * we can go on comparing each letter if we have to deal with 
    	    	  	 * spelling mistake */ 
    	    	  	if(name.contains(token))	{
    	    	  		
    	    	  		resultSet = new ClassResultSet();
    	    	  		/*
    	    	  		 * 1:Id
    	    	  		 * 2:name
    	    	  		 * 3:tagline
    	    	  		 * 4:category
    	    	  		 * 5:form
    	    	  		 * 6:founded_place
    	    	  		 * 7:founded_date
    	    	  		 * 8:website
    	    	  		 */
    	    	  		resultSet.setDataType(0);
    	    	  		resultSet.setFieldOne(rsBusiness.getInt(1));
    	    	  		resultSet.setFieldTwo(rsBusiness.getString(2));
    	    	  		resultSet.setFieldThree(rsBusiness.getString(3));
    	    	  		resultSet.setFieldFour(rsBusiness.getString(4));
    	    	  		resultSet.setFieldFive(rsBusiness.getString(5));
    	    	  		resultSet.setFieldSix(rsBusiness.getString(6));
    	    	  		resultSet.setFieldSeven(rsBusiness.getString(7));
    	    	  		resultSet.setFieldEight(rsBusiness.getString(8));
    	    	  		
    	    	  		statementCategory = connection.createStatement();
    	    	  		rsCategory = statementCategory.executeQuery("select name from bizzlers.category where category_id ='"+resultSet.getFieldFour()+"'");
    	    	  		
    	    	  		while(rsCategory.next())
    	    	  			categoryName = rsCategory.getString("name");
    	    	  		
    	    	  		resultSet.setAllTogether( resultSet.getFieldTwo() 
    	    	  								  + "| from " +	categoryName + " category ");
    	    	  		
    	    	  		ClassResultSet.moreMatchedCount ++ ;
        	    	  		searchKeywords.processMatchedSetInstance.moreMatched.add(resultSet);
    	    	  		 
    	    	  	} // if 
    	    	  	
    	    	  	
    	         } // while
    	      
    	 
    	      smt.close();
        	}
         } //try
        
        catch(SQLException sqlException)	{
        	sqlException.printStackTrace();
 	    }  
        
      }//Method run finishes
    
  }// Class ThreadS ends

