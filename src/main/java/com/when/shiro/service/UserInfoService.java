package com.when.shiro.service;

import com.when.shiro.entity.UserInfo;
import com.when.shiro.form.LoginForm;

/**
 * @author: when
 * @create: 2019-01-16  14:52
 **/
public interface UserInfoService {

	UserInfo findByUsername(String username);

	String login(LoginForm form);
}
