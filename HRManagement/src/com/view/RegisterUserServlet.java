package com.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterUserSerlvet
 */
@WebServlet("/RegisterUserSerlvet")
public class RegisterUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterUserServlet() {
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		PrintWriter writeToBrowser = response.getWriter();
		 Map<String, String> errMap = new HashMap<String, String>();
			errMap = (Map<String, String>) request.getAttribute("errMap");
		writeToBrowser.print("<!DOCTYPE html>");
		writeToBrowser.print("<html>");
		writeToBrowser.print("<head>");
		writeToBrowser.print("<meta charset='ISO-8859-1'>");
		writeToBrowser.print("<title>Sign up Page</title>");
		writeToBrowser.print("<style>div{ color: red; }</style></head>");
		writeToBrowser.print("<body>");
		writeToBrowser.print("<h3>Welcome To Registration Page</h3>");
		writeToBrowser.print("<br /> <br />");


		writeToBrowser.print("			<form action='ValidationController' method='post'>");
		writeToBrowser.print("				<br /> First Name: <input type='text' name='firstname' /><div> "+ errMap.get("firstname") +"</div><br /> ");
		writeToBrowser.print("				<br /> Last Name: <input type='text' name='lastname' /><div>" + errMap.get("lastname") + "</div><br />");
		writeToBrowser.print("		<br /> Gender: <input type='radio' name='gender' value='male' checked>");
		writeToBrowser.print("<br /> Male | <input type='radio' name='gender' value='female'>Female<br />");
		writeToBrowser.print("<br /> DATE OF BIRTH: <input type='text' placeholder='DD/MM/YYYY'  required class='datepicker' name='dateofbirth' value='' /><div>"+errMap.get("dateofbirth")+"</div><br /> ");
		writeToBrowser.print("	<br />ADDRESS: 	<input type='text' name='commaddress' /><div>"+errMap.get("commaddress")+"</div><br/> ");
		writeToBrowser.print("				<br />EMAIL:<input type='email' name='emailid' /><div>"+errMap.get("emailid")+" </div> <br /> ");
		writeToBrowser.print("				<br />PASSWORD:	<input type='password' name='password'/> <div>"+errMap.get("password")+"</div> <br />");
		writeToBrowser.print("		<br />CONTACT: <input type='text' name='contact'/><div>"+errMap.get("contact")+"</div><br />");
		writeToBrowser.print("				<br />Signup as:<select name='usertype'>");
		writeToBrowser.print("					<option value='HR'>HR</option>");
		writeToBrowser.print("					<option value='TRAINER'>TRAINER</option>");
		writeToBrowser.print("					<option value='EMPLOYEE'>EMPLOYEE</option>");

		writeToBrowser.print("				</select> <br /><br/><br/> <input type='submit'>");
		writeToBrowser.print("	</form>	</body> 		</html> ");
	}

}
