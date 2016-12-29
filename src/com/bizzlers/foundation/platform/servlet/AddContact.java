package com.bizzlers.foundation.platform.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bizzlers.foundation.platform.ContactCard;


/**
 * Servlet implementation class AddContact
 */
public class AddContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddContact() {
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
		String addr1=request.getParameter("addr1");
		String addr2=request.getParameter("addr2");
		String city=request.getParameter("city");
		String state=request.getParameter("state");
		String mob=request.getParameter("mob");
		String landline=request.getParameter("landline");
	
		long pin=Long.parseLong(request.getParameter("pin"));
		//String fax=request.getParameter("fax");
		
		
		int bid=(Integer)request.getSession().getAttribute("currentbid");
		int uinfoID=(Integer)request.getSession().getAttribute("uid");
		
		ContactCard ccObj=new ContactCard(addr1,addr2,city,state,mob,landline,pin,uinfoID,bid);
		ccObj.insertRequest();
		
		
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
			
			
		String addr1=request.getParameter("addr1");
		String addr2=request.getParameter("addr2");
		String city=request.getParameter("city");
		String state=request.getParameter("state");
		String mob=request.getParameter("mob");
		String landline=request.getParameter("landline");
		
		long pin=Long.parseLong(request.getParameter("pin"));
		
		
		int bid=(Integer)request.getSession().getAttribute("currentbid");
		int uinfoID=(Integer)request.getSession().getAttribute("uid");
		
		ContactCard ccObj=new ContactCard(addr1,addr2,city,state,mob,landline,pin,uinfoID,bid);
		ccObj.insertRequest();
		
		response.sendRedirect("http://localhost:8080/Bizzlers/ViewBusinessProfile?id="+bid);
		}
	}

}
