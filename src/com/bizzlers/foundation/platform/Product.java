package com.bizzlers.foundation.platform;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import com.bizzlers.foundation.FDE.ClassResultSet;

public class Product {
	private long id= 0 ;
	private long categoryId;
	private long businessId;
	private String name;
	private String description;
	private String category; 
	private int flag;
		
	
	ClassResultSet resultSet = null ;
	java.sql.Connection connection = null ;
	java.sql.Statement statement = null, statementCategory = null  ;
	java.sql.ResultSet rsProduct = null , rsCategory = null ;
	String categoryName ,  categoryDescription ;
	
	ResultSet resultset;
	private ResultSet rsBusiness;
	private ResultSet rsCategoryData;
	
	public Product(){
		connection = DataManager.getInstance().getConnection();
		statement=(Statement) DataManager.getInstance().executeRequest();
	}
	public Product(String name, String desc,int businessId){
		connection = DataManager.getInstance().getConnection();
		statement=(Statement) DataManager.getInstance().executeRequest();
		this.businessId=businessId;
		this.name=name;
		this.description=desc;
	}
	
	public void insertRequest(){
		
		
		try {
			resultset = statement.executeQuery
					("select * from bizzlers.products where product_name='"+name+"'");
		
         while(resultset.next())
			 id=resultset.getInt(1);
		 
         
         if(id== 0){
		 
		 
		 resultset = statement.executeQuery("select category from bizzlers.business where b_id="+businessId );
         while(resultset.next())
 			 categoryId=resultset.getInt("category");
 		 
         		 
         statement.executeUpdate
         ("insert into bizzlers.products(product_name,description,product_cat) values ('"+name+"','"+description+"',"+categoryId+")");
         
         resultset = statement.executeQuery("select * from bizzlers.products where product_name='"+name+"'");
         while(resultset.next())
 			 id=resultset.getInt(1);
 		 
         resultset = statement.executeQuery("select * from bizzlers.category where category_id="+categoryId+" ");
         while(resultset.next()){
 			flag=resultset.getInt(4);
 			category = resultset.getString("name");
         }
         if(flag!=1){
        	 statement.executeUpdate
		 ("insert into bizzlers.tbl_"+category+"_data(b_id,datatype,reference) values("+businessId+",1,"+id+")");
         }
         else
        	 statement.executeUpdate
    		 ("insert into bizzlers.uncontrolled_category_data(business,datatype,reference,category_id) values("+businessId+",1,"+id+",'"+categoryId+"')");
		 }
         else{
        	 
        	 resultset = statement.executeQuery("select category from bizzlers.business where b_id="+businessId );
             while(resultset.next())
     			 categoryId=resultset.getInt("category");
     		
             resultset = statement.executeQuery("select * from bizzlers.products where product_name='"+name+"'");
             while(resultset.next())
     			 id=resultset.getInt(1);
     		 
             resultset = statement.executeQuery("select * from bizzlers.category where category_id="+categoryId+" ");
             while(resultset.next()){
     			flag=resultset.getInt(4);
     			category = resultset.getString("name");
             }
             if(flag!=1){
            	 statement.executeUpdate
    		 ("insert into bizzlers.tbl_"+category+"_data(b_id,datatype,reference) values("+businessId+",1,"+id+")");
             }
             else
            	 statement.executeUpdate
        		 ("insert into bizzlers.uncontrolled_category_data(business,datatype,reference,category_id) values("+businessId+",1,"+id+",'"+categoryId+"')");
             
         }
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public void updateRequeset(){
			
	}
	
	
	
	public int deleteRequest(int id){
		
		java.sql.Statement statement ;
		int status = 0;
		
		try{
			
		statement = connection.createStatement();
		
		 status = statement.executeUpdate("delete from bizzlers.products where product_id="+id);
		
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return status;
		
	}
	
	public int[] getProdutIds(int bid , int catID , String catName ){
		
		java.sql.Statement statement;
		java.sql.ResultSet  rsCatData;
		int pid[] = new int[50] , cnt=0 ;
		
		try 
		{
			
		statement = connection.createStatement();
		rsCatData = statement.executeQuery("select reference from bizzlers.tbl_"+ catName + "_data where datatype=1 && bid="+bid ) ;
		
		while(rsCatData.next())
			pid[cnt++]= rsCatData.getInt(1);
			
		
		}catch(SQLException exception){
			exception.printStackTrace();
		}
		
		return pid ;
		
	}
	
	
	public Vector<String> getProductList(int pid[] ){
	
		java.sql.Statement statement ;
		java.sql.ResultSet resultset ;
		Vector<String> names = new Vector<String>() ;
		int cnt=0;
		
		try {
			
			  statement = connection.createStatement();
			  resultset = statement.executeQuery("select * from bizzlers.products where product_id="+ pid[cnt++]) ;
			
			while(resultset.next())
				names.add(resultset.getString("product_name"));
				
		}catch(SQLException exception){
			exception.printStackTrace();
		}
		
		return names ;
		
	}
	
	public Vector<String> getInfo()
	{
		
		//String productList[]={},
		String name= null ;
		Statement st;
		st=(Statement) DataManager.getInstance().executeRequest();
		Vector<String> productList = new Vector<String>();
		ResultSet rs; 
		int pid;
		try {
			resultset = statement.executeQuery
					("select * from bizzlers.tbl_"+Global.categoryName+"_data where b_id='"+Global.businessId+"'AND datatype=1");
		
        while(resultset.next())
		 {
			 pid=resultset.getInt("reference");
			 rs = st.executeQuery
						("select * from bizzlers.products where product_id='"+pid+"'");
			 while(rs.next()){
			 	 name=rs.getString("product_name");
			 }
			 productList.add(name);
			 
		 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return productList;
	}
	
	public ClassResultSet getProductbyId(int id){
		resultSet = new ClassResultSet();
		try{
		statement = connection.createStatement();
		rsProduct= statement.executeQuery("select * from bizzlers.products where product_id = "+ id);
		while(rsProduct.next()){

			/*
	  		 * 1:product_id
	  		 * 2:product_name
	  		 * 3:product_cat
	  		 * 4:description
	  	
	  		 */
	  		resultSet.setDataType(1);
	  		resultSet.setFieldOne(rsProduct.getInt(1));
	  		resultSet.setFieldTwo(rsProduct.getString(2));
	  		resultSet.setFieldThree(rsProduct.getString(3));
	  		resultSet.setFieldFour(rsProduct.getString(4));
	  		
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
	
	public  Vector<ClassResultSet>  getProductListbyBusinessId(int id){
		 
		 Vector<ClassResultSet> strings = new Vector<ClassResultSet>();
		 int categoryId=0;
		 String categoryName=null , productName=null ;
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
					("select reference from bizzlers.tbl_"+categoryName+ "_data where b_id="+ id +" && datatype=1");
			
			
			statementProduct = connection.createStatement();
			
			while(rsCategoryData.next()){
				
				int product_id = rsCategoryData.getInt(1);
				ClassResultSet resultSet = new ClassResultSet();
				resultSet.setFieldOne(product_id);
				
				rsProduct= statementProduct.executeQuery
						("select * from bizzlers.products where product_id = "+ product_id );
				
				while(rsProduct.next()){
					productName = rsProduct.getString(2);
					description = rsProduct.getString(4);
				}
				resultSet.setFieldTwo(productName);
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
