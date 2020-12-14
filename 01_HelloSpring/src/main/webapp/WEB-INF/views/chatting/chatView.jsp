<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>채팅창</title>
<script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<body>
	<input type="text" id="msg"/> <button id="sendBtn">전송</button>
	<div id="msg-container"></div>
	
	<script>
		//소켓 서버와 연결
		const websocket = new WebSocket("ws://localhost:9090${pageContext.request.contextPath}/chatting"); //websocket-context에 path적은거
		
		//접속후 실행되는 onopen함수구현하기
		websocket.onopen=function(data) {
			console.log(data);
			//클라이언트에게 나의 접속정보를 자동으로 보내게 함
			//서버에서 세션을 관리하게 하기위함
			websocket.send(JSON.stringify(new SocketMessage("new","${loginMember.userId}","","")));
			
		}
		websocket.onmessage=function(data) {
			console.log(data);
			const msg = JSON.parse(data.data);
			switch(msg.type){
				case "msg" : addMessage(msg); break;
			}
			/* $("#msg-container").append("<p>"+data.data+"</p>") */
		}
		
		function addMessage(msg) {
			$("#msg-container").append("<p>"+msg.sender+" : "+msg.msg+"</p>")
		}
		
		function SocketMessage(type, sender, receiver, msg){
			this.type=type;
			this.sender=sender;
			this.receiver=receiver;
			this.msg=msg;
		}
		
		$(function(){
			$("#sendBtn").click(function(){
				const msg = $("#msg").val();
				if(msg.trim().lenth==0) {
					alert("전송할 내용이 없습니다.");
					return;
				}else {
					websocket.send(JSON.stringify(new SocketMessage("msg","${loginMember.userId}","all",msg)))
				}
			})
		});
	</script>
</body>
</html>