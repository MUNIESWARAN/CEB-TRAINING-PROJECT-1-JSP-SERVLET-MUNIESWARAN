package com.model;

public class Registration {
	public int employeeId;
	public String firstName;
	public String lastName;
	public String gender;
	public String dateOfBirth;
	public String commAddress;
	public String emailid;
	public String password;
	public String contact;
	public String userType;
	public String status;
	public Registration() {
		super();
	}
	
	public Registration(String firstName, String lastName, String gender, String dateOfBirth, String commAddress,
			String emailid, String password, String contact, String userType, String status) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.commAddress = commAddress;
		this.emailid = emailid;
		this.password = password;
		this.contact = contact;
		this.userType = userType;
		this.status = status;
	}

	public Registration(int employeeId, String firstName, String lastName, String gender, String dateOfBirth,
			String commAddress, String emailid, String password, String contact, String userType, String status) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.commAddress = commAddress;
		this.emailid = emailid;
		this.password = password;
		this.contact = contact;
		this.userType = userType;
		this.status = status;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getCommAddress() {
		return commAddress;
	}
	public void setCommAddress(String commAddress) {
		this.commAddress = commAddress;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
