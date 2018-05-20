package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchSkill
 */
@WebServlet("/SearchSkill")
public class SearchSkill extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchSkill() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter writeToBrowser = response.getWriter();
		String searchQuery = request.getParameter("q");
		try {
			
			System.out.println("Fetching all Competency Details.");
			Class.forName("org.h2.Driver");
			Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "sa");
			String qry="SELECT registration.employeeid, registration.firstname, registration.lastname, registration.emailid, registration.contact, competency.skilllevel , registration.usertype FROM registration JOIN competency ON registration.employeeid = competency.employeeid WHERE competency.skilllevel  LIKE '%"+searchQuery+"%' and REGISTRATION.status = 'APPROVED' ORDER BY registration.employeeid";
			PreparedStatement preparedStatement = connection.prepareStatement(qry);
			ResultSet resultSet = preparedStatement.executeQuery();
			writeToBrowser.println("<table>");
			while(resultSet.next()) {
				System.out.println("Getting details "+ resultSet.getInt(1));
			writeToBrowser.println("<tr><td>"+resultSet.getInt(1)+"</td><td>"+resultSet.getString(2)+"</td><td>"+resultSet.getString(3)+"</td><TD>"+resultSet.getString(6)+"</td></tr>");
			}
			writeToBrowser.println("</table>");
			 connection.close();
					
			
		}catch(Exception e) {
			System.out.println("Error getting list of employees who are not approved yet  "  +e );
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		PrintWriter writeToBrowser = response.getWriter();
		String searchQuery = request.getParameter("q");
		try {
			System.out.println("Fetching all Competency Details.");
			Class.forName("org.h2.Driver");
			Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "sa");
			String qry="SELECT registration.employeeid, registration.firstname, registration.lastname, registration.emailid, registration.contact, competency.skilllevel , registration.usertype FROM registration JOIN competency ON registration.employeeid = competency.employeeid WHERE competency.skilllevel  LIKE '%"+searchQuery+"%' and REGISTRATION.status = 'APPROVED' ORDER BY registration.employeeid";
			PreparedStatement preparedStatement = connection.prepareStatement(qry);
			ResultSet resultSet = preparedStatement.executeQuery();
			writeToBrowser.println("<table>");
			while(resultSet.next()) {
			writeToBrowser.println("<tr><td>"+resultSet.getInt(1)+"</td><td>"+resultSet.getString(2)+"</td><td>"+resultSet.getString(3)+"</td></tr>");
			}
			writeToBrowser.println("</table>");
			 connection.close();
					
			
		}catch(Exception e) {
			System.out.println("Error getting list of employees who are not approved yet  "  +e );
		}
	}

}
