<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chat Web</title>
<link href="css/style.css" type="text/css" rel="stylesheet" />
<script src="js/find.js"></script>
</head>
<body id="loginBody">
<form class="find-form" method="post" action="find" name="findInfo" onsubmit="return false">
<span id="texts">&nbsp;</span><br>
<input id="email" onkeydown="enterkey();" type="email" name="userEmail" autocomplete="off" /><br>
<span id="texts1">&nbsp;</span><br>
<input id="name" onkeydown="enterkey1(); " type="text" name="userName" disabled="disabled"/><br>
<button id="texts2" onclick="pressSubmit();" onkeyup="pressSubmit();" type="submit" disabled="disabled">&nbsp;</button>
</form>

<script>
gogogo();
setTimeout(function() {focus()}, 500);
document.getElementById("loginBody").style.backgroundColor = "#000000";
</script>
</body>
</html>