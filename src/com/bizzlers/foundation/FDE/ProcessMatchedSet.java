package com.bizzlers.foundation.FDE;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;


public class ProcessMatchedSet {

	
	Vector<ClassResultSet> oneMatched = new Vector<ClassResultSet>();
	Vector<ClassResultSet> twoMatched = new Vector<ClassResultSet>();
	//vector containing results to display
	Vector<ClassResultSet> moreMatched = new Vector<ClassResultSet>();
	
	
	// returns oneMatched vector
	public Vector<ClassResultSet> getOneMatched() {
		return oneMatched;
	}

	// returns moreMatched vector
	public Vector<ClassResultSet> getMoreMatched() {
		return moreMatched;
	}
	
	public void clearMoreMatched(){
		moreMatched.removeAllElements();
	}
	// returns twoMatched vector
	public Vector<ClassResultSet> getTwoMatched() {
		return twoMatched;
	}

	
	
	/** Add resultSet to one and two matched and process more matched set */
	
	public synchronized void addToMatched(ClassResultSet resultSet , Vector<String> keywords ) {
		
		 resultSet = getAllRelatedInformation(resultSet);
		 
		String allInformation = resultSet.getAllTogether() ;
		//DisplySearchResult displySearchResult = new DisplySearchResult();
		if(keywords.size() >= 3 ){
		if (allInformation.contains(keywords.elementAt(1)) && allInformation.contains(keywords.elementAt(2))){
			ClassResultSet.moreMatchedCount ++ ;
			moreMatched.add(resultSet);
			//displySearchResult.display(allInformation);
		}
		else if (allInformation.contains(keywords.elementAt(1)))
			twoMatched.add(resultSet);
		else if (allInformation.contains(keywords.elementAt(2)))
			twoMatched.add(resultSet);
		else
			oneMatched.add(resultSet);
		}
		
		else if(keywords.size() == 2){
			if (allInformation.contains(keywords.elementAt(1))){
				ClassResultSet.moreMatchedCount ++ ;
				moreMatched.add(resultSet);
				//displySearchResult.display(allInformation);
			}
			else
				oneMatched.add(resultSet);
			
		}
		else if(keywords.size() == 1){

			ClassResultSet.moreMatchedCount ++ ;
			moreMatched.add(resultSet);
			
			//displySearchResult.display(allInformation);
		}
		else
			return ;
			
			
	}
	
	

	/** Takes input as service/product/tag resultset and return all information 
	 * from referenced records 
	 */
	
	public synchronized  ClassResultSet getAllRelatedInformation(ClassResultSet resultSet ){
		
		int id =0 , categoryId = 0 ,dataType = 0 , bid = 0;
		String categotyName = null ;
		String categoryDescription = null ;
		
		dataType = resultSet.getDataType();
		
		try {
			
			id = resultSet.getFieldOne();
			categoryId = Integer.parseInt(resultSet.getFieldThree());
		
			java.sql.ResultSet  rsCategory, rsCategoryData, rsBusiness;
			java.sql.Connection connection = DataManager.getInstance().getConnection();
	
			Statement smt = connection.createStatement();
		
			rsCategory = smt .executeQuery("select * from bizzlers.category where flag=0&&category_id =" + categoryId );
			while(rsCategory.next()){
				categotyName = rsCategory.getString("name");
				categoryDescription = rsCategory.getString("description");
			}
		
		
			if(!categotyName.equals(null)) {
				
			
				rsCategoryData = smt.executeQuery("select * from bizzlers.tbl_"+ categotyName 
								+"_data tbl " + "where tbl.reference='" + id +"' && tbl.datatype='"+ dataType +"' ");
				
				while(rsCategoryData.next()){
					
					//TODO add code for more than one businesses 
					
					
					bid = rsCategoryData.getInt("b_id");
			
			
			if (bid != 0 ){
				Statement smt2 = connection.createStatement();
				rsBusiness= smt2.executeQuery("select * from bizzlers.business where b_id = "+ bid);
				while(rsBusiness.next()){
				
				
				resultSet.setFieldFive(rsBusiness.getString("b_id"));
				resultSet.setFieldSix(rsBusiness.getString("b_name"));
				resultSet.setFieldSeven(rsBusiness.getString("tagline"));
				resultSet.setFieldEight(rsBusiness.getString("founded_place"));
				resultSet.setFieldNine(rsBusiness.getString("founded_date"));
				resultSet.setFieldTen(rsBusiness.getString("website"));
				resultSet.setFieldEleven(categotyName);
				resultSet.setFieldTwelve(categoryDescription);
				
				resultSet.setAllTogether( resultSet.getFieldTwo() + " "  + " provided by " + " " + resultSet.getFieldSix()
						 				+ "| Description : "+resultSet.getFieldFour() 
						 				+ "| Source : "+ resultSet.getFieldSix()  + " from " + resultSet.getFieldEleven() + " category ");
				}
				
			} // cat data if
			
		}
	
		}//category if
		
		//	smt.close();
			
		}catch(SQLException sqlException){
			sqlException.printStackTrace();
		}
		
		return resultSet;
	}
	
	/**
	 * This method process items thats are not much relevant to search result
	 * but they are matched with some keywords from input keyword set
	 */
	public synchronized  void processRemainingSet(){
	
	
		//DisplySearchResult displySearchResult = new DisplySearchResult();
		
		/** ::::::::::::::::::: Process Two matched  :::::::::::::::::: */
		
		while( getTwoMatched().size() > 0 ) {
			ClassResultSet resultSet = getTwoMatched().elementAt(0);
			 moreMatched.add(resultSet);
			 ClassResultSet.moreMatchedCount ++ ;
			//displySearchResult.display(allInfo);
			getTwoMatched().remove(0);
			
		}
		
		/**  :::::::::::  Process One matched  ::::::::::  */
		
		while( getOneMatched().size() > 0 ) {
			
			ClassResultSet resultSet = getOneMatched().elementAt(0);
			moreMatched.add(resultSet);
			ClassResultSet.moreMatchedCount ++ ;
			//displySearchResult.display(allInfo);
			getOneMatched().remove(0);
		}
		
	}
}
