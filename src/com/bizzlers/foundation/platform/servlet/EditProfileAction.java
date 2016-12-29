package com.bizzlers.foundation.platform.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bizzlers.foundation.platform.UserInfo;

/**
 * Servlet implementation class EditProfileAction
 */
public class EditProfileAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProfileAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getSession().getAttribute("session_name") == null){ 
			response.sendRedirect("http://localhost:8080/Bizzlers/html/loginpage.html");}
		else{		 
		
		 	String fname = request.getParameter("firstname");
			String mname = request.getParameter("middlename");
			String lname = request.getParameter("lastname");
			String dob = request.getParameter("dob");
			String gender = request.getParameter("gender");
			
			UserInfo info = new UserInfo(fname, mname, lname, dob, gender);
			int uInfoId = (Integer)request.getSession().getAttribute("uid");
			 info.updateRequest(uInfoId);
			 
		 
		 response.sendRedirect("http://localhost:8080/Bizzlers/viewUserProfile");
		}
		
	}

}
