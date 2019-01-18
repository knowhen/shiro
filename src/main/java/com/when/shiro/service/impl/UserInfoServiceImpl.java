package com.when.shiro.service.impl;

import com.when.shiro.entity.UserInfo;
import com.when.shiro.service.UserInfoService;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: when
 * @create: 2019-01-16  14:54
 **/
@Service
public class UserInfoServiceImpl implements UserInfoService {
    private static List<UserInfo> users;

    static {
        users = new ArrayList<>();
        UserInfo one = new UserInfo();
        one.setUsername("123");
        one.setPassword("123");
        UserInfo two = new UserInfo();
        two.setUsername("456");
        two.setPassword("456");
        users.add(one);
        users.add(two);
    }

    @Override
    public UserInfo findByUsername(String username) {
        for (UserInfo user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        System.out.println("Unknown account.");
        throw new UnknownAccountException();
    }


}
