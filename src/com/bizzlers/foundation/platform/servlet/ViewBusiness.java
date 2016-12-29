package com.bizzlers.foundation.platform.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bizzlers.foundation.platform.Business;

/**
 * Servlet implementation class ViewBusiness
 */
public class ViewBusiness extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewBusiness() {
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
		
		int uid = (Integer)request.getSession().getAttribute("uid");
		Business business = new Business() ;
		int bid[] = business.getBusinessIds(uid);
		Vector<String> names = business.getBusinessNames(bid);

		String bids  = business.intArrayToString(bid);
		
		request.setAttribute("result", names);
		request.setAttribute("bid", bids);
		
		request.getSession().setAttribute("bids", bids);
		
		getServletContext().getRequestDispatcher("/jsp/viewbusinesslist.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
