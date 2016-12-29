package com.bizzlers.foundation.platform;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.bizzlers.foundation.FDE.ClassResultSet;

public class Category {

	java.sql.Connection connection = null;
	java.sql.ResultSet rsCategory = null ;
	java.sql.Statement categoryStatement = null ;
	  
	
	
	public Category() {	
	connection = DataManager.getInstance().getConnection();
	}
	
	
	
	public int insertCategory(String category , String description ){
		
		java.sql.ResultSet resultset ;
		java.sql.Statement statement  ;
		int id=0;
		
		try {
			
			
			statement = connection.createStatement() ;
			
			resultset = statement.executeQuery
					("select * from bizzlers.category where name='"+category+"'");
		
        
			while(resultset.next())
				id=resultset.getInt(1);
			 
			if(id==0){
							
			    statement.executeUpdate
			    	("insert into bizzlers.category(name,description,flag) values('"+category+"','"+description+"','1')");
		
			    resultset = statement.executeQuery
						("select category_id from bizzlers.category where name='"+category+"'");
			    
			
			    while(resultset.next())
			    	id=resultset.getInt(1);
			    	
			 }
						
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return id;
		 
	}
	
	
	
	
	public int deleteCategoryById(int category_id ){
		int status = 0 ;
		java.sql.Statement categoryStatement ;
		try{
		connection = DataManager.getInstance().getConnection();
		categoryStatement = connection.createStatement();
		
		status = categoryStatement.executeUpdate("delete from bizzlers.category where category_id="+ category_id);
	
		
		}catch(SQLException exception ){
			exception.printStackTrace();
		}
		
		return status;
	}
	
	
	
	
	
	
	public int allowCategoryById(int category_id , String categoryName ){
		int status = 0 ;
		java.sql.Statement categoryStatement , unCatStatement , catData;
		java.sql.ResultSet rsUnCatData ;
		CategoryData categoryData = new CategoryData();
		
		try{
		connection = DataManager.getInstance().getConnection();
		categoryStatement = connection.createStatement();
		unCatStatement = connection.createStatement();
		catData = connection.createStatement();
		
		categoryData.createTable(categoryName.toLowerCase());
		
		
		rsUnCatData = unCatStatement.executeQuery("select * from bizzlers.uncontrolled_category_data where category_id="+ category_id);
		
		while(rsUnCatData.next()){
			
			catData.executeUpdate(
					"insert into bizzlers.tbl_"+categoryName.toLowerCase()+"_data(b_id,datatype,reference) values("+rsUnCatData.getInt(2)+","+rsUnCatData.getInt(3)+","+rsUnCatData.getInt(4)+")"
					);
		}
		
		unCatStatement.executeUpdate("delete from  bizzlers.uncontrolled_category_data where category_id="+ category_id);
		
		status = categoryStatement.executeUpdate("update bizzlers.category set flag=0 where category_id="+ category_id);
	
		
		return status ;
		
		}catch(SQLException exception ){
			exception.printStackTrace();
		}
		return 0;
	}

	
	
	
	public int mapToAnotherCategory(int category_id  , String categoryName ){
		int status = 0 ;
		int newId = 0 ;
		java.sql.Statement categoryStatement , unCatStatement , catData , stBusiness , stCatnew  ;
		java.sql.ResultSet rsUnCatData , rsCat ;
		
		try{
			
		connection = DataManager.getInstance().getConnection();
		categoryStatement = connection.createStatement();
		unCatStatement = connection.createStatement();
		catData = connection.createStatement();
		stBusiness = connection.createStatement();
		stCatnew = connection.createStatement();
		
		rsCat = stCatnew.executeQuery("select category_id from bizzlers.category where name='"+categoryName+"'");
		
		while(rsCat.next()){
			newId = rsCat.getInt(1);
		}
		
		rsUnCatData = unCatStatement.executeQuery("select * from bizzlers.uncontrolled_category_data where category_id="+ category_id);
		
		while(rsUnCatData.next()){
			
			catData.executeUpdate(
					"insert into bizzlers.tbl_"+categoryName.toLowerCase()+"_data(b_id,datatype,reference) values("+rsUnCatData.getInt(2)+","+rsUnCatData.getInt(3)+","+rsUnCatData.getInt(4)+")"
					);
		}
		
		unCatStatement.executeUpdate("delete from  bizzlers.uncontrolled_category_data where category_id="+ category_id);
		
		stBusiness.executeUpdate("update bizzlers.business set category="+newId+" where category="+category_id);
		
		status = categoryStatement.executeUpdate("delete from bizzlers.category where category_id="+ category_id);
	
		
		return status ;
		
		}catch(SQLException exception ){
			exception.printStackTrace();
		}
		return 0;
	}
	
	
	
	
	
	public List<String> getAllCategoryList(){
		
		List<String> categoryNames = new ArrayList<String>();
		ResultSet categoryResultSet ;
		
		try{
			
			Statement statement = connection.createStatement();
			
			categoryResultSet = statement.executeQuery("select name from bizzlers.category");
			
			while(categoryResultSet.next())
				categoryNames.add(categoryResultSet.getString(1));
				
		}catch(SQLException exception){
			exception.printStackTrace();
		}
		
		
		return categoryNames ;
				
	}
	
	

public List<String> getAllValidCategoryList(){
		
		List<String> categoryNames = new ArrayList<String>();
		ResultSet categoryResultSet ;
		
		try{
			
			Statement statement = connection.createStatement();
			
			categoryResultSet = statement.executeQuery("select name from bizzlers.category where flag=0");
			
			while(categoryResultSet.next())
				categoryNames.add(categoryResultSet.getString(1));
				
		}catch(SQLException exception){
			exception.printStackTrace();
		}
		
		
		return categoryNames ;
				
	}
	
	
	
	
	public Vector<ClassResultSet> getUncontolledCategory(){

		Vector<ClassResultSet> result = new Vector<ClassResultSet>() ;
		
			
		try {
			
			categoryStatement = connection.createStatement();		
			rsCategory = categoryStatement.executeQuery("select * from bizzlers.category where flag=1");
			
		   while(rsCategory.next()){
			   ClassResultSet classResultSet = new ClassResultSet();	   
			   classResultSet.setFieldOne(rsCategory.getInt("category_id"));
			   classResultSet.setFieldTwo(rsCategory.getString("name"));
			   classResultSet.setFieldThree(rsCategory.getString("description"));
			   result.add(classResultSet)	;
		   }
			
			
		}catch(SQLException exception){
			exception.printStackTrace();
		}
		
		return result;
	}
}
