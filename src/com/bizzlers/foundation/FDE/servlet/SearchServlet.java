package com.bizzlers.foundation.FDE.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bizzlers.foundation.FDE.FDE;
import com.bizzlers.foundation.FDE.ClassResultSet;

/**
 * Servlet implementation class SearchServlet
 */
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String query = request.getParameter("query");
		
		//TODO check special char here....
		if (query.equals(null) || query.equals("") || query.isEmpty() )
			response.sendRedirect("");
		
		else{
		FDE fde = new FDE();
		
		
		
		Vector<ClassResultSet> resultSets = fde.search(query);
		ClassResultSet count = new ClassResultSet();
		count.setDataType(resultSets.size()-1); // total element
		count.setFieldOne(0); // starting index
		resultSets.add(resultSets.size(),count);
		
		
		// pass this vector to jsp
		
		request.setAttribute("result", resultSets);
		
		
		RequestDispatcher dispatcher = 
						getServletContext().getRequestDispatcher("/jsp/SearchDisplay.jsp");
		
		dispatcher.forward(request, response);
		
		}
	
	}

}
