package com.bizzlers.foundation.platform;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.xml.crypto.Data;

import com.bizzlers.foundation.FDE.ClassResultSet;

public class ContactCard {

	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private long pinCode; 
	private String mobile="";
	private String landline="";
	//private long fax;
	
	private int userInfoId;
	private int businessId;
	
	Statement statement;
	ResultSet resultset;
	Connection connection ;
	
	public ContactCard(String addr1,String addr2,String city,String state,String mob,String landline,long pin,int userInfoId, int businessId){
		this.addressLine1=addr1;
		this.addressLine2=addr2;
		this.city=city;
		this.state=state;
		this.pinCode=pin;
		this.mobile=mob;
		this.landline=landline;
		this.userInfoId=userInfoId;
		this.businessId=businessId;
		connection = DataManager.getInstance().getConnection() ;
		
	}
	
	public void insertRequest(){
			
		
			try {
				
				statement= connection.createStatement();
				
				if (mobile.equals("")||mobile.equals(null))
					mobile = "0";
				
				if (landline.equals("") || landline.equals(null))
					landline = "0";
				
				
				statement.executeUpdate
				("insert into bizzlers.contact_card(address_line_1,address_line_2,city,state,pin,mobile,landline,user_info_id,business_id) values ('"+addressLine1+"','"+addressLine2+"','"+city+"','"+state+"',"+ pinCode +","+mobile+","+landline+","+userInfoId+","+businessId+")");
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	public void getBranchAddresses(int bid){
		
		Vector<ClassResultSet> result = new Vector<ClassResultSet>() ;
		
		
		try {
			
			java.sql.Statement  ccstatement = connection.createStatement() ;
			java.sql.ResultSet resultSet  ;
			resultSet = ccstatement.executeQuery("select * from bizzlers.contact_card where business_id="+bid);
			
			while(resultSet.next()){
				ClassResultSet classResultSet = new ClassResultSet() ;
				
				classResultSet.setFieldOne(resultSet.getInt(1));
				
			}
			
		
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
}
