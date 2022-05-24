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
<script language="javascript">
	function replyboard(){
		boardform.submit();
	}
	</script>

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
					
<!-- 게시판 답변 -->
<form action="QnA_ReplyAction" method="post" name="boardform">
<input type="hidden" name="b_id" value="${dto.b_id}">
<input type="hidden" name="b_lev" value="${dto.b_lev}">

<table cellpadding="0" cellspacing="0">
	<tr align="center" valign="middle">
		<td colspan="5">MVC 게시판</td>
	</tr>
	<tr>
		<td style="font-family:돋음; font-size:12" height="16">
			<div align="center">글쓴이</div>
		</td>
		<td>
			<input name="u_id" type="text" value="${u_id}"/>
		</td>
	</tr>
	<tr>
		<td style="font-family:돋음; font-size:12" height="16">
			<div align="center">제 목</div>
		</td>
		<td>
			<input name="b_title" type="text" size="50" 
				maxlength="100" value="Re: ${dto.b_title}"/>
		</td>
	</tr>
	<tr>
		<td style="font-family:돋음; font-size:12">
			<div align="center">내 용</div>
		</td>
		<td>
			<textarea name="b_content" cols="67" rows="15"></textarea>
		</td>
	</tr>
	<tr>
		<td style="font-family:돋음; font-size:12">
			<div align="center">비밀번호</div>
		</td>
		<td>
			<input name="b_pw" type="password">
		</td>
	</tr>
	
	<tr bgcolor="cccccc">
		<td colspan="2" style="height:1px;">
		</td>
	</tr>
	<tr><td colspan="2">&nbsp;</td></tr>
	
	<tr align="center" valign="middle">
		<td colspan="5">
		<a href="javascript:replyboard()">[등록]</a>&nbsp;&nbsp;
		<a href="javascript:history.go(-1)">[뒤로]</a>
		</td>
	</tr>
</table>
</form>
<!-- 게시판 답변 -->
				 	
				</div>
			</div>
	
	<jsp:include page="../footer.jsp" />
</body>
</html>

