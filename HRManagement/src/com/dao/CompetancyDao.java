package com.dao;

import java.util.ArrayList;

import com.model.Competency;

public interface CompetancyDao {
 
	public void addCompetencyDetails(ArrayList<Competency> competencyList);
	public boolean checkCompetencyUpdated(int employeeId);
	public ArrayList<Competency> getCompetencyForAnEmployee(int employeeId);
	public void updateCompetencyDetails(ArrayList<Competency> competencyList);
}
