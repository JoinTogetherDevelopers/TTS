package org.dorageecorp.activity.controller;

import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.dorageecorp.activity.bo.ActivityBO;
import org.dorageecorp.activity.model.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/activity/*")
public class ActivityController {

	@Autowired
	private ActivityBO activityBO;

	@RequestMapping(value = "/activityList", method = RequestMethod.GET)
	public ModelAndView activityList() {
		ModelAndView mav = new ModelAndView("/activity/activityList");

		List<Activity> activityList = null;
//		log.info("activityList");
		try {
			activityList = activityBO.getActivityList();
			mav.addObject("activityList", activityList);
		} catch (Exception e) {
//			log.error(ReflectionToStringBuilder.toString(activityList), e);
		}

		return mav;
	}

	@RequestMapping(value = "/activityDetail", method = RequestMethod.GET)
	public ModelAndView openActivityDetail(@RequestParam("no") int no) {
		ModelAndView mav = new ModelAndView("/activity/activityDetail");

		Activity activity = null;

		try {
			activity = activityBO.getActivityDetail(no);
			mav.addObject("activity", activity);
		} catch (Exception e) {
//			log.error(ReflectionToStringBuilder.toString(activity), e);
		}

		return mav;
	}

	@RequestMapping(value = "/openJobTemplateDetail", method = RequestMethod.GET)
	public ModelAndView openJobTemplateDetail() {
		ModelAndView mav = new ModelAndView("/activity/jobTemplateDetail");

		String columnNames = null;
		String columnData = null;

		try {
			columnNames = activityBO.getColumnNames();
			columnData = activityBO.getColumnData();
		} catch (Exception e) {
//			log.error("test", e);
		}

		mav.addObject("columnNames", columnNames);
		mav.addObject("columnData", columnData);

		return mav;
	}
}