package com.bizzlers.foundation.platform.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bizzlers.foundation.FDE.ClassResultSet;
import com.bizzlers.foundation.platform.Category;

/**
 * Servlet implementation class ReviewCat
 */
public class ReviewCat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewCat() {
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
			
		
		Category category = new Category() ;
		Vector<ClassResultSet> result = new Vector<ClassResultSet>();
		result = category.getUncontolledCategory();
		request.setAttribute("result", result );
		getServletContext().getRequestDispatcher("/jsp/ReviewCategory.jsp").forward(request, response);
		
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getSession().getAttribute("session_name") == null){ 
			response.sendRedirect("http://localhost:8080/Bizzlers/html/loginpage.html");}
		else{
		Category category = new Category() ;
		Vector<ClassResultSet> result = new Vector<ClassResultSet>();
		result = category.getUncontolledCategory();
		request.setAttribute("result", result );
		getServletContext().getRequestDispatcher("/jsp/ReviewCategory.jsp").forward(request, response);
		
		}
	}

}
