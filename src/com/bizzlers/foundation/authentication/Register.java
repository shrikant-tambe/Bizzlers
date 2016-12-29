package com.bizzlers.foundation.authentication;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.bizzlers.foundation.platform.DataManager;

public class Register {

	private String username;
	private String password,npass;
	private int uid;
	
	Connection connection = null;
	Statement statement;
	ResultSet rsUser;
	
	
	public Register(String username,String opass,String npass){
		this.username=username;
		this.password=opass;
		this.npass=npass;
		connection = DataManager.getInstance().getConnection();
	}
	
	
	public Register(String un,String pass,int uid){	
		username=un;
		password=pass;
		this.uid=uid;
		connection = DataManager.getInstance().getConnection();
		}
	
	
	public int addUser(){
			
		int status = 0;
		
			try{
			
				statement = connection.createStatement();
				Statement st =connection.createStatement() ;
				ResultSet rsUser ;
				String existingUser = "";
				
				rsUser = st.executeQuery("select * from bizzlers_authentication.user where login_id='"+username+"'");
				
				while(rsUser.next())
					existingUser = rsUser.getString("login_id");
				
				if(existingUser.equals(""))
				{
				Date now =new Date();
				DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String dnow = format.format(now);
					
				statement.executeUpdate
				("insert into bizzlers_authentication.user(login_id,login_password,user_info,last_login) values ('"+username+"',AES_ENCRYPT('"+password+"','"+username+"'),'"+uid+"','"+dnow+"')");
				}
				else
					status = 1 ;
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
			return status ;
	}
	
	
	public int  changePassword(){
		
		int n=1;
		int idTemp=0;
		try{
		
			statement = connection.createStatement();
			rsUser = statement.executeQuery
						("select * from bizzlers_authentication.user where login_id='"+username+"' and login_password=AES_ENCRYPT('"+password+"','"+username+"')" );
			while(rsUser.next()){
			idTemp=rsUser.getInt("user_id");
			}
				if(idTemp!=0){
					n=statement.executeUpdate
							("UPDATE bizzlers_authentication.user SET login_password=AES_ENCRYPT('"+npass+"','"+username+"') WHERE login_id='"+username+"'");
				}
				else
					n =  0;
			
		}catch (SQLException e){
      		e.printStackTrace();
      	}
	
		return n ;
	}
}
