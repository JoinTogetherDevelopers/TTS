package org.dorageecorp.main.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.dorageecorp.main.model.Project;

@Mapper
public interface MainMapper {

	public List<Project> selectTotalProjects();
	
	public List<Project> selectMyProjects(String userId);
}