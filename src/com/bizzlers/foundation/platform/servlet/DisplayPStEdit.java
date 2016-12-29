package com.bizzlers.foundation.platform.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bizzlers.foundation.FDE.ClassResultSet;
import com.bizzlers.foundation.platform.Product;
import com.bizzlers.foundation.platform.Service;
import com.bizzlers.foundation.platform.Tag;

/**
 * Servlet implementation class DisplayPStEdit
 */
public class DisplayPStEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayPStEdit() {
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
		int bid = (Integer)request.getSession().getAttribute("currentbid");
		String stype = (String)request.getAttribute("datatype");
		
	    Vector<ClassResultSet> result = new Vector<ClassResultSet>();
		
	    if(stype.equals("1"))
	    	result = new Product().getProductListbyBusinessId(bid);
	    else if(stype.equals("2"))
	    	result =new Service().getServiceListbyBusinessId(bid);
	    else if(stype.equals("3"))
	    	result =new Tag().getTagListbyBusinessId(bid);
	    
	    request.setAttribute("result", result);
	    getServletContext().getRequestDispatcher("/jsp/DisplayPSTEdit.jsp").forward(request, response);
	    
	}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
