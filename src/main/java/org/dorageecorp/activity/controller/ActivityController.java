package org.dorageecorp.activity.controller;

import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.dorageecorp.activity.bo.ActivityBO;
import org.dorageecorp.activity.model.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping(value = "/activityList")
    public ModelAndView activityList() {
        ModelAndView mav = new ModelAndView("/activity/activityList");
        log.info("activityList");
        try {
            List<Activity> activityList = activityBO.getActivityList();
            mav.addObject("activityList", activityList);
        } catch (Exception e) {
            log.error("activityList error {} ", e);
        }
        return mav;
    }

    @GetMapping(value = "/activityDetail")
    public ModelAndView openActivityDetail(@RequestParam("no") int no) {
        ModelAndView mav = new ModelAndView("/activity/activityDetail");

        Activity activity = null;

        try {
            activity = activityBO.getActivityDetail(no);
            mav.addObject("activity", activity);
        } catch (Exception e) {
            log.error("activityDetail error : {}", e);
        }

        return mav;
    }

    @GetMapping(value = "/openJobTemplateDetail")
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