package com.when.shiro.service.impl;

import com.when.shiro.domain.authentication.CustomizedToken;
import com.when.shiro.domain.authentication.LoginType;
import com.when.shiro.entity.UserInfo;
import com.when.shiro.exception.GlobalException;
import com.when.shiro.form.LoginForm;
import com.when.shiro.service.UserInfoService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: when
 * @create: 2019-01-16  14:54
 **/
@Service
public class UserInfoServiceImpl implements UserInfoService {
	private static final Logger logger = LoggerFactory.getLogger(UserInfoServiceImpl.class);
	private static List<UserInfo> users;

	static {
		users = new ArrayList<>();
		UserInfo one = new UserInfo();
		one.setUsername("123");
		one.setPassword("123");
		UserInfo two = new UserInfo();
		two.setUsername("456");
		two.setPassword("456");
		users.add(one);
		users.add(two);
	}

	@Override
	public String login(LoginForm form) {
		String userName = form.getUsername();
		String password = form.getPassword();
		try {
			Subject subject = SecurityUtils.getSubject();
			UsernamePasswordToken token = new CustomizedToken(userName, password, LoginType.USER.getType());
			subject.login(token);
			UserInfo user = (UserInfo) subject.getPrincipal();
			return user.getUsername();
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new GlobalException(e.getMessage());
		}
	}

	@Override
	public UserInfo findByUsername(String username) {
		for (UserInfo user : users) {
			if (user.getUsername().equals(username)) {
				return user;
			}
		}
		System.out.println("Unknown account.");
		throw new UnknownAccountException();
	}


}
