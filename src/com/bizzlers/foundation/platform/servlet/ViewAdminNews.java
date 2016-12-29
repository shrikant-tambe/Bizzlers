package com.bizzlers.foundation.platform.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bizzlers.foundation.FDE.ClassResultSet;
import com.bizzlers.foundation.platform.News;

/**
 * Servlet implementation class ViewAdminNews
 */
public class ViewAdminNews extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAdminNews() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		Vector<ClassResultSet> news = new Vector<ClassResultSet>();
		
		News newsObj = new News();
		
		try {
			news = newsObj.getNewsByBid(1);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		
		request.setAttribute("news", news);
		getServletContext().getRequestDispatcher("/jsp/viewadminnews.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		Vector<ClassResultSet> news = new Vector<ClassResultSet>();
		
		News newsObj = new News();
		try {
			news = newsObj.getNewsByBid(1);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("news", news);
		getServletContext().getRequestDispatcher("/jsp/viewadminnews.jsp").forward(request, response);
		
	}

}
