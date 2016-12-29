package com.bizzlers.foundation.platform.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bizzlers.foundation.FDE.ClassResultSet;
import com.bizzlers.foundation.platform.Service;
import com.bizzlers.foundation.platform.Tag;

/**
 * Servlet implementation class ViewServices
 */
public class ViewTags extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewTags() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("bid"));
		Vector<ClassResultSet> names = new Vector<ClassResultSet>();
		Tag tag = new Tag();
		names = tag.getTagListbyBusinessId(id);
		
		
		request.setAttribute("names", names);
		getServletContext().getRequestDispatcher("/jsp/viewtags.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Service sObj=new Service();
		Vector<String> list = new Vector<String>();
		list=sObj.getInfo();
		
		request.setAttribute("catelog", "product");
		request.setAttribute("list", list);
		getServletContext().getRequestDispatcher("/jsp/viewptags.jsp").forward(request, response);
	}

}
