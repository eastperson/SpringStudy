package com.dealight.websocket;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import jdk.internal.org.jline.utils.Log;
import lombok.extern.log4j.Log4j;

@Log4j
public class EchoHandler extends TextWebSocketHandler {
	
	private List<WebSocketSession> sessionList = new ArrayList<WebSocketSession>();
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		
		// 맵을 쓸 때 방법
		// session.put(session.getId(), session)
		// List 쓸 때 방법
		sessionList.add(session);
		//세션값을 불러온
		//0번째 중괄호에 session.getId()을 넣으라는 뜻
		log.info("{"+session.getId()+"} 연결됨");
		
		// session 값을 가지고 데이터베이스 등의 작업을 하면 채팅 참여 사용자 정보 리스트를 구성할 수 있다.
		System.out.println("채팅 입장자 :" + session.getPrincipal().getName() );
		
	}
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		
		//0번째에 session.getId() 1번째에 message.getPayload() 넣음
		log.info("{"+session.getId()+"}로 부터 {"+message.getPayload()+"} 받음");
		
		// 연결된 모든 클라이언트에게 메시지 전송 : 리스트 방법
		// getPrincipal()를 이용해서 세션에 몰려있는 유저의 정보를 불러온다. 세션의 정보는 User를 이용한 것과 동일하다.
		for(WebSocketSession sess : sessionList) {
			sess.sendMessage(new TextMessage(session.getPrincipal().getName() +"|" + message.getPayload()));
		}
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		//List 삭제
		sessionList.remove(session);
		
		log.info("{"+session.getId()+"} 연결 끊김");
		
		System.out.println("채팅방 퇴장자 : " + session.getPrincipal().getName());
	}
}
