package com.bizzlers.foundation.platform;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserRelation {

	private String relation;
	private String doj;
	//private StringBuilder cDate;
	private String otherInfo;
	private int userInfoId;
	private int businessId;
	
	Statement statement;
	ResultSet resultset;
	
	public UserRelation(){
		statement=(Statement) DataManager.getInstance().executeRequest();
	}
	public UserRelation(String rel,String exinfo,String formdate,int userInfoId, int businessId){
		this.userInfoId=userInfoId;
		this.businessId=businessId;
		this.relation=rel;
		this.otherInfo=exinfo;
		this.doj=formdate;
		
		statement=(Statement) DataManager.getInstance().executeRequest();
	}
	
	public void insertRequest(){
				
		try {
			statement.executeUpdate
			("insert into bizzlers.user_relation(user_id,business_id,relation,additional_information,since_date) values ("+userInfoId+","+businessId+",'"+relation+"','"+otherInfo+"','"+doj+"')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int[] getBusinessIds(){
		int n;
		int i=0,j=1;
		int[] n2;
		n2 = new int[10];
		try {
			resultset=statement.executeQuery
			("select * from bizzlers.user_relation where user_id='"+Global.userInfoId+"'");
			while(resultset.next()){
				i++;
				n=resultset.getInt("business_id");
				n2[j++]=n;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		n2[0]=i;
		return n2;
	}
	
}
