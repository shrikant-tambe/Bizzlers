package com.bizzlers.foundation.platform;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewBusinessList
 */
public class ViewBusinessList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewBusinessList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Business bObj=new Business();
		int bid[]={};
		
		int uid = (Integer)request.getSession().getAttribute("uid");
		bid= bObj.getBusinessIds(uid);
		Vector<String> record=bObj.getBusinessNames(bid);
		
		String bids = bObj.intArrayToString(bid);
		
		request.getSession().setAttribute("bid",bids);
		request.setAttribute("result", record);
		getServletContext().getRequestDispatcher("/jsp/viewbusinesslist.jsp").forward(request, response); 
	

	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
