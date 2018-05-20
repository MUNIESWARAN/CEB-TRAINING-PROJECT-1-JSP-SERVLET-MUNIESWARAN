package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.model.SkillsModel;

public class SkillsUpdateDaoImp implements SkillUpdateDao{

	@Override
	public ArrayList<String> getListOfSkills(String userType) {
		// TODO Auto-generated method stub
		ArrayList<String> skillList = new ArrayList<String>(); 
		try {
			System.out.println("Fetching Skills list from table...for user type" + userType);
			Class.forName("org.h2.Driver");
			Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "sa");
			String query = "select * from skills where usertype ='"+userType+"'";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				skillList.add(resultSet.getString(3));				
				System.out.println("-> "+resultSet.getString(3));
			}
			
					
			
		}catch(Exception e) {
			System.out.println("Error getting skills list  "  +e );
		}
		
		return skillList;
	}

	
	 
	public ArrayList<SkillsModel> getListOfSkillsByUserType(String userType) {
		// TODO Auto-generated method stub
		ArrayList<SkillsModel> skillList = new ArrayList<SkillsModel>(); 
		try {
			System.out.println("Fetching Skills list from table...for user type" + userType);
			Class.forName("org.h2.Driver");
			Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "sa");
			String query = "select * from skills where usertype ='"+userType+"'";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				skillList.add(new SkillsModel(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4)));				
				System.out.println("-> "+resultSet.getString(3));
			}
			
					
			
		}catch(Exception e) {
			System.out.println("Error getting skills list  "  +e );
		}
		
		return skillList;
	}
	
}
