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
<title>Chat Web</title>
<link href="css/style.css" type="text/css" rel="stylesheet" />
<script src="js/board.js"></script>
</head>
<body id="boardBody">
<button id="texts1" onclick="clickBack();" onkeyup="enterkeydown4();">&nbsp;</button>
<span id="title" class="title">
	&nbsp;
</span>
<main class="main">
					<div class="noticemargin-top">
						<table class="boardTable">
							<thead>
								<tr class="boardTable">
									<th class="w60">번호</th>
									<th class="expand">제목</th>
									<th class="w100">작성자</th>
									<th class="w100">조회수</th>
								</tr>
							</thead>
							<tbody>
									<c:forEach var="b" items="${list}" begin="0" end="9">
								<tr>
									<td class="titleindenttext-align-left">${b.boardID}</td>
									<td id="text5" class="titleindenttext-align-left"><a href="detail?id=${b.boardID}">${b.boardTitle}</a></td>
									<td class="titleindenttext-align-left">${b.userID}</td>
									<td class="titleindenttext-align-left"><fmt:formatNumber value="${b.boardHit}"/></td>
								</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
	
				
					<div class="text-align-rightmargin-top">
						<button onclick="clickWrite();" class="writeButton">글쓰기</button>				
					</div>
				<div class="margin-top align-center pager">	
				<c:set var="pageNumber" value="${pageNumber}" />
				<c:set var="nextPage" value="${nextPage}" />
				<div>
					<c:if test="${pageNumber eq 1}">
					<a class="btnbtn-prev" onclick="alert('이전 페이지가 없습니다.')">이전</a>
					</c:if>
					<c:if test="${pageNumber ne 1}">
					<a class="btnbtn-prev" href="?pageNumber=${pageNumber-1}">이전</a>
					</c:if>
					<c:if test="${nextPage eq 1}">
					<a href="?pageNumber=${pageNumber + 1}" class="btnbtn-next">다음</a>
					</c:if>
					<c:if test="${nextPage ne 1}">
					<a onclick="alert('다음 페이지가 없습니다.')" class="btnbtn-next">다음</a>
					</c:if>
				</div>
						</div>
			</main>
<script>
gogogo();
setTimeout(function() {gogogo1()}, 500);
setTimeout(function() {focus()}, 1000);
document.getElementById("boardBody").style.backgroundColor = "#000000"
</script>
</body>
</html>