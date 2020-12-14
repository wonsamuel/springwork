package com.kh.spring.common.websocket;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebSocketController {

	@RequestMapping("/chatView.do")
	public String chatView() {
		
		return "chatting/chatView";
	}
	
}
