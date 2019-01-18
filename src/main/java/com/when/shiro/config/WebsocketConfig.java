package com.when.shiro.config;

import com.when.shiro.entity.DeviceEntity;
import com.when.shiro.entity.UserInfo;
import org.apache.shiro.SecurityUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.server.HandshakeHandler;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

import java.security.Principal;
import java.util.Map;

/**
 * @author: when
 * @create: 2019-01-16  20:54
 **/
@Configuration
@EnableWebSocketMessageBroker
public class WebsocketConfig implements WebSocketMessageBrokerConfigurer {
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry
                .addEndpoint("/websocket")
                .setHandshakeHandler(getHandler())
                .addInterceptors(new SessionAuthHandshakeInterceptor())
                .setAllowedOrigins("*")
                .withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        //config.enableSimpleBroker("/topic", "/user", "/group", "/single");
        //config.setApplicationDestinationPrefixes("/app");
        config.enableSimpleBroker("/topic", "/queue");
        // 点对点使用的订阅前缀（客户端订阅路径上会体现出来），默认也是/user/
        config.setUserDestinationPrefix("/user");
    }

    public HandshakeHandler getHandler() {
        return new DefaultHandshakeHandler() {
            @Override
            protected Principal determineUser(ServerHttpRequest request, WebSocketHandler wsHandler, Map<String,
                    Object> attributes) {
                //UserInfo user = (UserInfo) SecurityUtils.getSubject().getPrincipal();
                DeviceEntity user = (DeviceEntity) SecurityUtils.getSubject().getPrincipal();
                return new MyPrincipal(user.getDeviceId().toString());
            }
        };
    }

    class MyPrincipal implements Principal {

        private String key;

        public MyPrincipal(String key) {
            this.key = key;
        }

        @Override
        public String getName() {
            return key;
        }

    }
}
