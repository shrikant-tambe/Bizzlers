package com.bizzlers.foundation.FDE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Shrikant
 * @version 1.0
 */
public class DataManager {
	private static DataManager dataManager = null;
	private Connection connection = null;
	private final String url = "jdbc:odbc:shri";
	private final String username = "root";
	private final String password = "vishakha";

	DataManager() {
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			connection = DriverManager.getConnection(url, username, password);
			
		}catch(SQLException exception){
			exception.printStackTrace();
		}catch (ClassNotFoundException e) {
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
}
