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
<span id="DetailBoardFiles">
 
</span>
 <td colspan="3">
        <c:forTokens var="fileName" items="${board.boardFiles}" delims="," varStatus="st">
		<c:set var="style" value=""></c:set>
		<c:if test="${fn:endsWith(fileName, '.zip') }">
			<c:set var="style" value="font-weight: bold; color:red;"></c:set>
		</c:if>
		<a download href="upload/${fileName}" style="${style}">${fn:toUpperCase(fileName)}</a>
		<c:if test="${! st.last}">
		/
		</c:if>
		</c:forTokens>
                        </td>
<br>
<div id="detailBoardContent">
<span id="detailBoardContent">
</span>
</div>
<br>
<span id="DetailComment">
		&nbsp;
</span>
	<table class="commentTable">
							<tbody>
									<c:forEach var="b" items="${list}" begin="0" end="4">
								<tr>
									<td class="titleindenttext-align-left">${b.userID}</td>
                            </tr>
									<td id="text5" class="titleindenttext-align-left">${b.commentContent}</td>
									<td class="titleindenttext-align-left">${b.commentDate}</td>
								</c:forEach>
							</tbody>
						</table>
<form method="post">
<textarea name="id" style="display:none">${board.boardID}</textarea>
<textarea id="detailContent" name="detailContent" rows="1" cols="3" maxlength="2048"></textarea><br>
<button id="comment" onkeypress="enterkeydown4()" onclick="submit();">&nbsp;</button>
</form>

<script>
var speed = 50; //????????? ????????? ??????
var cnt = 0;
var timer = null;
var speed1 = 50; //????????? ????????? ??????
var cnt1 = 0;
var timer1 = null;
var speed2 = 50; //????????? ????????? ??????
var cnt2 = 0;
var timer2 = null;
var speed3 = 50; //????????? ????????? ??????
var cnt3 = 0;
var timer3 = null;
var speed4 = 50; //????????? ????????? ??????
var cnt4 = 0;
var timer4 = null;
var speed5 = 50; //????????? ????????? ??????
var cnt5 = 0;
var timer5 = null;
var speed6 = 50; //????????? ????????? ??????
var cnt6 = 0;
var timer6 = null;
function clickBack() {
	location.href="board";
}
function gogogo(){
	var text = "${board.boardTitle}";	
	    document.getElementById('detailBoardTitle').innerHTML = text.substring(0, cnt) + "_";
	    cnt++;
	    timer = setTimeout('gogogo()', speed);

	}

	function gogogo1() {
	 text = "????????? : ${board.userID}";	
	 document.getElementById('DetailUserID').innerHTML = text.substring(0, cnt1) + "_";
	    cnt1++;
	    timer1 = setTimeout('gogogo1()', speed1);
	}

	function gogogo2() {
	 text = "${board.boardContent}";	
	 document.getElementById('detailBoardContent').innerHTML = text.substring(0, cnt2) + "_";
	    cnt2++;
	    timer2 = setTimeout('gogogo2()', speed2);
	}
	function gogogo3() {
		 text = "???????????????";	
		 document.getElementById('detailBack').innerHTML = text.substring(0, cnt3) + "_";
		    cnt3++;
		    timer3 = setTimeout('gogogo3()', speed3);
		}
	function gogogo4() {
		 text = "??????";	
		 document.getElementById('comment').innerHTML = text.substring(0, cnt4) + "_";
		    cnt4++;
		    timer4 = setTimeout('gogogo4()', speed);
		}
	function gogogo5() {
		 text = "??????";	
		 document.getElementById('DetailComment').innerHTML = text.substring(0, cnt5) + "_";
		    cnt5++;
		    timer5 = setTimeout('gogogo5()', speed);
		}
	function gogogo6() {
		 text = "????????????";
		 document.getElementById('DetailBoardFiles').innerHTML = text.substring(0, cnt6) + "_";
		    cnt6++;
		    timer6 = setTimeout('gogogo6()', speed);
		}
	function comment(){

		location.href="comment?id=${boardID}";

	}
gogogo();
gogogo1();
gogogo2();
gogogo3();
gogogo4();
gogogo5();
gogogo6();
document.getElementById("titleBody").style.backgroundColor = "#000000";
</script>
</body>
</html>