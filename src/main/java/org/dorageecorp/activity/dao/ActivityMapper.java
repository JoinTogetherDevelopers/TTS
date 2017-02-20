package org.dorageecorp.activity.dao;

import java.util.List;

import org.dorageecorp.activity.model.Activity;

public interface ActivityMapper {

	public List<Activity> selectActivityList();

	public Activity selectActivityDetail(int no);

	public List<String> selectColumnNames();

	public List<String> selectColumnData();
}