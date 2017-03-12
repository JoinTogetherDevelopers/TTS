package org.dorageecorp.user.dao;

import org.apache.ibatis.annotations.Mapper;
import org.dorageecorp.security.CustomUserDetail;
import org.dorageecorp.user.model.User;

@Mapper
public interface UserMapper {
	
	public boolean isValidUser(User user);

	public boolean isDuplicationID(String id);

	public void insertUser(User user);
	
	public User getTempUser(int userNo);
	
	public CustomUserDetail getUser(String userId);
}