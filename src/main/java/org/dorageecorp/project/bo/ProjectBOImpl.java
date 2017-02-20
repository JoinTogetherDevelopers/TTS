package org.dorageecorp.project.bo;

import java.util.List;

import org.dorageecorp.main.model.Project;
import org.dorageecorp.project.dao.ProjectMapper;
import org.dorageecorp.project.model.ProjectActivity;
import org.dorageecorp.project.model.ProjectInfomation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectBOImpl implements ProjectBO {

	@Autowired
	private ProjectMapper projectDAO;

	@Override
	public boolean isExistProject(String projectId) {
		return projectDAO.isExistProject(projectId);
	}

	@Override
	public ProjectInfomation getProjectInfomation(String projectId) {
		return projectDAO.selectProjectInfomation(projectId);
	}

	@Override
	public List<ProjectActivity> getProjectActivity(Project project) {
		return projectDAO.selectProjectActivity(project);
	}

	@Override
	public int getProjectActivityTotalCount(String projectId) {
		return projectDAO.selectProjectActivityTotalCount(projectId);
	}
}