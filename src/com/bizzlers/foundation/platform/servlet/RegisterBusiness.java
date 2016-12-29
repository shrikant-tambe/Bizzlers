package com.bizzlers.foundation.platform.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.bizzlers.foundation.platform.Business;
import com.bizzlers.foundation.platform.UserRelation;

/**
 * Servlet implementation class RegisterBusiness
 */
public class RegisterBusiness extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterBusiness() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
		String category=request.getParameter("category");
		String formation=request.getParameter("form");
		String fplace=request.getParameter("fdplace");
		String fdate=request.getParameter("fddate");
		String website=request.getParameter("web");
		String rel=request.getParameter("rel");
		String exinfo=request.getParameter("exinfo");
		String formdate=request.getParameter("fdate");
		
		String catDes = request.getParameter("catDes");
		
		if (formation.equals("on"))
			formation="Private";
		else
			formation="Public";
		
		Business businessObj=new Business(businessName,tagLine,category,formation,fplace,fdate,website);
		int bid=businessObj.insertRequest(catDes);
		
		request.getSession().setAttribute("currentbid", new Integer(bid));
		
		int uinfoID=(Integer)request.getSession().getAttribute("uid");
		
		UserRelation urObj=new UserRelation(rel,exinfo,formdate,uinfoID,bid);
		urObj.insertRequest();
		
		
		response.sendRedirect("http://localhost:8080/Bizzlers/jsp/newbranch.jsp");
	}
	}
}
