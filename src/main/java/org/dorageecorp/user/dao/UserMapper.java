package org.dorageecorp.user.dao;

import org.dorageecorp.user.model.User;

public interface UserMapper {
	
	public boolean isValidUser(User user);

	public boolean isDuplicationID(String id);

	public void insertUser(User user);
}