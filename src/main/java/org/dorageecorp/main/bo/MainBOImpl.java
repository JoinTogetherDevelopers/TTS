package org.dorageecorp.main.bo;

import java.util.List;

import org.dorageecorp.main.dao.MainMapper;
import org.dorageecorp.main.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainBOImpl implements MainBO {

	@Autowired
	private MainMapper mainDAO;

	@Override
	public List<Project> getTotalProjects() {
		return mainDAO.selectTotalProjects();
	}

	@Override
	public List<Project> getMyProjects(String userId) {
		return mainDAO.selectMyProjects(userId);
	}
}