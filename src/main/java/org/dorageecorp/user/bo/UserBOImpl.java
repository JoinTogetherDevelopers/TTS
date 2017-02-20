package org.dorageecorp.user.bo;

import org.dorageecorp.user.dao.UserMapper;
import org.dorageecorp.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserBOImpl implements UserBO {
	
	@Autowired
	private UserMapper userDAO;

	@Override
	public boolean isValidUser(User user) {		
		return userDAO.isValidUser(user);
	}

	@Override
	public boolean isDuplicationID(String id) {
		return userDAO.isDuplicationID(id);
	}

	@Override
	public void registerUser(User user) {
		userDAO.insertUser(user);		
	}
}