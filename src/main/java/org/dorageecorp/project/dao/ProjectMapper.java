package org.dorageecorp.project.dao;

import java.util.List;

import org.dorageecorp.main.model.Project;
import org.dorageecorp.project.model.ProjectActivity;
import org.dorageecorp.project.model.ProjectInfomation;

public interface ProjectMapper {

	boolean isExistProject(String projectId);

	ProjectInfomation selectProjectInfomation(String projectId);

	List<ProjectActivity> selectProjectActivity(Project project);

	int selectProjectActivityTotalCount(String projectId);
}