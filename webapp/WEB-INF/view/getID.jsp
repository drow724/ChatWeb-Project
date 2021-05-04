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
<script src="js/getID.js"></script>
</head>
<body id="indexBody">

<div>
<span id="art1" class="indexArt">
&nbsp;
</span>
<span id="art2" class="indexArt">
&nbsp;
</span>
<span class="main">   
    <button id="texts3" onclick="back();" onkeyup="enterkeydown();">&nbsp;</button>
</span>
</div>
<script>
var speed = 60; //글자가 찍히는 속도
var cnt = 0;
var timer = null;
var speed1 = 30; //글자가 찍히는 속도
var cnt1 = 0;
var timer1 = null;
function gogogo(){
	text = "아이디는 : ${user.userID}";	
	    document.getElementById('art1').innerHTML = text.substring(0, cnt) + "_";
	    cnt++;
	    timer = setTimeout('gogogo()', speed);
	}

	function gogogo1(){
	text = "비밀번호는 :  ${user.userPassword}";	
	    document.getElementById('art2').innerHTML = text.substring(0, cnt1) + "_";
	    cnt1++;
	    timer1 = setTimeout('gogogo1()', speed1);
	}
gogogo();
setTimeout(function() {gogogo1()}, 1000);
setTimeout(function() {gogogo3()}, 1800);
setTimeout(function() {focus()}, 2000);
document.getElementById("indexBody").style.backgroundColor = "#000000"
</script>
</body>
</html>