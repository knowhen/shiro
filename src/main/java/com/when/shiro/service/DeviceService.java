package com.when.shiro.service;

import com.when.shiro.dto.DeviceLoginDto;
import com.when.shiro.entity.DeviceEntity;
import com.when.shiro.form.DeviceLoginForm;
import com.when.shiro.form.DeviceRegisterForm;

import java.util.List;

/**
 * @author: when
 * @create: 2019-01-17  10:06
 **/
public interface DeviceService {
	DeviceLoginDto login(DeviceLoginForm form);

	DeviceEntity queryByDeviceId(Long deviceId);

	List<DeviceEntity> queryDevices();

	DeviceLoginDto register(DeviceRegisterForm form);
}
