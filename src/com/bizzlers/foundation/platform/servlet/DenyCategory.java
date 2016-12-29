package com.bizzlers.foundation.platform.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bizzlers.foundation.platform.Category;

/**
 * Servlet implementation class DenyCategory
 */
public class DenyCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DenyCategory() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int cid = Integer.parseInt(request.getParameter("id"));
		
		Category category = new Category();
		
		category.deleteCategoryById(cid);
		
		//TODO redirect accordingly status returnded by delete 
		
		getServletContext().getRequestDispatcher("/ReviewCat").forward(request, response);
			

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	

		int cid = Integer.parseInt(request.getParameter("id"));
		
		Category category = new Category();
		
		category.deleteCategoryById(cid);
		
		//TODO redirect accordingly status returnded by delete 
		
		getServletContext().getRequestDispatcher("/ReviewCat").forward(request, response);
		
	}

}
