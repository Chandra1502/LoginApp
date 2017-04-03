package com.niit.loginapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niit.loginapp.dao.LoginDAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		*The above code is default. I need to create new*/
		
		String userID = request.getParameter("userID"); // name of the userID field in Login.html and we need to typecast since the return type of the method is Object
		String password = request.getParameter("password"); // name of the password in Login.html
		PrintWriter pw = response.getWriter();
		// After this I need to connect it to the DAO to validate the credentials. 
		
		// Create instance of the LoginDAO class
		LoginDAO loginDAO = new LoginDAO();
		
		// get the request dispatcher so that we dispatch either to home page or Login page. We need to write the code in the below If Condition
		
		if(loginDAO.isValidCredentials(userID, password))
		{
			//Navigate to Home Page
			pw.println("Successfuly Signed in, Welcome.");
			RequestDispatcher dispatcher = request.getRequestDispatcher("Home.html");
			dispatcher.include(request, response);
		} // If we are using Spring framework, we need to write the code of If and else because it will be taken care by the Framework
		else
		{
			// Navigate/Dispatch to Login Page
			RequestDispatcher dispatcher = request.getRequestDispatcher("Login.html");
			// Show error message
			pw.println("Invalid Credentials, Please try logging again."); 
			// forward method will only do the RequestDispatcher request. Instead of that if we use include method it will display the print method on the browser and under that we can get the Login page
			dispatcher.include(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
