package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.RegistrationDao;
import com.dao.RegistrationDaoImp;
import com.model.Registration;

/**
 * Servlet implementation class RegisterUserController
 */
@WebServlet("/RegisterUserController")
public class RegisterUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterUserController() {
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
		
		Registration obj = new Registration(101, "firstName", "lastName", "gender", "dateOfBirth", "commAddress",
				" emailid", "password", "contact", "userType", " status");
		new RegistrationDaoImp().addUser(obj);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		PrintWriter out = response.getWriter();
		out.println("Testing");
	 
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String gender = request.getParameter("gender");
		String dateOfBirth = request.getParameter("dateofbirth");
		String commAddress = request.getParameter("commaddress");
		String emailid = request.getParameter("emailid");
		String password = request.getParameter("password");
		String contact = request.getParameter("contact");
		String userType = request.getParameter("usertype");
		String status = "NOTAPPROVED";
		
		Registration register = new Registration(firstName, lastName, gender, dateOfBirth, commAddress, emailid, password, contact, userType, status);
		RegistrationDao registrationDao = new RegistrationDaoImp();
		registrationDao.addUser(register);
		response.sendRedirect("Success?message=User Registered Successfully");
	}

}
