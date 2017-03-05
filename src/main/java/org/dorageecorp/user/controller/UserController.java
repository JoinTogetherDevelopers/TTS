package org.dorageecorp.user.controller;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.dorageecorp.user.bo.UserBO;
import org.dorageecorp.user.model.User;
import org.dorageecorp.util.CookieUtil;
import org.dorageecorp.util.ServiceConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class UserController {

	@Autowired
	private UserBO userBO;

	@PostMapping(value = "/trylogin")
	public String trylogin(HttpServletResponse response, @Valid User user, BindingResult result) {
		user.setUserId(StringUtils.upperCase(user.getUserId()));
		String url = "/main";
		if (result.hasErrors()) {
			url = "/login";
		}
		// if (userBO.isValidUser(user) == false) {
		// return ServiceConstant.FAIL;
		// }

		CookieUtil.createCookie(response, "userId", user.getUserId(), ServiceConstant.ONE_DAY);

		return "redirect:" + url;
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String doregister() {
		return "user/register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public @ResponseBody String doregister(@Valid User user, BindingResult result) {
		if (result.hasErrors()) {
			return ServiceConstant.FAIL;
		}

		// if (userBO.isDuplicationID(user.getUserId())) {
		// return ServiceConstant.DUPLICATION_ID;
		// }

		String message = null;

		try {
			// userBO.registerUser(user);
			message = ServiceConstant.SUCCESS;
		} catch (Exception e) {
			// log.error(String.valueOf(user), e);
			message = ServiceConstant.FAIL;
		}

		return message;
	}

	@GetMapping(value = "/logout")
	public String logout(HttpServletResponse response, String userId) {
		CookieUtil.removeCookie(response, "userId", userId);
		return "user/login";
	}
}