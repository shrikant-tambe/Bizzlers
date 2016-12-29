package com.bizzlers.util;
import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class retrieve_image 
{
	public static void main(String[] args)throws Exception
	{

			
		
		
		    JFrame f=new JFrame();
	        f.setLayout(null);
	        JLabel lab1=new JLabel();
	        JLabel lab2=new JLabel("Name");
	        JTextField text1=new JTextField(20);
	        JLabel lab3=new JLabel("City");
	        JTextField text2=new JTextField(20);
	        
	        Connection conn = DataManager.getInstance().getConnection();
	        
	        Statement st=conn.createStatement();
	        ResultSet rs=st.executeQuery("select * from store_image where id=1");
	        byte[] bytes = null;
	        
	        if(rs.next())
	        {
	            String name=rs.getString("name");
	            text1.setText(name);
	            
	            String city=rs.getString("city");
	            text2.setText(city);
	            
	            bytes = rs.getBytes("image");
	            java.awt.Image image = f.getToolkit().createImage(bytes);
	            ImageIcon icon=new ImageIcon(image);
	            lab1.setIcon(icon);
	            
	            //String phone=rs.getString("phone");
	            //text3.setText(phone);
	            
	            lab1.setBounds(150,10,100,100);
	            lab2.setBounds(10,120,100,20);
	            text1.setBounds(150,120,100,20);

	            lab3.setBounds(10,150,100,20);
	            text2.setBounds(150,150,100,20);
	            f.add(lab1);
	            f.add(lab2);
	            f.add(text1);
	            f.add(lab3);
	            f.add(text2);
	            f.setVisible(true);
	            f.setSize(350,200);
	            
	            
	        }
	        
	}


}