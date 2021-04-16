<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
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
<span id="title" class="title">
	&nbsp;
</span>
<main class="main">
				<div class="search-form margin-top first align-right">
					<form class="table-form">
							<button class="boardSearch" type="submit">검색</button>
							<input class="boardSearch" type="text" name="search"/>
							<select class="boardSearch" name="searchOption">
								<option value="title">제목</option>
								<option value="writerId">작성자</option>
							</select>
					</form>
				</div>
					<div class="notice margin-top">
						<table class="boardTable">
							<thead>
								<tr class="boardTable">
									<th class="w60">번호</th>
									<th class="expand">제목</th>
									<th class="w100">작성자</th>
									<th class="w100">작성일</th>
									<th class="w60">조회수</th>
									<th class="w40">삭제</th>
								</tr>
							</thead>
							<tbody>
	
									<c:forEach var="n" items="${list}">
								<tr>
									<td>${n.id}</td>
									<td class="title indent text-align-left"><a href="detail?id=${n.id}">${n.title}</a><span>[${n.cmtCount}]</span></td>
									<td>${n.writerId}</td>
									<td><fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss" value="${n.regDate}"/></td>
									<td><fmt:formatNumber value="${n.hit}"/></td>
									<td><input type="checkbox" name="del-id" value="${n.id}"></td>
								</tr>
								</c:forEach>
							
							</tbody>
						</table>
					</div>
	
					<c:set var="page" value="${(empty param.p)?1:param.p}" />
					<c:set var="startNum" value="${page-(page-1)%5}" />
					<c:set var="lastNum" value="${fn:substringBefore(Math.ceil(count/10), '.')}" />
			
					<div class="indexer margin-top align-right">
					<h3 class="hidden">현재 페이지</h3>
					<div><span class="text-orange text-strong">${(empty param.p)?1:param.p }</span> / ${lastNum } pages</div>
					</div>
	
					<div class="text-align-right margin-top">
						<button class="btn-text btn-default" onclick="write();">글쓰기</button>				
					</div>
				<div class="margin-top align-center pager">	
		
				<div>
			
					<c:if test="${startNum>1}">
					<a class="btn btn-prev" href="?p=${startNum-1}&t=&q=">이전</a>
					</c:if>
					<c:if test="${startNum<=1}">
					<span class="btn btn-prev" onclick="alert('이전 페이지가 없습니다.');">이전</span>
					</c:if>
				</div>
				
				<ul class="-list- center">
					<c:forEach var="i" begin="0" end="4">
					<c:if test="${(startNum+i) <= lastNum }">
					<li><a class="-text- ${(page==(startNum+i))?'orange':''} bold" href="?p=${startNum+i}&f=${param.f}&q=${param.q}">${startNum+i}</a></li>
					</c:if>
					</c:forEach>
				</ul>
				<div>
						<c:if test="${startNum+4<lastNum}">
						<a href="?p=${startNum+5}&t=&q=" class="btn btn-next">다음</a>
						</c:if>
						<c:if test="${startNum+4>=lastNum}">
						<span class="btn btn-next" onclick="alert('다음 페이지가 없습니다.');">다음</span>
						</c:if>
				</div>
				
						</div>
			</main>
<script>
gogogo();
document.getElementById("boardBody").style.backgroundColor = "#000000"
</script>
</body>
</html>