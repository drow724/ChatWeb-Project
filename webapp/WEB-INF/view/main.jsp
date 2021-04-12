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
<script src="js/main.js"></script>
</head>
<body>
<div>
<span id="art" class="art">
&nbsp;
</span>
<span class="main">
    <button id="texts1" onclick="clickNotice();" onkeyup="enterkeydown1();">&nbsp;</button>
</span>
<span class="main">   
    <button id="texts2" onclick="clickBoard();" onkeyup="enterkeydown2();">&nbsp;</button>
</span>
<span class="main">   
    <button id="texts3" onclick="clickChat();" onkeyup="enterkeydown3();">&nbsp;</button>
</span>
</div>
<script>
gogogo();
setTimeout(function() {gogogo1()}, 1000);
setTimeout(function() {gogogo2()}, 1400);
setTimeout(function() {gogogo3()}, 1800);
setTimeout(function() {focus()}, 2000);
</script>
</body>
</html>