package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.RegistrationDaoImp;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		RegistrationDaoImp registrationDAO = new RegistrationDaoImp();
		int employeeid = registrationDAO.getEmployoeeId(email, password);
		if (registrationDAO.validateUser(email, password)) {
			String userType = registrationDAO.getUserType(email, password);
			System.out.println("UserType = " + userType);
			request.getSession().setAttribute("email", email);
			System.out.println("Employee Logged in.. : EmployeeId = "+employeeid);
			request.getSession().setAttribute("employeeid", employeeid);
			request.getSession().setAttribute("userType", userType);
			response.sendRedirect("home.jsp");
		} else {
			response.sendRedirect("index.jsp");
		}
	}

}
