package com.bizzlers.foundation.platform;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CategoryData {
	

	Connection connection ;
	
	public CategoryData() {
		connection = DataManager.getInstance().getConnection();
	}
	
	public void createTable(String tableName){
		
		connection = DataManager.getInstance().getConnection();
		
		try {
			
		
		Statement statement = connection.createStatement();
		statement.execute("create table bizzlers.tbl_"+tableName+"_data( `id` int(11) NOT NULL AUTO_INCREMENT,  `b_id` int(11) DEFAULT NULL,  `datatype` int(11) DEFAULT NULL,  `reference` int(11) DEFAULT NULL,  PRIMARY KEY (`id`) ,  CONSTRAINT `businesss"+tableName+"key` FOREIGN KEY (`b_id`) REFERENCES `business` (`b_id`))");
		
		}catch(SQLException exception ){
			exception.printStackTrace();
		}
		
	} // method ends
	
	
	public int deleteRequest(int bid , int id ,int type , String catName){
		
		
		java.sql.Statement stcatdata , stSelect  ;
		java.sql.ResultSet set ;
		int status = 0 , cid=0 ;
		
		try{
			
		connection = DataManager.getInstance().getConnection();
		stSelect = connection.createStatement();
		stcatdata = connection.createStatement();
		
		 set = stSelect.executeQuery("select id  from bizzlers.tbl_"+ catName +"_data where b_id="+ bid +" && datatype="+type+" && reference ="+id);
		 
		 while(set.next())
			 cid = set.getInt(1);
		 
		 status = stcatdata.executeUpdate("delete from bizzlers.tbl_"+ catName +"_data where id="+cid);
		
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return status;
		
	}

	
	
	
}
