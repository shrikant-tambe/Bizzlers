package com.bizzlers.foundation.platform.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bizzlers.foundation.FDE.ClassResultSet;
import com.bizzlers.foundation.platform.Business;

/**
 * Servlet implementation class ViewBusinessProfile
 */
public class ViewBusinessProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewBusinessProfile() {
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
		int bid = Integer.parseInt(request.getParameter("id"));
		ClassResultSet result = new ClassResultSet();
		
		request.getSession().setAttribute("currentbid",new Integer( bid ));
		
		Business business  = new Business();
		result = business.getBusinessbyId(bid);
	
		request.getSession().setAttribute("currentcid", result.getFieldFour());
		request.getSession().setAttribute("currentcname", result.getFieldEleven());
		
		
		request.setAttribute("result", result);
	
		
		getServletContext().getRequestDispatcher("/jsp/viewbusinessprofile.jsp").forward(request, response);
		
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
