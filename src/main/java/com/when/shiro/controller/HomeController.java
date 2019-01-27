package com.when.shiro.controller;

import com.when.shiro.dto.DeviceLoginDto;
import com.when.shiro.dto.ResponseData;
import com.when.shiro.form.DeviceLoginForm;
import com.when.shiro.form.DeviceRegisterForm;
import com.when.shiro.form.LoginForm;
import com.when.shiro.service.DeviceService;
import com.when.shiro.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: when
 * @create: 2019-01-16  14:57
 **/
@RestController
public class HomeController extends BaseController {

	@Autowired
	private DeviceService deviceService;
	@Autowired
	private UserInfoService userService;

	@PostMapping("/device/login")
	public ResponseData login(@RequestBody DeviceLoginForm form) {
		DeviceLoginDto login = deviceService.login(form);
		return formatResponse(login);
	}

	@PostMapping("/user/login")
	public ResponseData login(@RequestBody LoginForm form) {
		String userName = userService.login(form);
		return formatResponse(userName);
	}

	@PostMapping("/device/register")
	public ResponseData register(@RequestBody DeviceRegisterForm form) {
		DeviceLoginDto deviceInfo = deviceService.register(form);
		return formatResponse(deviceInfo);
	}

}
