package com.bizzlers.foundation.platform.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bizzlers.foundation.FDE.ClassResultSet;
import com.bizzlers.foundation.platform.Service;

/**
 * Servlet implementation class ViewServices
 */
public class ViewServices extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewServices() {
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
		Vector<ClassResultSet> names = new Vector<ClassResultSet>();
		Service service = new Service();
		names = service.getServiceListbyBusinessId(id);
		
		request.setAttribute("names", names);
		getServletContext().getRequestDispatcher("/jsp/viewservices.jsp").forward(request, response);
		
	}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getSession().getAttribute("session_name") == null){ 
			response.sendRedirect("http://localhost:8080/Bizzlers/html/loginpage.html");}
		else{
			
		
		Service sObj=new Service();
		Vector<String> list = new Vector<String>();
		list=sObj.getInfo();
		
		request.setAttribute("catelog", "product");
		request.setAttribute("list", list);
		getServletContext().getRequestDispatcher("/jsp/viewservices.jsp").forward(request, response);
		
		}
	}

}
