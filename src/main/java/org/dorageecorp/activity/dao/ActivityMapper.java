package org.dorageecorp.activity.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.dorageecorp.activity.model.Activity;

@Mapper
public interface ActivityMapper {

	public List<Activity> selectActivityList();

	public Activity selectActivityDetail(int no);

	public List<String> selectColumnNames();

	public List<String> selectColumnData();
}