package org.dorageecorp.main.bo;

import java.util.List;

import org.dorageecorp.main.model.Project;;

public interface MainBO {
	public List<Project> getTotalProjects();

	public List<Project> getMyProjects(String userId);
}