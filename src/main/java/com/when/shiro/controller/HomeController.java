package com.when.shiro.controller;

import com.when.shiro.form.DeviceLoginForm;
import com.when.shiro.form.LoginForm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author: when
 * @create: 2019-01-16  14:57
 **/
@Controller
public class HomeController {
	@GetMapping("/login")
	public String getLogin() {
		return "login.html";
	}

	@PostMapping("/login")
	public String login(DeviceLoginForm form) throws Exception {
		System.out.println("HomeController.login()");
		String deviceId = form.getDeviceId();
		String password = form.getPassword();
		try {
			Subject subject = SecurityUtils.getSubject();
			UsernamePasswordToken token = new UsernamePasswordToken(deviceId, password);
			subject.login(token);
		} catch (UnknownAccountException e) {
			System.out.println(e.getMessage());
		} catch (IncorrectCredentialsException e) {
			System.out.println(e.getMessage());
		} catch (LockedAccountException e) {
			System.out.println(e.getMessage());
		} catch (AuthenticationException e) {
			System.out.println(e.getMessage());
		}
		return "index.html";
	}

}
