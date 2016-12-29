package com.bizzlers.foundation.platform.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bizzlers.foundation.FDE.ClassResultSet;
import com.bizzlers.foundation.platform.Product;

/**
 * Servlet implementation class ViewProducts
 */
public class ViewProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewProducts() {
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
		int id = Integer.parseInt(request.getParameter("bid"));
		Vector<ClassResultSet> productNames = new Vector<ClassResultSet>();
		Product product = new Product();
		productNames = product.getProductListbyBusinessId(id);
		
		request.setAttribute("productNames", productNames);
		getServletContext().getRequestDispatcher("/jsp/viewproducts.jsp").forward(request, response);
		
	}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getSession().getAttribute("session_name") == null){ 
			response.sendRedirect("http://localhost:8080/Bizzlers/html/loginpage.html");}
		else{
		Product pObj=new Product();
		Vector<String> list = new Vector<String>();
		list=pObj.getInfo();
		
		request.setAttribute("catelog", "product");
		request.setAttribute("list", list);
		getServletContext().getRequestDispatcher("/jsp/viewproducts.jsp").forward(request, response); 
	}
	}
}
