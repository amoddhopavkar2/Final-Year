package com.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//import javax.servlet.http


//import org.apache.catalina.servlet4preview.RequestDispatcher;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out= response.getWriter();
		
		 HttpSession session=request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(username.equals("amoddhopavkar2") && password.equals("amod123"))
		{
			session.setAttribute("user",username);
			/*request.setAttribute("user",username);
			RequestDispatcher rd=request.getRequestDispatcher("welcome.jsp");
			rd.forward(request, response);*/
			response.sendRedirect("welcome.jsp");	
		}
		else
		{
			response.sendRedirect("login.jsp");	
		}
		
		
	}

}