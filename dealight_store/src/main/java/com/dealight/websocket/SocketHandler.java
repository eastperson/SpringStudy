package com.dealight.websocket;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import lombok.extern.log4j.Log4j;


@Log4j
public class SocketHandler extends TextWebSocketHandler implements InitializingBean {

	private Set<WebSocketSession> sessionSet = new HashSet<WebSocketSession>();
	
	public SocketHandler() {
		
		log.info("create socket handlet instance!");
	}
	
	
	public void afterPropertiesSet(WebSocketSession session,CloseStatus status) throws Exception {
		
		super.afterConnectionClosed(session, status);
		
		sessionSet.remove(session);
		log.info("remove session!");
		
	}
	
    @Override
    public void afterConnectionEstablished(WebSocketSession session)

                 throws Exception {

          super.afterConnectionEstablished(session);



          sessionSet.add(session);

          log.info("add session!");

    }
    
    @Override
    public void handleMessage(WebSocketSession session,

                 WebSocketMessage<?> message) throws Exception {

          super.handleMessage(session, message);

         

          log.info("receive message:"+message.toString());

    }
	
    @Override
    public void handleTransportError(WebSocketSession session,
                 Throwable exception) throws Exception {
          log.error("web socket error!", exception);
    }

    @Override

    public boolean supportsPartialMessages() {

          log.info("call method!");
          return super.supportsPartialMessages();
    }

   

    public void sendMessage (String message){
          for (WebSocketSession session: this.sessionSet){
                 if (session.isOpen()){
                        try{
                              session.sendMessage(new TextMessage(message));
                        }catch (Exception ignored){
                              log.error("fail to send message!", ignored);
                        }
                 }
          }
    }



    @Override
    public void afterPropertiesSet() throws Exception {
          Thread thread = new Thread(){
                 int i=0;
                 @Override
                 public void run() {
                        while (true){
                              try {
                                     sendMessage ("send message index "+i++);
                                     Thread.sleep(1000);
                              } catch (InterruptedException e) {
                                     e.printStackTrace();
                                     break;
                              }
                        }
                 }
          };
          thread.start();
    }
}
