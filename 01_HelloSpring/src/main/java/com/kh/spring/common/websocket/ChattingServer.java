package com.kh.spring.common.websocket;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

//웹소겟 서버 구성하기
//책입/역할 -> 접속한 사용자의 session관리 및 데이터 전송
//1. TextWebSocketHandler객체를 상속 (서버를 구성하기 위해서는 규약이 있음)  --> 이건 문자 전용
//2. BinaryWebSocketHandler 객체 상속    --> 문자뿐만 아니라 data도  전송 가능

@Slf4j  //log4j 를 autowired안해도 됨
public class ChattingServer extends TextWebSocketHandler{
	
	//세선관리용 객체 생성
	private Map<String, WebSocketSession> clients = new HashMap();
	
	@Autowired
	ObjectMapper mapper; //json객체를 자바객체로 자바객체를 json으로 변환해주는 jackson제공 객체
	
	//map을 사용하는 이유는 session은 새로고침하면 세션값이 바뀜 따라서 map을 이용하고 키값을 이름이나 아이디로 구분함
	//map의 키값은 주로 이름이나/아이디로 사용(따라서 중복되면 안됨)
	
	//메세지처리 메소드를 오버라이딩처리해서 사용
	//shitf+alt+s+v

	@Override  //page에서 new Websocket(주소);가 실행되어 접속요청을 하면 실행되는 메소드
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		log.debug("----- 사용자 접속! -----");  //자동으로 websocketsession 객체에 넣어줌?
		
		//사용자에게 접속 축하메세지 발송
		session.sendMessage(new TextMessage("채팅접속을 환영합니다!"));
	}

	@Override   //send하면 보낸 사용자의 session정보와 message(string형태)로 들어옴
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		//클라이언트들이 보내는 모든데이터가 오면 실행되는 메소드
		
		log.debug(message.getPayload());
		
		SocketMessage msg = getMessage(message.getPayload());
		
		log.debug("메세지 변환 후 : "+msg);
		
		switch(msg.getType()) {
			case "new" : addClient(msg,session); break;
			case "msg" : sendMessage(msg, session); break;
			
		}
	}
	
	//클라이언트 등록하기
	private void addClient(SocketMessage msg,WebSocketSession session) {
		clients.put(msg.getSender(), session);
		log.info("접속저 : "+clients);
		
	}
	
	private String getJsonMessage(SocketMessage msg) {
		String jsonMsg = "";
		try {
			jsonMsg = mapper.writeValueAsString(msg);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return jsonMsg;
	}
	
	//메세지 보내기 메소드
	private void sendMessage(SocketMessage msg,WebSocketSession session) {
		//클라이언트가 보낸 데이터를 보내기
		//대상에 따라 분기해서 보내기
		if(msg.getReceiver().equals("all")) {
			Set<Map.Entry<String,WebSocketSession>> entry = clients.entrySet();
			for(Map.Entry<String, WebSocketSession> clients : entry) {
				try {
					clients.getValue().sendMessage(new TextMessage(getJsonMessage(msg)));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

	@Override  //session이 끊긴 애가 들어옴
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		log.debug("----- 클라이언트 접속 끊김! -----"); 
	}
	
	//메세지변환용 메소드
	private SocketMessage getMessage(String msg) {
		
		SocketMessage message = null;
		try {
			message = mapper.readValue(msg, SocketMessage.class);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return message;
		
	}
	
	

}
