package org.dorageecorp.activity.bo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dorageecorp.activity.dao.ActivityMapper;
import org.dorageecorp.activity.model.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

@Service
public class ActivityBOImpl implements ActivityBO {

	@Autowired
	private ActivityMapper activityMapper;

	@Override
	public List<Activity> getActivityList() throws Exception {
		return activityMapper.selectActivityList();
	}

	@Override
	public Activity getActivityDetail(int no) {
		return activityMapper.selectActivityDetail(no);
	}

	@Override
	public String getColumnNames() {
		Map<String, Object> columnNameMap = new HashMap<String, Object>();

		List<String> columnName = activityMapper.selectColumnNames();
		columnNameMap.put("list", columnName);

		return new Gson().toJson(columnNameMap);
	}

	@Override
	public String getColumnData() {
		Map<String, Object> columnDataMap = new HashMap<String, Object>();

		List<String> columnData = activityMapper.selectColumnData();
		columnDataMap.put("list", columnData);

		return new Gson().toJson(columnDataMap);
	}
}