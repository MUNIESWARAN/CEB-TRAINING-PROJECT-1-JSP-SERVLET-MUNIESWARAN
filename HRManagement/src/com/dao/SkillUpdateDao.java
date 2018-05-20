package com.dao;

import java.util.ArrayList;

import com.model.SkillsModel;

public interface SkillUpdateDao {
	public ArrayList<String> getListOfSkills(String userType);

	ArrayList<SkillsModel> getListOfSkillsByUserType(String userType);
}
