package com.when.shiro.config;

import com.when.shiro.entity.DeviceEntity;
import com.when.shiro.entity.UserInfo;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author: when
 * @create: 2019-01-15  16:26
 **/
public class SessionAuthHandshakeInterceptor implements HandshakeInterceptor {
    //private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response,
                                   WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
        System.out.println("Before handshake");
        //UserInfo user = (UserInfo) SecurityUtils.getSubject().getPrincipal();
        DeviceEntity user = (DeviceEntity) SecurityUtils.getSubject().getPrincipal();
        if (user == null) {
            System.out.println("未登录");
            return false;
        }
        return true;
    }

    @Override
    public void afterHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse,
                               WebSocketHandler webSocketHandler, Exception e) {

    }

    private HttpSession getSession(ServerHttpRequest request) {
        if (request instanceof ServletServerHttpRequest) {
            ServletServerHttpRequest serverRequest = (ServletServerHttpRequest) request;
            return serverRequest.getServletRequest().getSession();
        }
        return null;
    }
}
