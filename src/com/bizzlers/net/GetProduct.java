package com.bizzlers.net;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GetProduct {
	 private int totaldata;
	    
		private Connection connection = null;
		java.sql.Statement statement = null;
		private ResultSet rs;
		private final String url = "jdbc:odbc:bizzlers";
		private final String username = "root";
		private final String password = "B!22lers";
		
	    private String data = "";
	    private List<String> list;
	   
	    public GetProduct() {
	    	 list = new ArrayList<String>();
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
				rs= statement .executeQuery("select * from bizzlers.products" );
				
				while(rs.next()){
				 data=rs.getString("product_name");
				 list.add(data);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	        
	       /* StringTokenizer st = new StringTokenizer(data, ",");
	 
	        while(st.hasMoreTokens()) {
	            countries.add(st.nextToken().trim());
	        }*/
	        totaldata = list.size();
	    }
	 
	    public List<String> getData(String query) {
	        String country = null;
	        query = query.toLowerCase();
	        List<String> matched = new ArrayList<String>();
	        for(int i=0; i<totaldata; i++) {
	            country = list.get(i).toLowerCase();
	            if(country.startsWith(query)) {
	                matched.add(list.get(i));
	            }
	        }
	        return matched;
	    }
}
