package org.dorageecorp.main.model;

import lombok.Data;
import org.dorageecorp.util.PagingStandard;

@Data
public class Project {
	private int sequence;
	private String privateKey;
	private String projectKey;
	private String projectName;
	private String addressId;
	private String name;
	private String description;
	private int activityCount;
	private String managerId;
	private String category;
	private String creatorId;
	private String createDate;
	private String modifierName;
	private String modifyDate;
	private String myRole;
	private PagingStandard pagingStandard;
	
}