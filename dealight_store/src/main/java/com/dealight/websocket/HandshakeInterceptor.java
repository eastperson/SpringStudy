package com.dealight.websocket;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

import com.dealight.domain.UserVO;
import com.dealight.service.UserService;

public class HandshakeInterceptor extends HttpSessionHandshakeInterceptor {


		@Autowired 
		private UserService userService; 

		@Override 
		public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception { 
			
			
			UserVO user = userService.read("kjuioq");
			attributes.put("HTTP.SESSION.ID", user);

			return super.beforeHandshake(request, response, wsHandler, attributes);
		} 
}
