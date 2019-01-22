package com.when.shiro.domain.authentication;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * @author: when
 * @create: 2019-01-22  11:15
 **/
public class CustomizedToken extends UsernamePasswordToken {
	private String loginType;

	public CustomizedToken(String username, String password, String loginType) {
		super(username, password);
		this.loginType = loginType;
	}

	public String getLoginType() {
		return loginType;
	}

	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}
}
