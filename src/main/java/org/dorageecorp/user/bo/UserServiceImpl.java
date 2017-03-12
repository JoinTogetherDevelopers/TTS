package org.dorageecorp.user.bo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.dorageecorp.user.dao.UserMapper;
import org.dorageecorp.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@Override
	public boolean isValidUser(User user) {
		return userMapper.isValidUser(user);
	}

	@Override
	public boolean isDuplicationID(String userId) {
		return userMapper.isDuplicationID(userId);
	}

	@Override
	public void createUser(User user) {
		String rawPassword = user.getPassword();
		PasswordEncoder passwordEncoder= new BCryptPasswordEncoder();
		user.setPassword(passwordEncoder.encode(rawPassword));
		userMapper.createUser(user);
		userMapper.createAuthorities(user);
	}

	@Override
	public User getUser(String userId) {
		User user = userMapper.getUser(userId);
		Collection<GrantedAuthority> authorities = getAuthorities(userId);
		user.setAuthorities(authorities);
		return user;
	}

	@Override
	public void deleteUser(String userId) {
		userMapper.deleteUser(userId);
		userMapper.deleteAuthorities(userId);
	}

	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		User user = userMapper.getUser(userId);
		user.setAuthorities(getAuthorities(userId));
		return user;
	}

	@Override
	public Collection<GrantedAuthority> getAuthorities(String userId) {
		List<String> string_authorities = userMapper.getAuthorities(userId);
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (String authority : string_authorities) {
			authorities.add(new SimpleGrantedAuthority(authority));
		}
		return authorities;
	}

	@Override
	public PasswordEncoder passwordEncoder() {
		return this.passwordEncoder;
	}

}