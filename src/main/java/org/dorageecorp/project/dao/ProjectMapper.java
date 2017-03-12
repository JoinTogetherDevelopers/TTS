package org.dorageecorp.project.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.dorageecorp.main.model.Project;
import org.dorageecorp.project.model.ProjectActivity;
import org.dorageecorp.project.model.ProjectInfomation;

@Mapper
public interface ProjectMapper {

	boolean isExistProject(String projectId);

	ProjectInfomation selectProjectInfomation(String projectId);

	List<ProjectActivity> selectProjectActivity(Project project);

	int selectProjectActivityTotalCount(String projectId);
}