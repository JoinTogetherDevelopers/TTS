package org.dorageecorp.main.dao;

import java.util.List;

import org.dorageecorp.main.model.Project;

public interface MainMapper {

	public List<Project> selectTotalProjects();
	
	public List<Project> selectMyProjects(String userId);
}