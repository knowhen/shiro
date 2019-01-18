package com.when.shiro.controller;

import com.when.shiro.dto.Greeting;
import com.when.shiro.form.HelloMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;

/**
 * @author: when
 * @create: 2019-01-15  16:32
 **/
@Controller
public class WebSocketController {
	@Autowired
	public SimpMessagingTemplate template;

	/**
	 * MessageMapping：接收客户端发送至地址"/hello"的消息；
	 * SendTo：向订阅了"/topic/hello"的用户广播消息，
	 * 等同于SimpMessagingTemplate.convertAndSend("/topic/hello", new Response("message"));
	 *
	 * Client: stomp.subscribe("/topic/hello", handleFunction);
	 */
	@MessageMapping("/hello")
	@SendTo("/topic/hello")
	public Greeting greeting(HelloMessage message) throws Exception {
		return new Greeting("Hello " + message.getName());
	}

	/**
	 *	SendToUser：发送给特定客户端；
	 * 等同于SimpMessagingTemplate.convertAndSendToUser(Key,"/message", "新消息");
	 *
	 * Client: stomp.subscribe("/user/message", handleFunction);
	 * username=Key时才能收到消息
	 */
	@MessageMapping("/message")
	@SendToUser("/queue/message")
	public Greeting userMessage(HelloMessage message) throws Exception {
		return new Greeting("Hello " + message.getName());
	}
}
