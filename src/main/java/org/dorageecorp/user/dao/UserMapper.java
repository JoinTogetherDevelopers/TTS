package org.dorageecorp.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.dorageecorp.user.model.User;

@Mapper
public interface UserMapper {

	public boolean isValidUser(User user);

	public boolean isDuplicationID(String id);

	public void createUser(User user);

	public User getUser(String userId);

	public void deleteUser(String userId);

	public void createAuthorities(User user);

	public List<String> getAuthorities(String userId);

	public void deleteAuthorities(String userId);

}