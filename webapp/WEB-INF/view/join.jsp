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
<form class="login-form" method="post">
<span id="texts">&nbsp;</span><br>
<input id="id" onkeyup="enterkey();" type="text" name="id"/><br>
<span id="texts1">&nbsp;</span><br>
<input id="pw" onkeyup="enterkey1();" type="text" name="pw"/><br>
<span id="texts2">&nbsp;</span><br>
<input id="pwchk" onkeyup="enterkey2();" type="text" name="pw"/><br>
<span id="texts3">&nbsp;</span><br>
<input id="name" onkeyup="enterkey3();" type="text" name="pw"/><br>
<span id="texts4">&nbsp;</span><br>
<input id="sex" onkeyup="enterkey4();" type="text" name="pw"/><br>
<span id="texts5">&nbsp;</span><br>
<input id="birth" onkeyup="enterkey5();" type="text" name="pw"/><br>
<span id="texts6">&nbsp;</span><br>
<input id="phone" onkeyup="enterkey6();" type="text" name="pw"/><br>
<span id="texts7">&nbsp;</span><br>
<input id="email" onkeyup="enterkey7();" type="text" name="pw"/>
</form>

<script>
gogogo();
setTimeout(function() {focus()}, 1200);
</script>
</body>
</html>