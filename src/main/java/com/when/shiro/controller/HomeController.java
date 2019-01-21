package com.when.shiro.controller;

import com.when.shiro.dto.DeviceLoginDto;
import com.when.shiro.dto.ResponseData;
import com.when.shiro.form.DeviceLoginForm;
import com.when.shiro.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: when
 * @create: 2019-01-16  14:57
 **/
@RestController
public class HomeController extends BaseController {

	@Autowired
	private DeviceService service;

	@PostMapping("/shiro/login")
	public ResponseData login(@RequestBody DeviceLoginForm form) {
		DeviceLoginDto login = service.login(form);
		return formatResponse(login);
	}

}
