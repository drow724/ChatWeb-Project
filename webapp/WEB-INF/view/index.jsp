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
<script src="js/index.js"></script>
</head>
<body>
<div>
<span id="art" class="art">
&nbsp;
</span>
<span class="main">
    <button id="texts1" onclick="clickLogin();" onkeyup="enterkeyup();">&nbsp;</button>
</span>
<span class="main">   
    <button id="texts2" onclick="clickJoin();" onkeyup="enterkeydown();">&nbsp;</button>
</span>
</div>
<script>
document.documentElement.webkitRequestFullscreen();
//mozRequestFullScreen : 파이어폭스
//msRequestFullscreen : 인터넷익스플로러
gogogo();
setTimeout(function() {gogogo1()}, 1000);
setTimeout(function() {gogogo2()}, 1400);
setTimeout(function() {focus()}, 2000);
</script>
</body>
</html>