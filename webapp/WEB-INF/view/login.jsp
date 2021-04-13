<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chat Web</title>
<link href="css/style.css" type="text/css" rel="stylesheet" />
<script src="js/login.js"></script>
</head>
<body>
<form class="login-form" method="post" action="login" name="loginInfo" onsubmit="return false">
<span id="texts">&nbsp;</span><br>
<input id="id" onkeydown="enterkey();" type="text" name="userID" autocomplete="off" /><br>
<span id="texts1">&nbsp;</span><br>
<input id="pw" onkeydown="enterkey1();" type="password" name="userPassword"/><br>
<button id="texts2" onclick="pressSubmit();" onkeyup="pressSubmit();" type="submit">&nbsp;</button>
</form>

<script>
gogogo();
setTimeout(function() {focus()}, 500);
</script>
</body>
</html>