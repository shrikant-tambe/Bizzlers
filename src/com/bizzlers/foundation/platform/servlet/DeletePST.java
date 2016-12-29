package com.bizzlers.foundation.platform.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bizzlers.foundation.platform.CategoryData;

/**
 * Servlet implementation class DeletePST
 */
public class DeletePST extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePST() {
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
			
		
		int id = Integer.parseInt(request.getParameter("id"));
		int type = Integer.parseInt(request.getParameter("dataType"));
		int bid = (Integer)request.getSession().getAttribute("currentbid");
		String cat = request.getParameter("cat");
		
		
		 int status = new CategoryData().deleteRequest(bid , id , type, cat);
		 if (status == 1){
		if (type==1){
			getServletContext().getRequestDispatcher("/ViewProducts?bid="+bid).forward(request, response);
		}
		else if(type==2){
			getServletContext().getRequestDispatcher("/ViewServices?bid="+bid).forward(request, response);
		}
		else if(type==3){
			getServletContext().getRequestDispatcher("/ViewTags?bid="+bid).forward(request, response);
		}

		 }
		 else
			 getServletContext().getRequestDispatcher("/html/index.html").forward(request, response);
			 
		 
		}
	}



}
