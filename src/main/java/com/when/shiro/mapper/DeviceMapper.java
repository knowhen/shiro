package com.when.shiro.mapper;

import com.when.shiro.entity.DeviceEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author: when
 * @create: 2019-01-17  10:06
 **/
@Mapper
public interface DeviceMapper {

	DeviceEntity queryByDeviceId(Long deviceId);

	List<DeviceEntity> queryDevices();

	void insert(DeviceEntity entity);
}
