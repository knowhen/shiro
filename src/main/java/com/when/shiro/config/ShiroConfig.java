package com.when.shiro.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.apache.shiro.mgt.SecurityManager;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author: when
 * @create: 2019-01-16  14:29
 **/
@Configuration
public class ShiroConfig {
	@Bean
	public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
		System.out.println("ShiroConfiguration.shirFilter()");
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		shiroFilterFactoryBean.setLoginUrl("/login.html");
		//拦截器.
		Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
		// 配置不会被拦截的链接 顺序判断
		filterChainDefinitionMap.put("/login.html", "anon");
		filterChainDefinitionMap.put("/login", "anon");
		//配置退出 过滤器,其中的具体的退出代码Shiro已经替我们实现了
		filterChainDefinitionMap.put("/logout", "logout");
		//<!-- 过滤链定义，从上向下顺序执行，一般将/**放在最为下边 -->:这是一个坑呢，一不小心代码就不好使了;
		//<!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
		filterChainDefinitionMap.put("/**", "authc");
		// 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
		// 登录成功后要跳转的链接
		shiroFilterFactoryBean.setSuccessUrl("/index.html");

		//未授权界面;
		shiroFilterFactoryBean.setUnauthorizedUrl("/403");
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
		return shiroFilterFactoryBean;
	}

	//	@Bean
//	public CustomShiroRealm getRealm() {
//		return new CustomShiroRealm();
//	}
//
//	@Bean("securityManager")
//	public SecurityManager securityManager() {
//		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
//		CustomShiroRealm realm = getRealm();
//		securityManager.setRealm(realm);
//		return securityManager;
//	}
	@Bean
	public DeviceRealm getRealm() {
		return new DeviceRealm();
	}

	@Bean("securityManager")
	public SecurityManager securityManager() {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		//CustomShiroRealm realm = getRealm();
		DeviceRealm realm = getRealm();
		securityManager.setRealm(realm);
		return securityManager;
	}
}
