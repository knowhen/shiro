package com.when.shiro.domain.authentication;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;

/**
 * @author: when
 * @create: 2019-01-23  09:52
 **/
public class CustomHashedCredentialsMatcher extends HashedCredentialsMatcher {

	@Override
	public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
		CustomizedToken customizedToken = (CustomizedToken) token;
		String deviceId = customizedToken.getUsername();
		String password = new String(customizedToken.getPassword());
		String digestPassword = DigestUtils.sha256Hex(password);
		String dbPassword = (String) info.getCredentials();
		return this.equals(digestPassword, dbPassword);
	}
}
