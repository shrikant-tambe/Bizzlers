package com.bizzlers.foundation.platform;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import com.bizzlers.foundation.FDE.ClassResultSet;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public class News {
	
	String title ;
	String dec ;
	java.sql.Connection connection ;
	java.sql.Statement statement ;
	
	public News(){
		connection = DataManager.getInstance().getConnection();
	}
	
	public void addnews(String titl , String desr , int bid ){
		
		try {
	
			Date now =new Date();
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dnow = format.format(now);
			
			statement=connection.createStatement();
		if(bid != -1)
        	 statement.executeUpdate
		 ("insert into bizzlers.news(title,description,b_id,ndate) values('"+titl+"','"+desr+"',"+bid+",'"+dnow+"')");
		else
			statement.executeUpdate
			 ("insert into bizzlers.adminnews(title,description,ndate) values('"+titl+"','"+desr+"','"+dnow+"')");
         
    	}catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public Vector<ClassResultSet> getNewsByBid(int bid) throws java.text.ParseException{
		
		Vector<ClassResultSet> resultSet = new Vector<ClassResultSet>();
		
		try
		{
			Statement statement = connection.createStatement();
			ResultSet rsNews ;
			
			rsNews = statement.executeQuery("select * from bizzlers.news where b_id="+bid);
			
			while(rsNews.next()){
			
				ClassResultSet set = new ClassResultSet() ;
				set.setFieldOne(rsNews.getInt(1));
				set.setFieldTwo(rsNews.getString("title"));
				set.setFieldThree(rsNews.getString("description"));
				String in =rsNews.getString("ndate");
				
				// format date to dd.mm.yy
				
				SimpleDateFormat fromFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				SimpleDateFormat toFormat = new SimpleDateFormat("dd-MM-yy");
		      
		        try {
		            
		            Date theDate = fromFormat.parse(in); 
		           in = toFormat.format(theDate);
		            
		        } catch (ParseException e) {
		            e.printStackTrace();
		        }
				
		        set.setFieldFour(in);
				
				resultSet.add(set);
			}
			
		
		}catch(SQLException exception){
			exception.printStackTrace();
		}
		
		//TODO reverse vector 
		Vector<ClassResultSet> returnVec = new Vector<ClassResultSet>();
		
		for(int i = resultSet.size()-1 ; i >= 0 ; i --)
			returnVec.add(resultSet.elementAt(i));
		
		return returnVec ;
		
	}
	
	
public Vector<ClassResultSet> getAdminNews() throws java.text.ParseException{
		
		Vector<ClassResultSet> resultSet = new Vector<ClassResultSet>();
		
		try
		{
			Statement statement = connection.createStatement();
			ResultSet rsNews ;
			
			rsNews = statement.executeQuery("select * from bizzlers.adminnews ");
			
			while(rsNews.next()){
			
				ClassResultSet set = new ClassResultSet() ;
				set.setFieldOne(rsNews.getInt(1));
				set.setFieldTwo(rsNews.getString("title"));
				set.setFieldThree(rsNews.getString("description"));
				String in =rsNews.getString("ndate");
				
				// format date to dd.mm.yy
				
				SimpleDateFormat fromFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				SimpleDateFormat toFormat = new SimpleDateFormat("dd-MM-yy");
		      
		        try {
		            
		            Date theDate = fromFormat.parse(in); 
		           in = toFormat.format(theDate);
		            
		        } catch (ParseException e) {
		            e.printStackTrace();
		        }
				
		        set.setFieldFour(in);
				
				resultSet.add(set);
			}
			
		
		}catch(SQLException exception){
			exception.printStackTrace();
		}
		
		//TODO reverse vector 
		Vector<ClassResultSet> returnVec = new Vector<ClassResultSet>();
		
		for(int i = resultSet.size()-1 ; i >= 0 ; i --)
			returnVec.add(resultSet.elementAt(i));
		
		return returnVec ;
		
	}

}
