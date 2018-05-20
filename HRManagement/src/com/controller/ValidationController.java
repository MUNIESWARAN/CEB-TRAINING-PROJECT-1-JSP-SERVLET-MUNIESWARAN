package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

/**
 * Servlet implementation class ValidationController
 */
@WebServlet("/ValidationController")
public class ValidationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ValidationController() {
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
		// doGet(request, response);

		PrintWriter out = response.getWriter();
		out.println("Testing");
		boolean flag = true;
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

		Map<String, String> errMap = new HashMap<String, String>();
		if (firstName.length() == 0) {
			errMap.put("firstname", "Please Enter Your First Name");
			flag = false;
		} else if (firstName.length() < 5) {
			errMap.put("firstname", "Your name looks too short please check :)");
			flag = false;
		} else {
			errMap.put("firstname", "");

		}

		if (lastName.length() == 0) {
			errMap.put("lastname", "Please Enter Your Last Name");
			flag = false;
		} else if (firstName.length() < 5) {
			errMap.put("lastname", "Your last name looks too short please check :) ");
			flag = false;
		} else {
			errMap.put("lastname", "");

		}

		if (dateOfBirth.length() == 0) {
			errMap.put("dateofbirth", "Please Enter Your Date of Birth");
			flag = false;
		}else if(isValidDate(dateOfBirth)) {
			errMap.put("dateofbirth", "Please enter a date between 01/01/1980 - 31/12/2000");
			flag = false;
		}else {
			errMap.put("dateofbirth", "");
		}

		

		if (commAddress.length() == 0) {
			errMap.put("commaddress", "Address Field cannot be empty");
			flag = false;
		}else if(commAddress.length() < 6) {
			errMap.put("commaddress", "Please enter address it looks its partially entered");
			flag = false;
		}else {
			errMap.put("commaddress", "");
		}

		if (password.length() == 0) {
			errMap.put("password", "Must Enter a Password");
			flag = false;
		}else if(commAddress.length() < 6) {
			errMap.put("password", "Password must be minimum 6 characters long :( ");
			flag = false;
		}else {
			errMap.put("password", "");
		}
		
		
		if (emailid.length() == 0) {
			errMap.put("emailid", "Must Enter Your Email Id");
			flag = false;
		}else if(!isValidEmailAddress(emailid)) {
			errMap.put("emailid", "Invalid Email Id :( ");
			flag = false;
		}else {
			errMap.put("emailid", "");
		}
		
		if (contact.length() == 0) {
			System.out.println("Contact length is zero");
			errMap.put("contact", "Must Enter Your Contact Information");
			flag = false;
		}else if(contact.length() < 10 || contact.length() > 10) {
			errMap.put("contact", "Please Enter a 10 Digit number ");
			System.out.println("length mismatch");
			flag = false;
		}else if(!isValidContactNumber(contact)) {
			System.out.println("Invalid Contact number");
			errMap.put("contact", "Invalid Contact Number Please enter a 10 digit contact number");
		}else {
			errMap.put("contact", "");
		}
		
		
		
		
		if (flag) {
			response.sendRedirect("Success?message=All data is validated :) ");
		} else {

			request.setAttribute("errMap", errMap);
			request.getRequestDispatcher("RegisterUserSerlvet").forward(request, response);
		}
	}

	public boolean isValidDate(String dateOfBirth) {
		String result = "";
		boolean flag=false;
		Date date1;
		try {
			date1 = new SimpleDateFormat("dd/MM/yyyy").parse(dateOfBirth);

			Date fromDate = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/1980");
			Date toDate = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2001");

			if (!(date1.after(fromDate) && date1.before(toDate))) {
				flag=true;
			}

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("Checking Date Validity...Error : " + e);
		}

		return flag;
	}
	
	public boolean isValidEmailAddress(String email) {
		   boolean result = true;
		   try {
			  InternetAddress emailAddr = new InternetAddress(email);
		      emailAddr.validate();
		      } catch (AddressException ex) {
		      result = false;
		   }
		   return result;
		}

	public boolean isValidContactNumber(String contact) {
		boolean result = false;
		String pattern ="^[789]\\d{9}$";
		if(contact.matches(pattern)) {
			result = true;
		}
		return result;
		
	}
}
