package com.bizzlers.foundation.platform.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bizzlers.foundation.platform.UserInfo;

/**
 * Servlet implementation class EditProfile
 */
public class EditProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getSession().getAttribute("session_name") == null){ 
			response.sendRedirect("http://localhost:8080/Bizzlers/html/loginpage.html");}
		else{

		Vector<String> result = new Vector<String>();
		UserInfo uiObj=new UserInfo();
		
		
		int id = (Integer)request.getSession().getAttribute("uid");
		
		 result =uiObj.getInfo(id);
		 
		String firstname=result.elementAt(0);
		String middlename=result.elementAt(1);
		String lastname=result.elementAt(2);
		String dob=result.elementAt(3);
		String gender=result.elementAt(4);
		
		request.setAttribute("firstname", firstname);
		request.setAttribute("middlename", middlename);
		request.setAttribute("lastname", lastname);
		request.setAttribute("dob", dob);
		request.setAttribute("gender", gender);
		
		getServletContext().getRequestDispatcher("/jsp/editprofile.jsp").forward(request, response); 
		
		}
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		if(request.getSession().getAttribute("session_name") == null){ 
			response.sendRedirect("http://localhost:8080/Bizzlers/html/loginpage.html");}
		else{

		Vector<String> result = new Vector<String>();
		UserInfo uiObj=new UserInfo();
		
		
		int id = (Integer)request.getSession().getAttribute("uid");
		
		 result =uiObj.getInfo(id);
		 
		String firstname=result.elementAt(0);
		String middlename=result.elementAt(1);
		String lastname=result.elementAt(2);
		String dob=result.elementAt(3);
		String gender=result.elementAt(4);
		
		request.setAttribute("firstname", firstname);
		request.setAttribute("middlename", middlename);
		request.setAttribute("lastname", lastname);
		request.setAttribute("dob", dob);
		request.setAttribute("gender", gender);
		
		getServletContext().getRequestDispatcher("/jsp/editprofile.jsp").forward(request, response); 
		
	}
	}
}
