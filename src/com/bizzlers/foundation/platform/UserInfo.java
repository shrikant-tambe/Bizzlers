package com.bizzlers.foundation.platform;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class UserInfo {
	
	private int id;
	private String firstName;
	private String middleName;
	private String lastName;
	private String dob;
	private String gender;

	
	Statement statement;
	ResultSet resultset;
	Connection connection ;
	public UserInfo(){
		connection = DataManager.getInstance().getConnection() ;
		statement=(Statement) DataManager.getInstance().executeRequest();
	}
	public UserInfo(int uid){
		this.id=uid;
		connection = DataManager.getInstance().getConnection() ;
		statement=(Statement) DataManager.getInstance().executeRequest();
	}
	public UserInfo(String firstName,String middleName,String lastName,String dob,String gender){
		connection = DataManager.getInstance().getConnection() ;
		this.firstName=firstName;
		this.lastName=lastName;
		this.dob=dob;
		this.middleName=middleName;
		this.gender=gender;
		
		statement=(Statement) DataManager.getInstance().executeRequest();
	}
	
	public int insertRequest()
	{
		try {
			
			id = 0 ;
			Statement stSelect = connection.createStatement() ;
			ResultSet resultSet ;
			
			resultSet = stSelect.executeQuery("select * from bizzlers.user_info order by user_info_id ASC");
			
			while(resultSet.next())
				 id=resultSet.getInt(1);
			
					
			id= id + 1 ;
			
			statement.executeUpdate
			("insert into bizzlers.user_info(user_info_id,first_name,middle_name,last_name,gender,dob) values ("+id+",'"+firstName+"','"+middleName+"','"+lastName+"','"+gender+"','"+dob+"')");
        
        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        return id;
	}
	
	
	public void updateRequest(int uInfoId){
		try {
			statement.executeUpdate
			("UPDATE bizzlers.user_info SET first_name='"+firstName+"' , middle_name='"+middleName+"' , last_name='"+lastName+"' , gender='"+gender+"' , dob='"+dob+"'  where user_info_id='"+uInfoId+"'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void rollbackRequest(int id ){
		try {
			statement.executeUpdate
			("delete from bizzlers.user_info where user_info_id='"+id+"'");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	

public void deleteRequest(){
		Business bObj=new Business();
		bObj.deleteRequest();
		try {
		statement.executeUpdate
		("UPDATE bizzlers.user_relation SET flag='1' where user_id='"+1+"'");
		statement.executeUpdate
		("UPDATE bizzlers.user_info SET flag='1' where user_info_id='"+1+"'");
		statement.executeUpdate
		("UPDATE bizzlers_authentication.user SET flag='1' where login_id='"+1+"'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}



	public String getName(){
		
		try {
			resultset = statement.executeQuery("select * from bizzlers.user_info where user_info_id='"+id+"'");
		
        while(resultset.next())
		 {
			 firstName=resultset.getString("first_name");
		 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Global.userInfoId=id;
		
	return firstName;
	}
	
	public Vector<String> getInfo(int id){

		Vector<String> res = new Vector<String>() ;
		try {
			resultset = statement.executeQuery("select * from bizzlers.user_info where user_info_id='"+id+"'");
		
        while(resultset.next())
        	{
			 res.add(resultset.getString("first_name"));
			 res.add(resultset.getString("middle_name"));
			 res.add(resultset.getString("last_name"));
			 res.add(resultset.getString("dob"));
			 res.add(resultset.getString("gender"));
			 
        	}
        
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return res;
		
	}
}
