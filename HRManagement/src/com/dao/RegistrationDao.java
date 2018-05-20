package com.dao;

import com.model.Registration;

public interface RegistrationDao {
	public void addUser(Registration registration);
	public boolean validateUser(String email, String password);
	public int getEmployoeeId(String email, String password);
	public String getUserType(String email, String password);
	public Registration getEmployeeUsingId(int employeeId);
}
