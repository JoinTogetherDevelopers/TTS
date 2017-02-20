package org.dorageecorp.project.bo;

import java.util.List;

import org.dorageecorp.main.model.Project;
import org.dorageecorp.project.model.ProjectActivity;
import org.dorageecorp.project.model.ProjectInfomation;

public interface ProjectBO {

	public boolean isExistProject(String projectId);

	public ProjectInfomation getProjectInfomation(String projectId);

	public List<ProjectActivity> getProjectActivity(Project project);

	public int getProjectActivityTotalCount(String projectId);
}