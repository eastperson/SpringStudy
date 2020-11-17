package com.dealight.websocket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class EchoHandler2 extends TextWebSocketHandler{
    
    //������ ��� �����Ѵ�.
    //��� 1 :  1:1 ä��
	//private Map<String, WebSocketSession> sessions = new HashMap<String, WebSocketSession>();
    
    //��� 2 : ��ü ä��
    private List<WebSocketSession> sessionList = new ArrayList<WebSocketSession>();
    
    private static Logger logger = LoggerFactory.getLogger(EchoHandler.class);
    
    /**
     * Ŭ���̾�Ʈ ���� ���Ŀ� ����Ǵ� �޼ҵ�
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        //���� ���� ���
    	//sessions.put(session.getId(), session);
        //List���� ���
        sessionList.add(session);
        //���ǰ��� �ҷ���
        //0��° �߰�ȣ�� session.getId()�� ������¶�
        logger.info("{} �����", session.getId()); 
        
        //Session���� ������ �����ͺ��̽����� �۾��� �ϸ� ä�� ���� ����� ���� ����Ʈ�� ������ �� �ִ�.//
        System.out.println("ä�ù� ������: " + session.getPrincipal().getName());
    }
    
    /**
     * Ŭ���̾�Ʈ�� ������ ������ �޽����� �������� �� ����Ǵ� �޼ҵ�
     */
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        //0��°�� session.getId() 1��°�� message.getPayload() ����
        logger.info("{}�� ���� {} ����", session.getId(), message.getPayload());
        //logger.info("{}�κ��� {}����", new String[]{session.getId(),message.getPayload()});
        
        //����� ��� Ŭ���̾�Ʈ���� �޽��� ���� : ����Ʈ ���
        //getPrincipal()�� �̿��ؼ� ���ǿ� �����ִ� ������ ������ �ҷ��´�.������ ������ User�� �̿��ѰͰ� �����ϴ�.//
        for(WebSocketSession sess : sessionList){
        	sess.sendMessage(new TextMessage(session.getPrincipal().getName()+ "|" + message.getPayload()));
        }
        
        // �� ���.
        /*Iterator<String> sessionIds = sessions.ketSet().iterator();
        String sessionId = "";
        while (sessionIds.hasNext()) {
            sessionId = sessionIds.next();
            sessions.get(sessionId).sendMessage(new TextMessage("echo:" + message.getPayload()));
            
        }*/
        
        //����Ǿ� �ִ� ��� Ŭ���̾�Ʈ�鿡�� �޽����� �����Ѵ�.
        //session.sendMessage(new TextMessage("echo:" + message.getPayload()));
    }
    
    /**
     * Ŭ���̾�Ʈ ������ ������ �� ����Ǵ� �޼ҵ�
     */
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        //List ����
        sessionList.remove(session);
        
        //Map ����
        //sessions.remove(session.getId());
        
        logger.info("{} ���� ����.", session.getId());
        
        System.out.println("ä�ù� ������: " + session.getPrincipal().getName());
    }
 
}