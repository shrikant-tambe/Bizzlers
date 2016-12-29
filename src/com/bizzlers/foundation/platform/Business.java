package com.bizzlers.foundation.platform;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.Vector;

import com.bizzlers.foundation.FDE.ClassResultSet;

public class Business {
	
	private int id;
	private long categoryId;
	private String category;
	private String formation;
	private String foundedDate;
	private String foundedPlace;
	private String name;
	private String tagLine;
	private String website;
	
	private ClassResultSet resultSet = null ;
	private java.sql.Connection connection = null ;
	private java.sql.Statement statement = null ;
	private ResultSet rsBusiness = null , resultset ;
	private String categoryName , categoryDescription ;
	private Statement statementCategory;
	private ResultSet rsCategory;
	
	
	public Business(){
		connection = DataManager.getInstance().getConnection();
		statement=(Statement) DataManager.getInstance().executeRequest();
	}

	
	public Business(String businessName,String tagLine,String category,String formation,String fplace,String fdate,String website){
		this.name=businessName;
		this.tagLine=tagLine;
		this.category=category;
		if (formation.equals("on"))
			this.formation="Private";
		else
			this.formation="Public";
		this.foundedPlace=fplace;
		this.foundedDate=fdate;
		this.website=website;
		connection = DataManager.getInstance().getConnection();
		statement=(Statement) DataManager.getInstance().executeRequest();
	}
	
	
	public int insertRequest(String catDescription){
		categoryId=new Category().insertCategory(category,catDescription);
		
		try {
			statement.executeUpdate
			("insert into bizzlers.business(b_name,tagline,category,form,founded_date,founded_place,website) values ('"+name+"','"+tagLine+"','"+categoryId+"','"+formation+"','"+foundedDate+"','"+foundedPlace+"','"+website+"')");
		
			resultset = statement.executeQuery("select * from bizzlers.business where b_name='"+name+"'");
		
        while(resultset.next())
			 id=resultset.getInt(1);
		 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
        return id;
		
	}
	
	
	
	public void updateRequest(int bid){
		try {
			statement.executeUpdate
			("UPDATE bizzlers.business SET b_name='"+name+"', tagline='"+tagLine+"', form='"+formation+"', founded_date='"+foundedDate+"', founded_place='"+foundedPlace+"', website='"+website+"' where b_id='"+bid+"'");
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
	}
	
	
	public void deleteRequest(int bid){
		
		try {
			statement.executeUpdate
			("UPDATE bizzlers.business SET flag=1 where b_id='"+bid+"'");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
	
	
	public void deleteRequest(){
		try {
			
			statement.executeUpdate("DELETE from bizzlers.tbl_'"+Global.categoryName+"'_data where business='"+id+"'");
			statement.executeUpdate
			("UPDATE bizzlers.business SET flag='1' where b_id='"+id+"'");
			statement.executeUpdate
			("UPDATE bizzlers.contact_card SET flag='1' where business_id='"+id+"'");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	
	
	public Vector<String> getBusinessInfo(int bid){
		

		 Vector<String> result = new Vector<String>() ;
		 
		try {
			
			resultset = statement.executeQuery("select * from bizzlers.business where b_id='"+bid+"'");
		
			while(resultset.next())
				{
        	result.add(resultset.getString("b_id")); //0
        	result.add(resultset.getString("b_name")); //1
        	result.add(resultset.getString("tagline")); //2
    		result.add(resultset.getString("form")); //3
    		result.add(resultset.getString("founded_place")); //4
    		result.add(resultset.getString("founded_date")); //5
    		result.add(resultset.getString("website")); //6
    		result.add(resultset.getString("category")); //7
    		
    		statementCategory = connection.createStatement();
	  		rsCategory = statementCategory.executeQuery("select * from bizzlers.category where category_id='"+ resultset.getString("category")+"'");
	  		while(rsCategory.next()){
	  			categoryName= rsCategory.getString("name");
	  			categoryDescription = rsCategory.getString("description");
	  		}
	  		
	  		result.add(categoryName); //8
	  		result.add(categoryDescription); //9
	  		
	  		
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return result;
		
	}
	
	public String getCategoryName(int catId){
		
		String name=null;
		try {
			resultset = statement.executeQuery("select * from bizzlers.category where category_id='"+catId+"'");
		
        while(resultset.next())
			 name=resultset.getString("name");
		 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return name;
	}
	
	
	public String intArrayToString(int id[]){
		
		String returntring = Arrays.toString(id).replace(", ", " ");
		
		returntring = returntring.replace("]", "") ;
		returntring = returntring.replace("[", "") ;
		
		
		return returntring;
	}
	/**
	 * @param uid
	 * @return
	 */
	
	public int[] getBusinessIds(int uid){
		
		int bid[] = new int[50] ;
		
		int cnt =0 ;
		try {
			resultset = statement.executeQuery("select * from bizzlers.user_relation where user_id='"+uid+"'");
		
        while(resultset.next())
			 bid[cnt++]=resultset.getInt("business_id");
		 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return bid;
	}
	
	
	/**
	 * 
	 * @param bId
	 * @return
	 * call getBusinessIds and pass that array to getBusinessNames
	 */
	
	public Vector<String> getBusinessNames(int bId[]){
		
		Vector<String> record= new  Vector<String>();
		
		for(int i=0; i < bId.length  ;i++){
			id=bId[i];
		try {
			resultset = statement.executeQuery("select * from bizzlers.business where b_id='"+id+"'");
		
        while(resultset.next())
			 record.add(resultset.getString("b_name"));
		 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		}
		
		return record;
	}
	


		
	
	public void changeCategory(){
		
	}
	
	
	
	public ClassResultSet getBusinessbyId(int id){
		resultSet = new ClassResultSet();
		try{
		statement = connection.createStatement();
		rsBusiness= statement.executeQuery("select * from bizzlers.business where b_id = "+ id);
		while(rsBusiness.next()){

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
	  		rsCategory = statementCategory.executeQuery("select * from bizzlers.category where category_id='"+ resultSet.getFieldFour()+"'");
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

}
	