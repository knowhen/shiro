package com.when.shiro.service.impl;

import com.when.shiro.domain.authentication.CustomizedToken;
import com.when.shiro.domain.authentication.LoginType;
import com.when.shiro.dto.DeviceLoginDto;
import com.when.shiro.entity.DeviceEntity;
import com.when.shiro.exception.GlobalException;
import com.when.shiro.form.DeviceLoginForm;
import com.when.shiro.mapper.DeviceMapper;
import com.when.shiro.service.DeviceService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: when
 * @create: 2019-01-17  10:07
 **/
@Service
public class DeviceServiceImpl implements DeviceService {
	private static final Logger logger = LoggerFactory.getLogger(DeviceServiceImpl.class);
	@Autowired
	private DeviceMapper mapper;

	@Override
	public DeviceLoginDto login(DeviceLoginForm form) {
		String deviceId = form.getDeviceId();
		String password = form.getPassword();
		try {
			Subject subject = SecurityUtils.getSubject();
			UsernamePasswordToken token = new CustomizedToken(deviceId, password, LoginType.DEVICE.getType());
			subject.login(token);
			DeviceEntity device = (DeviceEntity) subject.getPrincipal();
			return new DeviceLoginDto(device.getDeviceId(), device.getDeviceName());
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new GlobalException(e.getMessage());
		}
	}

	@Override
	public DeviceEntity queryByDeviceId(Long deviceId) {
		return mapper.queryByDeviceId(deviceId);
	}

	@Override
	public List<DeviceEntity> queryDevices() {
		return mapper.queryDevices();
	}
}
