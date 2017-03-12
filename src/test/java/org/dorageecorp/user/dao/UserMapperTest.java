package org.dorageecorp.user.dao;

import java.util.ArrayList;
import java.util.List;

import org.dorageecorp.user.bo.UserService;
import org.dorageecorp.user.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

	@Autowired
	private UserService userService;

	@Test
	public void testUserService() {

		User user = new User();
		user.setUserId("myId");
		user.setUserName("kevin");
		user.setPassword("onepassword");
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ADMIN"));
		authorities.add(new SimpleGrantedAuthority("USER"));
		user.setAuthorities(authorities);
		userService.createUser(user);
		User result = userService.getUser("myId");

		result.getAuthorities().forEach(e -> System.out.println(e.getAuthority()));

	}

}