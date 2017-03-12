//package org.dorageecorp.security;
//
//import org.dorageecorp.user.dao.UserMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UserService implements UserDetailsService {
//
//	@Autowired
//	UserMapper userMapper;
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		User user = userMapper.getUser(username);
//		if (user == null) {
//			throw new UsernameNotFoundException("" + username);
//		}
//		return new CustomUserDetail(user);
//	}
//
//}
