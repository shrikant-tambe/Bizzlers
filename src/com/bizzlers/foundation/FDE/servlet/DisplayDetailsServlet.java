package com.bizzlers.foundation.FDE.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bizzlers.foundation.FDE.ClassResultSet;
import com.bizzlers.foundation.platform.Business;
import com.bizzlers.foundation.platform.Product;
import com.bizzlers.foundation.platform.Service;
import com.bizzlers.foundation.platform.Tag;

/**
 * Servlet implementation class DisplayBusiness
 */
public class DisplayDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayDetailsServlet() {
        super();
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ClassResultSet resultSet = new ClassResultSet();
		int Id = (Integer.parseInt(request.getParameter("id")));
		int type = (Integer.parseInt(request.getParameter("dataType")));
		RequestDispatcher dispatcher=null ;
		
		// business
		if (type == 0 ){
			Business business = new Business();
			resultSet = business.getBusinessbyId(Id);
			request.setAttribute("result", resultSet);
		    dispatcher = getServletContext().getRequestDispatcher("/jsp/DisplayBusinessInfo.jsp");
		}
		
		//product
		else if (type == 1 ){
			Product product = new Product();
			resultSet = product.getProductbyId(Id);
			request.setAttribute("result", resultSet);
		    dispatcher = getServletContext().getRequestDispatcher("/jsp/DisplayProductInfo.jsp");
		}
		
		//service
		else if (type == 2 ){
			Service service = new Service();
			resultSet = service.getServicebyId(Id);
			request.setAttribute("result", resultSet);
		    dispatcher = getServletContext().getRequestDispatcher("/jsp/DisplayServiceInfo.jsp");
		}
		
		//tags
		else if (type == 3 ){
			Tag tag = new Tag();
			resultSet = tag.getTagbyId(Id);
			request.setAttribute("result", resultSet);
		    dispatcher = getServletContext().getRequestDispatcher("/jsp/DisplayTagInfo.jsp");
		}
			
		else
			dispatcher = getServletContext().getRequestDispatcher("/html/index.html"); //send redirect to home	 
		
		
		dispatcher.forward(request, response);	
		
	}

}
