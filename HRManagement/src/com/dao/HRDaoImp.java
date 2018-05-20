package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.model.Competency;
import com.model.Registration;

public class HRDaoImp implements HRDao{

	@Override
	public void approveEmployeeSkills(int employeeId) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public ArrayList<Registration> getListOfEmployeesNotApproved() {
		// TODO Auto-generated method stub
		ArrayList<Registration> employeeList = new ArrayList<Registration>(); 
		try {
			System.out.println("Fetching all employee details for approval..");
			Class.forName("org.h2.Driver");
			Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "sa");
			String query = "select * from registration where status = 'NOTAPPROVED' and userType not like 'HR'";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				employeeList.add(new Registration(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5),resultSet.getString(6), resultSet.getString(7), resultSet.getString(8), resultSet.getString(9), resultSet.getString(10), resultSet.getString(11)));				
				System.out.println("-> "+resultSet.getString(2));
			}
			 connection.close();
					
			
		}catch(Exception e) {
			System.out.println("Error getting list of employees who are not approved yet  "  +e );
		}
		
		return employeeList;
	}

	@Override
	public void approveSkillsFinal(int employeeId) {
		// TODO Auto-generated method stub
		try {
			System.out.println("Connecting DB for approval..");
			Class.forName("org.h2.Driver");
			Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "sa");
			String query = "update registration set status='APPROVED' where employeeid=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, employeeId);
			preparedStatement.executeUpdate();
		    connection.close();
					
			
		}catch(Exception e) {
			System.out.println("Error Approve Skill:  "  +e );
		}
	}

	
	public ArrayList<Competency> getCompetencyList(String searchQuery){
		
		ArrayList<Competency> competencyList = new ArrayList<Competency>();
		
		
		try {
			System.out.println("Fetching all Competency Details.");
			Class.forName("org.h2.Driver");
			Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "sa");
			String query = "SELECT * FROM COMPETENCY WHERE SKILLLEVEL LIKE '%"+searchQuery+"%'";
			String qry="SELECT registration.employeeid, registration.firstname, registration.lastname, registration.emailid, registration.contact, competency.skilllevel , registration.usertype FROM registration JOIN competency ON registration.employeeid = competency.employeeid WHERE competency.skilllevel  LIKE '%java%' and REGISTRATION.status = 'APPROVED' ORDER BY registration.employeeid";
			PreparedStatement preparedStatement = connection.prepareStatement(qry);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
					System.out.println("-> "+resultSet.getInt(1)+" "+resultSet.getString(2));
			}
			 connection.close();
					
			
		}catch(Exception e) {
			System.out.println("Error getting list of employees who are not approved yet  "  +e );
		}
		return competencyList;
	}


}
