package com.when.shiro.domain.authentication;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.realm.Realm;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author: when
 * @create: 2019-01-22  11:16
 **/
public class CustomizedModularRealmAuthenticator extends ModularRealmAuthenticator {
	@Override
	protected AuthenticationInfo doAuthenticate(AuthenticationToken authenticationToken) throws AuthenticationException {
		assertRealmsConfigured();
		CustomizedToken token = (CustomizedToken) authenticationToken;
		String loginType = token.getLoginType();
		Collection<Realm> realms = getRealms();
		Collection<Realm> typeRealms = new ArrayList<>();
		for (Realm realm : realms) {
			if (realm.getName().contains(loginType)) {
				typeRealms.add(realm);
			}
		}

		if (typeRealms.size() == 1) {
			return doSingleRealmAuthentication(typeRealms.iterator().next(), token);
		} else {
			return doMultiRealmAuthentication(typeRealms, token);
		}
	}
}
