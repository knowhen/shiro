package com.when.shiro.service;

import com.when.shiro.entity.UserInfo;

/**
 * @author: when
 * @create: 2019-01-16  14:52
 **/
public interface UserInfoService {

	UserInfo findByUsername(String username);
}
