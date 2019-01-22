package com.when.shiro.controller;

import com.when.shiro.dto.ResponseData;
import com.when.shiro.entity.DeviceEntity;
import com.when.shiro.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: when
 * @create: 2019-01-22  15:02
 **/
@RestController
public class DeviceController extends BaseController {
	@Autowired
	private DeviceService deviceService;

	@GetMapping("/api/device")
	public ResponseData getDevices() {
		List<DeviceEntity> deviceEntities = deviceService.queryDevices();
		return formatResponse(deviceEntities);
	}
}
