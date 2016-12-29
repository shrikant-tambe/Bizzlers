package com.bizzlers.net;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;


import com.bizzlers.foundation.platform.DataManager;
import com.bizzlers.util.Binary;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public class Temp {

	/**
	 * @param args
	 * @throws java.text.ParseException 
	 */
	public static void main(String[] args) throws java.text.ParseException {

		Connection connection = DataManager.getInstance().getConnection();
	 String p ="" ;
		try {
		Statement statement = connection.createStatement();
		ResultSet resultSet ;
		
		//String[] un = Binary.stringToBin("shri");
		//String[] ps = Binary.stringToBin("shri");
		
		
		//System.out.print(un[0] +"     "+ps[0]);
		
		//statement.execute("CALL `bizzlers_authentication`.`encrypt_password`('"+un+"','"+ps+"','myKey',@en); ");
		statement.execute("CALL `bizzlers_authentication`.`encrypt_password`('un','ps','myKey',@en); ");
		resultSet = statement.executeQuery("SELECT @en as enpass; ");
		
		while(resultSet.next()){
			p=resultSet.getString(1);
			
			System.out.print(p);
		}
		
		
		//statement.execute("CALL `bizzlers_authentication`.`decrypt_password`('"+p+"','"+un+"','myKey',@en); ");
		statement.execute("CALL `bizzlers_authentication`.`decrypt_password`('"+p+"','un','myKey',@en); ");
		resultSet = statement.executeQuery("SELECT @en as enpass; ");
		
		while(resultSet.next()){
			
			 p = resultSet.getString(1);
			System.out.print(p);
		} 
		
		
		
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		

	}

}
