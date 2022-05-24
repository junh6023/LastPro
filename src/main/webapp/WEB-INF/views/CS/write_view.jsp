

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="${path}/resources/css/style.css">
<link rel="stylesheet" href="${path}/resources/css/publicCss.css?after">
<script type="text/javascript" src="${path}/resources/js/public.js"></script>

</head>
<body>

	<jsp:include page="../top.jsp" />
	
	<div class="conteant" >
				<div class="mypage-nav" >
					<ul>
						<li><a href="Repetition_QnA">자주 묻는 질문</a></li>
						<li><a href="QnA_list">문의하기</a></li>
						
					</ul>
				</div>
				<div class="main-text" >

	<table width="500" cellpadding="0" cellspacing="0" border="1">
		<form action="cs_write" method="post"  >
			<tr>
				<td>이름</td>
				<td><input type="text" name="u_id" value="${res.u_id}" size ="50"></td>
			</tr>
			<tr>
				<td> 질의내용</td>
				<td> <input type="text" name="b_title" size ="50"></td>
			</tr>
			<tr>
				<td>답변</td>
				<td> <textarea name="b_content" rows="10"></textarea></td>
				
			</tr>
			<tr>
			<td>글 비번</td>
				<td> <input type="text" name="b_pw"></td>
			</tr>
			<!--<tr>
			<td>사진업로드</td>
				<td> <input type="file" name="file"></td>
			</tr>  -->
			<tr>
				<td colspan="2"> <input type="submit" value="입력"></td>
		</tr>
		</form>
	
	</table>
				 	
				 	
				</div>
			</div>
	
	<jsp:include page="../footer.jsp" />
</body>
</html>
