<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <main>
                <h2 class="main title">공지사항 등록</h2>

                <div class="breadcrumb">
                    <h3 class="hidden">breadlet</h3>
                    <ul>
                        <li>home</li>
                        <li>게시글 관리</li>
                        <li>공지사항</li>
                    </ul>
                </div>

				<form method="post" action="write" enctype="multipart/form-data">
					<div class="margin-top first">
						<h3 class="hidden">공지사항 입력</h3>
						<table class="table">
							<tbody>
								<tr>
									<th>제목</th>
									<td class="text-align-left text-indent text-strong text-orange"
										colspan="3"><input type="text" name="boardTitle" /></td>
								</tr>
								<tr>
									<th>첨부파일</th>
									<td colspan="3" class="text-align-left text-indent"><input
										type="file" name="boardFile" /></td>
								</tr>
								<tr class="content">
									<td colspan="4"><textarea class="content" name="BoardContent" maxlength="2048"></textarea></td>
								</tr>
								<tr>
								</tr>
							</tbody>
						</table>
					</div>
					<div class="margin-top text-align-center">
						<input class="btn-text btn-default" type="submit" value="등록" />
						<a class="btn-text btn-cancel" href="board">취소</a>
					</div>
				</form>

			</main>
        </div>
    </div>

</body>
</html>