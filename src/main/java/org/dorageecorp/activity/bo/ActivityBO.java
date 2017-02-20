package org.dorageecorp.activity.bo;

import java.util.List;

import org.dorageecorp.activity.model.Activity;

public interface ActivityBO {
	
	public List<Activity> getActivityList() throws Exception;

	public Activity getActivityDetail(int no);

	public String getColumnNames();

	public String getColumnData();
}