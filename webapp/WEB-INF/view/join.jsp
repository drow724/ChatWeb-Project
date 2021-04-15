<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chat Web</title>
<link href="css/style.css" type="text/css" rel="stylesheet" />
<script src="js/join.js"></script>
</head>
<body>
<form class="login-form" method="post" onsubmit="return false" name="joinInfo">
<span id="texts">&nbsp;</span><br>
<input id="id" onkeyup="enterkey();" oninput="handleOnInputId(this)" type="text" name="userID" autocomplete="off"/><br>
<span id="texts1">&nbsp;</span><br>
<input id="pw" onkeyup="enterkey1();" oninput="handleOnInputPassword(this)" type="password" name="userPassword" disabled="disabled"/><br>
<span id="texts2">&nbsp;</span><br>
<input id="pwchk" onkeyup="enterkey2();" type="password" name="userPasswordCheck" disabled="disabled"/><br>
<span id="texts3">&nbsp;</span><br>
<input id="name" onkeyup="enterkey3(); javascript:return onlyKorean('name');" type="text" name="userName" disabled="disabled" autocomplete="off"/><br>
<span id="texts4">&nbsp;</span><br>
<input id="gender" onkeyup="enterkey4();" type="number" min="1" max="2" name="userGender" disabled="disabled" autocomplete="off"/><br>
<span id="texts5">&nbsp;</span><br>
<input id="email" onkeyup="enterkey5();" type="email" name="userEmail" disabled="disabled" autocomplete="off"/><br>
<span id="texts6">&nbsp;</span><br>
<button id="button1" onclick="pressYes();" onkeyup="pressYes();" type="submit" disabled="disabled">&nbsp;</button><br>
<button id="button2" onclick="pressNo();" onkeyup="pressNo();" disabled="disabled">&nbsp;</button><br>
</form>

<script>
gogogo();
setTimeout(function() {focus()}, 500);

</script>
</body>
</html>