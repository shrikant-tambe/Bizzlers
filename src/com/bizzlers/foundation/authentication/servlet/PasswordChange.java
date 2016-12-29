package com.bizzlers.foundation.authentication.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bizzlers.foundation.authentication.Register;

/**
 * Servlet implementation class PasswordChange
 */
public class PasswordChange extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PasswordChange() {
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
		// TODO Auto-generated method stub
		String opass=request.getParameter("opassword");
		String npass=request.getParameter("npassword");
		String username=(String) request.getSession().getAttribute("session_name");
		Register rObj=new Register(username,opass,npass);
		int n=rObj.changePassword();
		if(n==0){
			request.setAttribute("n",n);
			getServletContext().getRequestDispatcher("/jsp/passwordchange.jsp?attempt=flase").forward(request, response); 
		}
		else
		{
			
			getServletContext().getRequestDispatcher("/jsp/passwordchanged.jsp").forward(request, response); 
		}
	}

}
