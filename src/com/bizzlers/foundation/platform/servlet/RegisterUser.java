package com.bizzlers.foundation.platform.servlet;

import java.io.IOException;
import com.bizzlers.foundation.platform.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bizzlers.foundation.authentication.*;

/**
 * Servlet implementation class RegisterUser
 */
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String firstName=request.getParameter("firstname");
		String middleName=request.getParameter("middlename");
		String lastName=request.getParameter("lastname");
		String dob=request.getParameter("dob");
		String gender=request.getParameter("gender");
		int userInfoId;
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		
		UserInfo registerUser=new UserInfo(firstName,middleName,lastName,dob,gender);
		userInfoId=registerUser.insertRequest();
		
		Register ru=new Register(username,password,userInfoId);
		int status = ru.addUser();
		
		if(status == 1){
			registerUser.rollbackRequest(userInfoId);
			getServletContext().getRequestDispatcher("/jsp/login.jsp?error=1").forward(request, response);
		}
		
		else
		{
		request.getSession().setAttribute("session_name",username);
		request.getSession().setAttribute("userName",firstName);
		request.getSession().setAttribute("uid", userInfoId);
		
			getServletContext().getRequestDispatcher("/jsp/userprofile.jsp").forward(request, response); 
		}
	}

}
