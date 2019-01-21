package com.when.shiro.dto;

/**
 * @author: when
 * @create: 2019-01-17  10:10
 **/
public class DeviceLoginDto {

	private Long deviceId;
	private String deviceName;

	public DeviceLoginDto() {
	}

	public DeviceLoginDto(Long deviceId, String deviceName) {
		this.deviceId = deviceId;
		this.deviceName = deviceName;
	}

	public Long getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(Long deviceId) {
		this.deviceId = deviceId;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
}
