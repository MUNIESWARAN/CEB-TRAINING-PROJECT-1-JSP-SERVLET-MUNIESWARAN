package com.model;

public class Competency {

	int employeeId;
	int skillId;
	String skillLevel;
	
	public Competency() {
		super();
	}

	
	
	public Competency(int employeeId, int skillId, String skillLevel) {
		super();
		this.employeeId = employeeId;
		this.skillId = skillId;
		this.skillLevel = skillLevel;
	}



	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getSkillId() {
		return skillId;
	}

	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}

	public String getSkillLevel() {
		return skillLevel;
	}

	public void setSkillLevel(String skillLevel) {
		this.skillLevel = skillLevel;
	}
	
	
}
