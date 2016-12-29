package com.bizzlers.net;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//import java.util.StringTokenizer;

//import com.bizzlers.foundation.platform.DataManager;
 
public class DummyDB {
    private int totalCountries;
    
	private Connection connection = null;
	java.sql.Statement statement = null;
	private ResultSet rs;
	private final String url = "jdbc:odbc:shri";
	private final String username = "root";
	private final String password = "B!22lers";
	
    private String data = "";
    private List<String> countries;
   
    public DummyDB() {
    	 countries = new ArrayList<String>();
    	try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver").newInstance();
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
    	try {
			connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	try {
			rs= statement .executeQuery("select * from bizzlers.category" );
			
			while(rs.next()){
			 data=rs.getString("name");
			 countries.add(data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
        
       /* StringTokenizer st = new StringTokenizer(data, ",");
 
        while(st.hasMoreTokens()) {
            countries.add(st.nextToken().trim());
        }*/
        totalCountries = countries.size();
    }
 
    public List<String> getData(String query) {
        String country = null;
        query = query.toLowerCase();
        List<String> matched = new ArrayList<String>();
        for(int i=0; i<totalCountries; i++) {
            country = countries.get(i).toLowerCase();
            if(country.contains(query)) {
                matched.add(countries.get(i));
            }
        }
        return matched;
    }
}