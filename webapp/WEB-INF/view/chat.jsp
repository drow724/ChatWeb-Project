<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chat Web</title>
<link href="css/style.css" type="text/css" rel="stylesheet" />
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Orbitron&display=swap" rel="stylesheet">
</head>
<body>

	<textarea id="messageWindow" rows="10" cols="50" readonly="true"></textarea>
	<br/>
	<input id="inputMessage" type="text" onkeydown="send()"/>
	<button id="submit" type="submit" onclick="sendClick()">전송</button>
	<button id="back" onclick="clickBack()" onkeydown="back()">돌아가기</button>
</body>
<script>
focus();
var textarea = document.getElementById("messageWindow");
var webSocket = new WebSocket('ws://localhost:8080/Chat/chat');
var inputMessage = document.getElementById('inputMessage');

webSocket.onerror = function(event) {
  onError(event)
};

webSocket.onopen = function(event) {
  onOpen(event)
};

webSocket.onmessage = function(event) {
  onMessage(event)
};

function onMessage(event) {
    textarea.value += "상대 : " + event.data + "\n";
    if(textarea.selectionStart == textarea.selectionEnd) {
        textarea.scrollTop = textarea.scrollHeight;
     }
}

function onOpen(event) {
    textarea.value += "연결 성공\n";
}

function onError(event) {
  alert(event.data);
}

function send() {
	if (window.event.keyCode == 13) {
	    textarea.value += "나 : " + inputMessage.value + "\n";
	    webSocket.send(inputMessage.value);
	    inputMessage.value = "";
	    if(textarea.selectionStart == textarea.selectionEnd) {
	        textarea.scrollTop = textarea.scrollHeight;
     	}
	}
}

function sendClick() {
	textarea.value += "나 : " + inputMessage.value + "\n";
    webSocket.send(inputMessage.value);
    inputMessage.value = "";
    focus();
}

function focus(){

	document.getElementById('inputMessage').focus();

}

function focusBack(){

	document.getElementById('back').focus();

}

function back() {
	if (window.event.keyCode == 13) {
	location.href="main";
	}
}

function clickBack() {

	location.href="main";

}
</script>
</html>
</html>