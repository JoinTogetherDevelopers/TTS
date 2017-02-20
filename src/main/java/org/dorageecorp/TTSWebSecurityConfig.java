package org.dorageecorp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Security 설
 * 
 * @author soup
 *
 */
@Configuration
@EnableWebSecurity
public class TTSWebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/", "/resources/**", "/trylogin", "/register").permitAll().anyRequest()
				.authenticated().and().formLogin().loginPage("/login").failureUrl("/login?error").permitAll().and()
				.logout().permitAll();
		http.csrf().disable();
		// TODO 세션관리기능 추가시 사용예정
		// http.sessionManagement().invalidSessionUrl("/login");
	}

	/*
	 * 등록된 유저인지 확인
	 */
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		// TODO 추후 DB에서 비교하는 방식으로 설정 예정
		auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
	}
}
