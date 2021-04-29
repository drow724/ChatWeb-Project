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
</div>
<input id="adminPw" type="password" name="password" autocomplete="off" maxlength="6" onkeypress="adminLogin()"/>
<br>
<script>
gogogo();
setTimeout(function() {focus()}, 500);
document.getElementById("indexBody").style.backgroundColor = "#000000"
</script>
</body>
</html>