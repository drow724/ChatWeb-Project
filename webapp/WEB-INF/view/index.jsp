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
<body id="indexBody">

<div>
<span id="art" class="indexArt">
&nbsp;
</span>
<span class="main">
    <button id="texts1" onclick="clickLogin();" onkeyup="enterkeyup();">&nbsp;</button>
</span>
<span class="main">   
    <button id="texts2" onclick="clickJoin();" onkeyup="enterkeydown();">&nbsp;</button>
</span>
<span class="main">   
    <button id="texts3" onclick="find();" onkeyup="enterkeydown2();">&nbsp;</button>
</span>
</div>
<script>
gogogo();
setTimeout(function() {gogogo1()}, 1000);
setTimeout(function() {gogogo2()}, 1400);
setTimeout(function() {gogogo3()}, 1800);
setTimeout(function() {focus()}, 2000);
document.getElementById("indexBody").style.backgroundColor = "#000000"
</script>
</body>
</html>