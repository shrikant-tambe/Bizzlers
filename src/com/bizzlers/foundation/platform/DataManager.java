package com.bizzlers.foundation.platform;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class DataManager {
	private static DataManager dataManager = null;
	private Connection connection = null;
	private final String url = "jdbc:odbc:shri";
	private final String username = "root";
	private final String password = "vishakha";
	
	DataManager() {
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver").newInstance();
			connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static DataManager getInstance() {
		if (dataManager == null) {
			dataManager = new DataManager();
		}
		return dataManager;
	}
	
	public Connection getConnection(){
		return connection;
	}

	public Object executeRequest() {
		Object returnObject = null;
		try {
			Statement statement = connection.createStatement();
			returnObject=statement;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return returnObject;
	}
}
