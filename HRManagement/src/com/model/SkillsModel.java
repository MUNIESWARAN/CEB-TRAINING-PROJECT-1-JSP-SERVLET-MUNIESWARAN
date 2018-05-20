package com.model;

public class SkillsModel {
 int skillId;
 String userType;
 String skillName;
 String skillDescription;
 
 
public SkillsModel() {
	super();
}
public SkillsModel(int skillId, String userType, String skillName, String skillDescription) {
	super();
	this.skillId = skillId;
	this.userType = userType;
	this.skillName = skillName;
	this.skillDescription = skillDescription;
}
public int getSkillId() {
	return skillId;
}
public void setSkillId(int skillId) {
	this.skillId = skillId;
}
public String getUserType() {
	return userType;
}
public void setUserType(String userType) {
	this.userType = userType;
}
public String getSkillName() {
	return skillName;
}
public void setSkillName(String skillName) {
	this.skillName = skillName;
}
public String getSkillDescription() {
	return skillDescription;
}
public void setSkillDescription(String skillDescription) {
	this.skillDescription = skillDescription;
}
 
}
