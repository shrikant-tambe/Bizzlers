package com.bizzlers.foundation.authentication;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.bizzlers.foundation.platform.DataManager;

public class Login {

	String username;
	String password;
	String un="";
	String pass="";
	String dt="";
	int n;
	int uid;

	
	Connection connection = null;
	Statement statement;
	ResultSet rsUser;
	
	
	public Login(String un,String pass){	
		username=un;
		password=pass;
		connection = DataManager.getInstance().getConnection();
		if(username==null) 
			username="";
		if(password==null)
			password="";
	}	
	
	public int authenticate(){
	try{
	
		
		statement = connection.createStatement();
		
			rsUser = statement.executeQuery
					("select * from bizzlers_authentication.user where login_id='"+username+"' AND login_password=AES_ENCRYPT('"+password+"','"+username+"')");

			
			while(rsUser.next()){
				un=rsUser.getString("login_id");
				pass=rsUser.getString("login_password");
				dt=rsUser.getString("last_login");//get the last logging date and time
				uid=rsUser.getInt("user_info");
			}
			
			
			if(un=="" || pass=="")
				uid=0;
			
			else{
				
			// update current system date to user account i.e., user logging date and time
				
				Date now =new Date();
				DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String dnow = format.format(now);
			
				n=statement.executeUpdate
						("UPDATE bizzlers_authentication.user SET last_login='"+dnow+"' WHERE login_id='"+un+"'");
			}
	      	}catch (Exception e){
	      		e.printStackTrace();
	      	}
	
		return uid;
	}
}
