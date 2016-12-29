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
public class AddNews extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNews() {
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
		int bid=(Integer)request.getSession().getAttribute("currentbid");
		
		 new News().addnews(name, desc , bid );
		 
		 response.sendRedirect("http://localhost:8080/Bizzlers/ViewBusinessProfile?id="+bid);

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
		int bid=(Integer)request.getSession().getAttribute("currentbid");
		
		 new News().addnews(name, desc , bid );
	
		response.sendRedirect("http://localhost:8080/Bizzlers/ViewBusinessProfile?id="+bid);
		}	
	}
	
	

}
