package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.model.Competency;
import com.model.SkillsModel;

public class CompetancyDaoImp implements CompetancyDao {

	@Override
	public void addCompetencyDetails(ArrayList<Competency> competencyList) {
		// TODO Auto-generated method stub

		for (Competency competency : competencyList) {
			addCompetancyDetails(competency);
		}

	}

	@Override
	public void updateCompetencyDetails(ArrayList<Competency> competencyList) {
		// TODO Auto-generated method stub
		for (Competency competency : competencyList) {
			updateCompetancyDetails(competency);
		}
	}

	public void addCompetancyDetails(Competency competency) {
		try {
			Class.forName("org.h2.Driver");
			Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "sa");

			String query = "insert into competency values(?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, competency.getEmployeeId());
			preparedStatement.setInt(2, competency.getSkillId());
			preparedStatement.setString(3, competency.getSkillLevel());

			preparedStatement.executeUpdate();
			System.out.println("Updating Skill Details");
			connection.close();

		} catch (Exception e) {
			System.out.println("Error : " + e);
		}

	}

	
	public void updateCompetancyDetails(Competency competency) {
		try {
			Class.forName("org.h2.Driver");
			Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "sa");

			String query = "update competency set skillLevel =? where employeeid=? and skillId=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, competency.getSkillLevel());
			preparedStatement.setInt(2, competency.getEmployeeId());
			preparedStatement.setInt(3, competency.getSkillId());

			preparedStatement.executeUpdate();
			System.out.println("Updating Skill Details");
			connection.close();

		} catch (Exception e) {
			System.out.println("Error : " + e);
		}

	}

	@Override
	public boolean checkCompetencyUpdated(int employeeId) {
		// TODO Auto-generated method stub
		boolean valid = false;
		System.out.println("Connecting to DB...");
		try {
			Class.forName("org.h2.Driver");
			Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "sa");
			String query = "SELECT * FROM COMPETENCY where employeeid =?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, employeeId);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				System.out.println("Competency Details Available for employee : " + employeeId);
				valid = true;
			}

			System.out.println("Checking Competency updated for the given employee id " + employeeId);
			connection.close();

		} catch (Exception e) {
			System.out.println("Error : " + e);
		}
		return valid;

	}

	@Override
	public ArrayList<Competency> getCompetencyForAnEmployee(int employeeId) {
		// TODO Auto-generated method stub

		ArrayList<Competency> competencyList = new ArrayList<Competency>();
		try {
			System.out.println("Fetching competency data for employee id" + employeeId);
			Class.forName("org.h2.Driver");
			Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "sa");
			String query = "SELECT * FROM COMPETENCY where employeeid =?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, employeeId);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				competencyList.add(new Competency(resultSet.getInt(1), resultSet.getInt(2), resultSet.getString(3)));
				System.out.println("Building competency object-> " + resultSet.getString(3));
			}

		} catch (Exception e) {
			System.out.println("Error getting Competency data list  " + e);
		}

		return competencyList;
	}

}
