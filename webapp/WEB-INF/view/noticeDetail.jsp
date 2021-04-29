<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.List"%>
<%@page import="entity.Board"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/style.css" type="text/css" rel="stylesheet" />
</head>
<body id="titleBody">
<button id="detailBack" onkeypress="enterkeydown4()" onclick="clickBack()">&nbsp;</button>
<span id="detailBoardTitle">
	&nbsp;
</span>
<br>
<span id="DetailUserID">
		&nbsp;
</span>
<br>
<div id="detailBoardContent">
<span id="detailBoardContent">
</span>
</div>
<br>
<span id="DetailComment">
		&nbsp;
</span>
<script>
var speed = 50; //글자가 찍히는 속도
var cnt = 0;
var timer = null;
var speed1 = 50; //글자가 찍히는 속도
var cnt1 = 0;
var timer1 = null;
var speed2 = 50; //글자가 찍히는 속도
var cnt2 = 0;
var timer2 = null;
var speed3 = 50; //글자가 찍히는 속도
var cnt3 = 0;
var timer3 = null;
var speed4 = 50; //글자가 찍히는 속도
var cnt4 = 0;
var timer4 = null;
var speed5 = 50; //글자가 찍히는 속도
var cnt5 = 0;
var timer5 = null;
function clickBack() {
	location.href="notice";
}
function gogogo(){
	var text = "${notice.noticeTitle}";	
	    document.getElementById('detailBoardTitle').innerHTML = text.substring(0, cnt) + "_";
	    cnt++;
	    timer = setTimeout('gogogo()', speed);
	}

	function gogogo1() {
	 text = "작성일 : ${notice.noticeDate}";	
	 document.getElementById('DetailUserID').innerHTML = text.substring(0, cnt1) + "_";
	    cnt1++;
	    timer1 = setTimeout('gogogo1()', speed1);
	}

	function gogogo2() {
	 text = "${notice.noticeContent}";	
	 document.getElementById('detailBoardContent').innerHTML = text.substring(0, cnt2) + "_";
	    cnt2++;
	    timer2 = setTimeout('gogogo2()', speed2);
	}
	function gogogo3() {
		 text = "되돌아가기";	
		 document.getElementById('detailBack').innerHTML = text.substring(0, cnt3) + "_";
		    cnt3++;
		    timer3 = setTimeout('gogogo3()', speed3);
		}
gogogo();
gogogo1();
gogogo2();
gogogo3();
document.getElementById("titleBody").style.backgroundColor = "#000000";
</script>
</body>
</html>