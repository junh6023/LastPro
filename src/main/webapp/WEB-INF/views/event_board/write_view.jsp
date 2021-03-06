

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page import="mountain.mania.com_DTO.*" %>
    <%@ page import="java.util.*"%>
    
	
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="${path}/resources/css/publicCss.css?after">
<script type="text/javascript" src="${path}/resources/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="${path}/resources/js/public.js"></script>

<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<jsp:include page="../top.jsp" />
			<div class="conteant" >
				<div class="mypage-nav" >
					<ul>
						<li><h2>게시판</h2></li>
						<li><a href="list">자유게시판</a></li>
						<li><a href="n_list">공지게시판</a></li>
						<li><a href="e_list">이벤트게시판</a></li>
					</ul>
				</div>
				<div class="main-text" >

	<table width="500" cellpadding="0" cellspacing="0" border="1">
		<form action="e_write" method="post" enctype="Multipart/form-data"  >
			<tr>
				<td>이름</td>
				<td><input type="text" name="u_id" value="${res.u_id}" size ="50"></td>
			</tr>
			<tr>
				<td> 제목</td>
				<td> <input type="text" name="b_title" size ="50"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td> <textarea name="b_content" rows="10"></textarea></td>
				
			</tr>
			<tr>
			<td>글 비번</td>
				<td> <input type="text" name="b_pw"></td>
			</tr>
			<tr>
			<td>사진업로드</td>
				<td> <input type="file" name="file"></td>
			</tr>
			<tr>
				<td colspan="2"> <input type="submit" value="입력"></td>
		</tr>
		</form>
	
	</table>

							
				</div>
			</div>

	
	<jsp:include page="../footer.jsp" />
	<script>
		$(function(){
			$('.table-con').click(function(){
				var popin = $(this).siblings('#pop');
				popin.fadeIn();
				
			})
			$('#pop .pop-bg').click(function(){
				var popout = $(this).parent('#pop');
				$(popout).fadeOut();

			})
				
			
			
		})
	</script>	
</body>
</html>
