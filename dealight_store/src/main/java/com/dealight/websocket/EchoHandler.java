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
		
		// ���� �� �� ���
		// session.put(session.getId(), session)
		// List �� �� ���
		sessionList.add(session);
		//���ǰ��� �ҷ���
		//0��° �߰�ȣ�� session.getId()�� ������� ��
		log.info("{"+session.getId()+"} �����");
		
		// session ���� ������ �����ͺ��̽� ���� �۾��� �ϸ� ä�� ���� ����� ���� ����Ʈ�� ������ �� �ִ�.
		System.out.println("ä�� ������ :" + session.getPrincipal().getName() );
		
	}
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		
		//0��°�� session.getId() 1��°�� message.getPayload() ����
		log.info("{"+session.getId()+"}�� ���� {"+message.getPayload()+"} ����");
		
		// ����� ��� Ŭ���̾�Ʈ���� �޽��� ���� : ����Ʈ ���
		// getPrincipal()�� �̿��ؼ� ���ǿ� �����ִ� ������ ������ �ҷ��´�. ������ ������ User�� �̿��� �Ͱ� �����ϴ�.
		for(WebSocketSession sess : sessionList) {
			sess.sendMessage(new TextMessage(session.getPrincipal().getName() +"|" + message.getPayload()));
		}
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		//List ����
		sessionList.remove(session);
		
		log.info("{"+session.getId()+"} ���� ����");
		
		System.out.println("ä�ù� ������ : " + session.getPrincipal().getName());
	}
}
