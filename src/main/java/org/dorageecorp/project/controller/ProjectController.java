package org.dorageecorp.project.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.dorageecorp.main.model.Project;
import org.dorageecorp.project.bo.ProjectBO;
import org.dorageecorp.project.model.ProjectActivity;
import org.dorageecorp.project.model.ProjectInfomation;
import org.dorageecorp.util.PageMaker;
import org.dorageecorp.util.PagingStandard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ProjectController {

	@Autowired
	private ProjectBO projectBO;

	@RequestMapping(value = "/project/{projectId}", method = RequestMethod.GET)
	public ModelAndView projectHome(HttpServletResponse response, @PathVariable String projectId,
			@ModelAttribute PagingStandard pagingStandard) throws IOException {
		ModelAndView mav = new ModelAndView("/project/projectMain");

		if (projectBO.isExistProject(projectId) == false) {
			mav.setViewName("redirect:/noneProject");
			return mav;
		}

		PageMaker pageMaker = new PageMaker();
		pageMaker.setPagingStandard(pagingStandard);
		pageMaker.setTotalCount(projectBO.getProjectActivityTotalCount(projectId));

		Project project = new Project();
		project.setAddressId(projectId);
		project.setPagingStandard(pagingStandard);

		ProjectInfomation projectInfomation = projectBO.getProjectInfomation(projectId);
		List<ProjectActivity> projectActivityList = projectBO.getProjectActivity(project);

		mav.addObject("projectInfomation", projectInfomation);
		mav.addObject("projectActivityList", projectActivityList);
		mav.addObject("pageMaker", pageMaker);

		return mav;
	}

	@RequestMapping(value = "/project/activityList", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> getProjectActivityByPage(String projectId, int page) {

		PagingStandard pagingStandard = new PagingStandard();
		pagingStandard.setPage(page);

		PageMaker pageMaker = new PageMaker();
		pageMaker.setPagingStandard(pagingStandard);
		pageMaker.setTotalCount(projectBO.getProjectActivityTotalCount(projectId));

		Project project = new Project();
		project.setAddressId(projectId);
		project.setPagingStandard(pagingStandard);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("activityList", projectBO.getProjectActivity(project));
		map.put("pageMaker", pageMaker);

		return map;
	}
}