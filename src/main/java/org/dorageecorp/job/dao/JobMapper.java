package org.dorageecorp.job.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.dorageecorp.job.model.JobVersionTemplate;

@Mapper
public interface JobMapper {

	List<JobVersionTemplate> selectJobTemplateAllList(String projectId);

	List<JobVersionTemplate> selectJobTemplateVersionList(Map<String, String> projectAndJob);
	
	List<JobVersionTemplate> selectJobVersionList(Map<String, String> projectAndJob);

	List<JobVersionTemplate> selectJobVersionList(String projectId, String jobMasterCode);
	
	JobVersionTemplate selectJobDetail(JobVersionTemplate jobVersion);
}