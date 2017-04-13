package org.dorageecorp.security;

import org.dorageecorp.security.handler.AuthLoginFailureHandler;
import org.dorageecorp.security.handler.AuthLoginSuccessHandler;
import org.dorageecorp.security.handler.AuthLogoutSuccessHandler;
import org.dorageecorp.user.bo.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Security 설
 *
 * @author soup
 */
@Configuration
@EnableWebSecurity
public class TTSWebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserService userService;

    @Autowired
    private AuthLoginSuccessHandler authSuccessHandler;

    @Autowired
    private AuthLoginFailureHandler authFailureHandler;

    @Autowired
    private AuthLogoutSuccessHandler logoutSuccessHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

            http.authorizeRequests().antMatchers("/console/*").permitAll()
                .and()
                .formLogin().loginPage("/login").successHandler(authSuccessHandler).failureHandler(authFailureHandler).permitAll()
                .and()
                .logout().logoutSuccessHandler(logoutSuccessHandler).permitAll()
                .and()
                .httpBasic()
                .and().csrf().disable();
        // TODO 세션관리기능 추가시 사용예정
        // http.sessionManagement().invalidSessionUrl("/login");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**", "/console/*");
    }

    /*
     * 등록된 유저인지 확인
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(userService.passwordEncoder());
    }

}
