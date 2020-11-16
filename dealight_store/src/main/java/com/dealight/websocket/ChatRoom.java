//package com.dealight.websocket;
//
//import java.awt.TrayIcon.MessageType;
//import java.util.HashSet;
//import java.util.Set;
//
//import org.springframework.web.socket.TextMessage;
//import org.springframework.web.socket.WebSocketSession;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import lombok.Getter;
//
//@Getter
//public class ChatRoom {
//    private String id;
//    private String name;
//    private Set<WebSocketSession> sessions = new HashSet<>();
//
//    public void handleMessage(WebSocketSession session, ChatMessage chatMessage, ObjectMapper objectMapper) {
//
//        if (chatMessage.getType() == MessageType.INFO) {
//            join(session);
//            chatMessage.setMessage(chatMessage.getWriter() + "���� �����߽��ϴ�.");
//        }
//        
//        send(chatMessage, objectMapper);
//    }
//
//    private void join(WebSocketSession session) {
//        sessions.add(session);
//    }
//
//    private <T> void send(T messageObject, ObjectMapper objectMapper) {
//
//        TextMessage message = new TextMessage(objectMapper.writeValueAsString(messageObject));
//        sessions.parallelStream().forEach(session -> session.sendMessage(message));
//    }
//}}
//}