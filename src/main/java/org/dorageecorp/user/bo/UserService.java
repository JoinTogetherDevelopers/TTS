package org.dorageecorp.user.bo;

import java.util.Collection;

import org.dorageecorp.user.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

public interface UserService extends UserDetailsService {

	public boolean isValidUser(User user);

	public boolean isDuplicationID(String id);

	public void createUser(User user);

	public User getUser(String userId);

	public void deleteUser(String userId);

	Collection<GrantedAuthority> getAuthorities(String username);

	public PasswordEncoder passwordEncoder();

}