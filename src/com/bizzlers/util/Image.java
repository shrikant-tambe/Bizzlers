package com.bizzlers.util;
import java.sql.*;
import java.io.*;
//import java.sql.Connection;

public class Image 
{
	public static void main(String[] args) throws SQLException 
	{
		Connection connection=null ;
		ResultSet rs = null;
		PreparedStatement psmnt = null;
		FileInputStream fis;
	
	
		try
		{
			connection= DataManager.getInstance().getConnection();

			File image = new File("G:/success.png");
			
			psmnt = connection.prepareStatement
			("insert into store_image(name, city, image, Phone) "+ "values(?,?,?,?)");
			psmnt.setString(1,"mahendra");
			psmnt.setString(2,"Delhi");
			psmnt.setString(4,"123456");
			fis = new FileInputStream(image);
			psmnt.setBinaryStream(3, (InputStream)fis, (int)(image.length()));
			
			int s = psmnt.executeUpdate();
			if(s>0)
			{
				System.out.println("Uploaded successfully !");
			}
			else
			{
				System.out.println("unsucessfull to upload image.");
			}
		}
			// catch if found any exception during rum time.
		catch (Exception ex) 
		{
			System.out.println("Found some error : "+ex);
		}
			
		finally 
		{
			// close all the connections.
			connection.close();
			psmnt.close();
		}
			
			
	}
}



