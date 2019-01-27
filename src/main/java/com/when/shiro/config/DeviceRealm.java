package com.when.shiro.config;

import com.when.shiro.entity.DeviceEntity;
import com.when.shiro.service.DeviceService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.DefaultPasswordService;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: when
 * @create: 2019-01-17  10:14
 **/
public class DeviceRealm extends AuthorizingRealm {
	@Autowired
	private DeviceService service;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		DeviceEntity device = (DeviceEntity) principals.getPrimaryPrincipal();
//		for (SysRole role : userInfo.getRoleList()) {
//			authorizationInfo.addRole(role.getRole());
//			for (SysPermission p : role.getPermissions()) {
//				authorizationInfo.addStringPermission(p.getPermission());
//			}
//		}
		return authorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		System.out.println("DeviceRealm.doGetAuthenticationInfo()");
		//获取用户的输入的账号.
		String userName = (String) token.getPrincipal();
		Long deviceId = Long.parseLong(userName);
		// System.out.println(token.getCredentials());
		//通过username从数据库中查找 User对象，如果找到，没找到.
		//实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
		DeviceEntity device = service.queryByDeviceId(deviceId);
		System.out.println("Device info: " + device);
		if (device == null) {
			throw new UnknownAccountException("账号或密码不正确");
		}
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
				device, //用户名
				device.getPassword(),
				getName()  //realm name
		);
		return authenticationInfo;
	}
}