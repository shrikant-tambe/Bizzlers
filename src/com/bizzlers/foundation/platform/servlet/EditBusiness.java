package com.bizzlers.foundation.platform.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bizzlers.foundation.FDE.ClassResultSet;
import com.bizzlers.foundation.platform.Business;


/**
 * Servlet implementation class EditBusiness
 */
public class EditBusiness extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditBusiness() {
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
		Vector<String> result = new Vector<String>();
		
		String businessName=request.getParameter("businessname");
		String tagLine=request.getParameter("tagline");
		String form=request.getParameter("form");
		String fplace=request.getParameter("fdplace");
		String fdate=request.getParameter("fddate");
		String webSite=request.getParameter("web");
				
		Business businessObj=new Business(businessName,tagLine,"",form,fplace,fdate,webSite);
		
		int bid = Integer.parseInt(request.getParameter("bid"));
		
		businessObj.updateRequest(bid);
		
		Business business  = new Business();
		result = business.getBusinessInfo(bid);
		
		
		request.setAttribute("result", result);
		
		
		getServletContext().getRequestDispatcher("/jsp/EditBusiness.jsp").forward(request, response);
	}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getSession().getAttribute("session_name") == null){ 
			response.sendRedirect("http://localhost:8080/Bizzlers/html/loginpage.html");}
		else{
			
		
		String businessName=request.getParameter("businessname");
		String tagLine=request.getParameter("tagline");
		String form=request.getParameter("form");
		String fplace=request.getParameter("fdplace");
		String fdate=request.getParameter("fddate");
		String webSite=request.getParameter("web");
				
		Business businessObj=new Business(businessName,tagLine,"",form,fplace,fdate,webSite);
		
		int bid = (Integer)request.getSession().getAttribute("currentbid");
		
		businessObj.updateRequest(bid);
		
		ClassResultSet result = new ClassResultSet();
		
		
		Business business  = new Business();
		result = business.getBusinessbyId(bid);
		
		request.setAttribute("result", result);
		
		
		getServletContext().getRequestDispatcher("/jsp/viewbusinessprofile.jsp").forward(request, response);

	}
	}
}
