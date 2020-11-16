//package com.dealight.websocket;
//
//import java.util.Collection;
//import java.util.Collections;
//import java.util.Map;
//import java.util.function.Function;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//import org.springframework.stereotype.Repository;
//
//@Repository
//public class ChatRoomRepository {
//    private final Map<String, ChatRoom> chatRoomMap;
//
//    public ChatRoomRepository() {
//        chatRoomMap = Collections.unmodifiableMap(
//                Stream.of(ChatRoom.create("1����"), ChatRoom.create("2����"), ChatRoom.create("3����"))
//                      .collect(Collectors.toMap(ChatRoom::getId, Function.identity())));
//
//        chatRooms = Collections.unmodifiableCollection(chatRoomMap.values());
//    }
//
//    public ChatRoom getChatRoom(String id) {
//        return chatRoomMap.get(id);
//    }
//    
//    public Collection<ChatRoom> getChatRooms() {
//        return chatRoomMap.values();
//    }
//}