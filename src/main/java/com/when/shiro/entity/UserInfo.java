package com.when.shiro.entity;

import java.util.List;

/**
 * @author: when
 * @create: 2019-01-16  14:16
 **/
public class UserInfo {
	private Integer uid;
	private String username;
	private String name;
	private String password;
	private String salt;
	private byte state;
	private List<SysRole> roleList;

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public byte getState() {
		return state;
	}

	public void setState(byte state) {
		this.state = state;
	}

	public List<SysRole> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<SysRole> roleList) {
		this.roleList = roleList;
	}

	/**
	 * 密码盐.
	 * @return
	 */
	public String getCredentialsSalt(){
		return this.username+this.salt;
	}
}
