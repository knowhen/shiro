package com.when.shiro.service.impl;

import com.when.shiro.dto.DeviceLoginDto;
import com.when.shiro.entity.DeviceEntity;
import com.when.shiro.form.DeviceLoginForm;
import com.when.shiro.mapper.DeviceMapper;
import com.when.shiro.service.DeviceService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: when
 * @create: 2019-01-17  10:07
 **/
@Service
public class DeviceServiceImpl implements DeviceService {
	@Autowired
	private DeviceMapper mapper;

	@Override
	public DeviceLoginDto login(DeviceLoginForm form) {
		String deviceId = form.getDeviceId();
		String password = form.getPassword();
		try {
			Subject subject = SecurityUtils.getSubject();
			UsernamePasswordToken token = new UsernamePasswordToken(deviceId, password);
			token.setRememberMe(true);
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
		return null;
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
