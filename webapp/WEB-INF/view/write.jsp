<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/style.css" type="text/css" rel="stylesheet" />
<script src="js/write.js"></script>
</head>
<body id="titleBody">
<div id="loading-container" class="loading-container">
    <div class="loading"></div>
    <div id="loading-text">loading</div>
</div>
<span id="title" class="title" style="opacity:0.3;">
	&nbsp;
</span>
	<form id="writeForm"method="post" name="writeInfo" onsubmit="return false" style="opacity:0.3;">
		<span id="boardTitle">
		&nbsp;
		</span>
		<input id="boardTitleInput" onkeyup="enterkeydown1();" type="text" name="boardTitle" autocomplete="off"  onsubmit="return false"><br>
		<span id="boardFiles">
		&nbsp;
		</span>
		<input id="boardFiles" type="file" onkeypress="enterkeydown2()" name="boardFiles" /><br>
		<textarea class="boardContent" onkeypress="enterkeydown3()" name="boardContent" maxlength="2048">
		</textarea><br>
		<button id="boardSubmit" onkeypress="enterkeydown3()" onclick="write()" type="submit"></button>
		<button id="boardBack" onkeypress="enterkeydown4()" onclick="back()"></button>
	</form>
<script>
gogogo();

setTimeout(function() {gogogo1()}, 500);
setTimeout(function() {gogogo2()}, 700);
setTimeout(function() {gogogo3()}, 900);
setTimeout(function() {gogogo4()}, 1100);
setTimeout(function() {document.getElementById("writeForm").removeAttribute("style")}, 1100);
setTimeout(function() {document.getElementById("title").removeAttribute("style")}, 1100);
setTimeout(function() {document.getElementById("titleBody").style.backgroundColor = "#000000"}, 1100);
setTimeout(function() {document.getElementById("loading-container").style.display = "none"}, 1100);
setTimeout(function() {focus()}, 1100);
</script>
</body>
</html>