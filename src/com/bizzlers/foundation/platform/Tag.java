package com.bizzlers.foundation.platform;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import com.bizzlers.foundation.FDE.ClassResultSet;


public class Tag {
		private long id;
		private long categoryId;
		private long businessId;
		private String name;
		private String description;
		private String category; 
		private int flag;
			
		
		
		ClassResultSet resultSet = null ;
		java.sql.Connection connection = null ;
		java.sql.Statement statement = null, statementCategory = null  ;
		java.sql.ResultSet rsTag = null , rsCategory = null ,resultset=null;
		String categoryName ,  categoryDescription ;
		private ResultSet rsBusiness;
		private ResultSet rsCategoryData;
		

		public Tag(){
			connection = DataManager.getInstance().getConnection();
			statement=(Statement) DataManager.getInstance().executeRequest();
		}
		
		public Tag(String name, String desc,int businessId){
			connection = DataManager.getInstance().getConnection();
			statement=(Statement) DataManager.getInstance().executeRequest();
			this.businessId=businessId;
			this.name=name;
			this.description=desc;
		}
		
		public void insertRequest(){
		
			
			try {
				resultset = statement.executeQuery
						("select * from bizzlers.tags where tag_name='"+name+"'");
			
	         while(resultset.next())
				 id=resultset.getInt(1);
			 
	         
	         if(id== 0){
			 
			 
			 resultset = statement.executeQuery("select category from bizzlers.business where b_id="+businessId );
	         while(resultset.next())
	 			 categoryId=resultset.getInt("category");
	 		 
	         		 
	         statement.executeUpdate
	         ("insert into bizzlers.tags(tag_name,description,tag_cat) values ('"+name+"','"+description+"',"+categoryId+")");
	         
	         resultset = statement.executeQuery("select * from bizzlers.tags where tag_name='"+name+"'");
	         while(resultset.next())
	 			 id=resultset.getInt(1);
	 		 
	         resultset = statement.executeQuery("select * from bizzlers.category where category_id="+categoryId+" ");
	         while(resultset.next()){
	 			flag=resultset.getInt(4);
	 			category = resultset.getString("name");
	         }
	         if(flag!=1){
	        	 statement.executeUpdate
			 ("insert into bizzlers.tbl_"+category+"_data(b_id,datatype,reference) values("+businessId+",3,"+id+")");
	         }
	         else
	        	 statement.executeUpdate
	    		 ("insert into bizzlers.uncontrolled_category_data(business,datatype,reference,category_id) values("+businessId+",3,"+id+",'"+categoryId+"')");
			 }
	         else
	         {
	        	 
	        	 resultset = statement.executeQuery("select category from bizzlers.business where b_id="+businessId );
		         while(resultset.next())
		 			 categoryId=resultset.getInt("category");
		 		 
		         resultset = statement.executeQuery("select * from bizzlers.tags where tag_name='"+name+"'");
		         while(resultset.next())
		 			 id=resultset.getInt(1);
		 		 
		         resultset = statement.executeQuery("select * from bizzlers.category where category_id="+categoryId+" ");
		         while(resultset.next()){
		 			flag=resultset.getInt(4);
		 			category = resultset.getString("name");
		         }
		         if(flag!=1){
		        	 statement.executeUpdate
				 ("insert into bizzlers.tbl_"+category+"_data(b_id,datatype,reference) values("+businessId+",3,"+id+")");
		         }
		         else
		        	 statement.executeUpdate
		    		 ("insert into bizzlers.uncontrolled_category_data(business,datatype,reference,category_id) values("+businessId+",3,"+id+",'"+categoryId+"')");
				
		         
	         }
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
		
		
	public void updateRequeset(){
			
	}
	
	
	public int deleteRequest(int id ){
		
		java.sql.Statement statement ;
		int status = 0;
		
		try{
			
		statement = connection.createStatement();
		
		 status = statement.executeUpdate("delete from bizzlers.tags where tag_id="+id);
		
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return status;
		
	}
	
	public ClassResultSet getTagbyId(int id){
		resultSet = new ClassResultSet();
		try{
		statement = connection.createStatement();
		rsTag= statement.executeQuery("select * from bizzlers.tags where tag_id = "+ id);
		while(rsTag.next()){

			/*
	  		 * 1:service_id
	  		 * 2:service_name
	  		 * 3:service_cat
	  		 * 4:description
	  	
	  		 */
	  		resultSet.setDataType(1);
	  		resultSet.setFieldOne(rsTag.getInt(1));
	  		resultSet.setFieldTwo(rsTag.getString(2));
	  		resultSet.setFieldThree(rsTag.getString(3));
	  		resultSet.setFieldFour(rsTag.getString(4));
	  		
	  		statementCategory = connection.createStatement();
	  		rsCategory = statementCategory.executeQuery("select * from bizzlers.category where category_id='"+ resultSet.getFieldThree()+"'");
	  		while(rsCategory.next()){
	  			categoryName= rsCategory.getString("name");
	  			categoryDescription = rsCategory.getString("description");
	  		}
	  			
	  		resultSet.setFieldEleven(categoryName);
	  		resultSet.setFieldTwelve(categoryDescription);
	  		
		}
		
		}catch(SQLException exception){
			exception.printStackTrace();
		}
		
		return resultSet ; 
	} //method
	
	
	public  Vector<ClassResultSet>  getTagListbyBusinessId(int id){
		 
		 Vector<ClassResultSet> strings = new Vector<ClassResultSet>();
		 int categoryId=0;
		 String categoryName=null , tagName=null ;
		 Statement statementProduct=null;
		 
		 
		try{
			
		statement = connection.createStatement();
		rsBusiness = statement.executeQuery("select * from bizzlers.business where b_id="+id);
		while(rsBusiness.next())
			categoryId = rsBusiness.getInt("category");
		
		rsCategory = statement.executeQuery("select name from bizzlers.category where category_id="+categoryId);
		while(rsCategory.next())
			categoryName = rsCategory.getString("name");
		
		if (categoryName.equals(null)) // uncontrolled
			;
		else{
		 
			rsCategoryData = statement.executeQuery
					("select reference from bizzlers.tbl_"+categoryName+ "_data where b_id="+ id +" && datatype=3");
			
			
			statementProduct = connection.createStatement();
			
			while(rsCategoryData.next()){
				
				int tag_id = rsCategoryData.getInt(1);
				ClassResultSet resultSet = new ClassResultSet();
				resultSet.setFieldOne(tag_id);
				
				rsTag= statementProduct.executeQuery
						("select * from bizzlers.tags where tag_id = "+ tag_id );
				
				while(rsTag.next()){
					tagName = rsTag.getString(2);
					description = rsTag.getString(4);
				}
				
				resultSet.setFieldTwo(tagName);
				resultSet.setFieldThree(description);
				resultSet.setFieldFive(categoryName);
				
				strings.add(resultSet);

				
			}
				
	  		
		}
		
		}catch(SQLException exception){
			exception.printStackTrace();
		}
		
		return strings ; 
	} //method

	
}
