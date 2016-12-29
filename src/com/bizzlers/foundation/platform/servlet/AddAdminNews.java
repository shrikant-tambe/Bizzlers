package com.bizzlers.foundation.platform.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bizzlers.foundation.platform.News;

/**
 * Servlet implementation class AddNews
 */
public class AddAdminNews extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAdminNews() {
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
		String name=request.getParameter("nname");
		String desc=request.getParameter("des");
		
		 new News().addnews(name, desc , -1 );
	
		response.sendRedirect("http://localhost:8080/Bizzlers/jsp/adminprofile.jsp");
		}
	}
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		if(request.getSession().getAttribute("session_name") == null){ 
			response.sendRedirect("http://localhost:8080/Bizzlers/html/loginpage.html");}
		else{
		String name=request.getParameter("nname");
		String desc=request.getParameter("des");
		
		 new News().addnews(name, desc , -1 );
	
		response.sendRedirect("http://localhost:8080/Bizzlers/jsp/adminprofile.jsp");
		}	
	}
	
	

}
