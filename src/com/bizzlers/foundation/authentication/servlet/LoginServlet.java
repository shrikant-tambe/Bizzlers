package com.bizzlers.foundation.authentication.servlet;


import java.io.IOException;

//import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bizzlers.foundation.authentication.*;
import com.bizzlers.foundation.platform.UserInfo;
/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		//String un=""; //used to show user last logging date and time
		
		
		  HttpSession session1 = request.getSession(false);
	        if(session1!=null) {
	        	session1.invalidate();
	        	}

	        
		int uid;
		Login logObj=new Login(username,password);//creating the object of Login class
		
		uid=logObj.authenticate();//call authenticate method from Login class
		

		if(uid==0){
			response.sendRedirect("http://localhost:8080/Bizzlers/jsp/login.jsp?error=0");//if it returns null then return to login page
		}
		else{
			//Date now = new Date();
			//String timestamp = now.toString();
			Cookie cookie = new Cookie ("cookie_name",username);
			cookie.setMaxAge(365 * 24 * 60 * 60);
			response.addCookie(cookie);
			UserInfo uiObj=new UserInfo(uid);
			String fn=uiObj.getName();
			//request.setAttribute("name", fn);
			request.getSession().setAttribute("session_name",username);
			request.getSession().setAttribute("userName",fn);
			request.getSession().setAttribute("uid", new Integer(uid));
			if(uid==1){
				request.getSession().setAttribute("currentbid", new Integer(1));
				getServletContext().getRequestDispatcher("/jsp/adminprofile.jsp").forward(request, response);
				
			}
		else
				getServletContext().getRequestDispatcher("/jsp/userprofile.jsp").forward(request, response);
		}
		

	}

}
