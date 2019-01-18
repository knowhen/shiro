package com.when.shiro.entity;

/**
 * @author: when
 * @create: 2019-01-17  10:15
 **/
public class DeviceEntity {
	private Long deviceId;
	private String deviceName;
	private Long shopId;
	private Long areaId;
	private Integer deviceType;
	private String password;

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

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public Long getAreaId() {
		return areaId;
	}

	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}

	public Integer getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(Integer deviceType) {
		this.deviceType = deviceType;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCredentialsSalt() {
		return String.valueOf(this.shopId + this.areaId + this.deviceId);
	}

	@Override
	public String toString() {
		return "DeviceEntity{" +
				"deviceId=" + deviceId +
				", deviceName='" + deviceName + '\'' +
				", shopId=" + shopId +
				", areaId=" + areaId +
				", deviceType=" + deviceType +
				", password='" + password + '\'' +
				'}';
	}
}
