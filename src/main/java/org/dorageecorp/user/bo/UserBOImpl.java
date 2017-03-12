package org.dorageecorp.user.bo;

import org.dorageecorp.user.dao.UserMapper;
import org.dorageecorp.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserBOImpl implements UserBO {
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public boolean isValidUser(User user) {		
		return userMapper.isValidUser(user);
	}

	@Override
	public boolean isDuplicationID(String id) {
		return userMapper.isDuplicationID(id);
	}

	@Override
	public void registerUser(User user) {
		userMapper.insertUser(user);		
	}
}