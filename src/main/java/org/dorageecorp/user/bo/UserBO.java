package org.dorageecorp.user.bo;

import org.dorageecorp.user.model.User;

public interface UserBO {

	public boolean isValidUser(User user);

	public boolean isDuplicationID(String id);

	public void registerUser(User user);
}