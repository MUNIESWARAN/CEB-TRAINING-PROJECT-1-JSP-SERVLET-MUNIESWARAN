package com.dao;

import java.util.ArrayList;

import com.model.Registration;

public interface HRDao {
	public void approveEmployeeSkills(int employeeId);

	ArrayList<Registration> getListOfEmployeesNotApproved();
	public void approveSkillsFinal(int employeeId);
}
