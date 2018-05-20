package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.model.Registration;

public class RegistrationDaoImp implements RegistrationDao {

	@Override
	public void addUser(Registration registration) {
		// TODO Auto-generated method stub
		System.out.println("Connecting to DB...");
		try {
			Class.forName("org.h2.Driver");
			Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "sa");
			String query = "insert into registration (firstname,lastname, gender, dateofbirth,commaddress,emailid,password,contact,usertype,status) values(?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, registration.firstName);
			preparedStatement.setString(2, registration.lastName);
			preparedStatement.setString(3, registration.gender);
			preparedStatement.setString(4, registration.dateOfBirth);
			preparedStatement.setString(5, registration.commAddress);
			preparedStatement.setString(6, registration.emailid);
			preparedStatement.setString(7, registration.password);
			preparedStatement.setString(8, registration.contact);
			preparedStatement.setString(9, registration.userType);
			preparedStatement.setString(10, registration.status);
			preparedStatement.executeUpdate();
			System.out.println("One Row Inserted into Registration table");
			connection.close();

		} catch (Exception e) {
			System.out.println("Error : " + e);
		}
	}

	@Override
	public boolean validateUser(String email, String password) {
		// TODO Auto-generated method stub
		boolean valid = false;
		System.out.println("Connecting to DB...");
		try {
			Class.forName("org.h2.Driver");
			Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "sa");
			String query = "select * from registration where emailid=? and password=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				valid = true;
			}
 
			System.out.println("Validating User Credentials and result = "+ valid);
			connection.close();

		} catch (Exception e) {
			System.out.println("Error : " + e);
		}
		return valid;
	}

	@Override
	public int getEmployoeeId(String email, String password) {
		// TODO Auto-generated method stub
		int employeeId=0;
		 
		System.out.println("Connecting to DB...");
		try {
			Class.forName("org.h2.Driver");
			Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "sa");
			String query = "select employeeid from registration where emailid=? and password=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				employeeId = resultSet.getInt(1);
				 
			}

			 
			System.out.println("One Row Inserted into Registration table");
			connection.close();

		} catch (Exception e) {
			System.out.println("Error : " + e);
		}
		return employeeId ;
	}
	
	@Override
	public String getUserType(String email, String password) {
		// TODO Auto-generated method stub
		
		String userType="";
		System.out.println("Connecting to DB...");
		try {
			Class.forName("org.h2.Driver");
			Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "sa");
			String query = "select usertype from registration where emailid=? and password=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				 
				userType = resultSet.getString(1);
			}
 
			System.out.println("Getting Employee User Type...");
			connection.close();

		} catch (Exception e) {
			System.out.println("Error : " + e);
		}
		return userType ;
	}

	@Override
	public Registration getEmployeeUsingId(int employeeId) {
		// TODO Auto-generated method stub
		System.out.println("Geting Employee Details using Employee id..."+employeeId);
		Registration employee = new Registration();
		try {
			Class.forName("org.h2.Driver");
			Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "sa");
			String query = "select * from registration where employeeid=?";
			System.out.println("Executing a Query : "+ query);
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, employeeId);
			 
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				 
				 employee = new Registration(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5),resultSet.getString(6), resultSet.getString(7), resultSet.getString(8), resultSet.getString(9), resultSet.getString(10), resultSet.getString(11));
			}
			System.out.println("Employee detail retreived"+employee.employeeId);
			connection.close();

		} catch (Exception e) {
			System.out.println("Error : " + e);
		}
		
		return employee;
	}

}
