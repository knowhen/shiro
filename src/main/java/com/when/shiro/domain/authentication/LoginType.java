package com.when.shiro.domain.authentication;

/**
 * @author: when
 * @create: 2019-01-22  11:14
 **/
public enum LoginType {
	USER("User"), DEVICE("Device");

	private String type;

	LoginType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	@Override
	public String toString() {
		return "LoginType{" +
				"type='" + type + '\'' +
				'}';
	}
}
