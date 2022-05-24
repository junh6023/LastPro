

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
					<h1 >자주하는 질문</h1>
<br><br>
	<span>
	 &nbsp;&nbsp;&nbsp;총 게시글 수 : ${count}
	</span><br><br><br>
	<form action="search_csboard" method="post">
		<input type="text" name="searchs">&nbsp;<input type="submit" value="검색">
	</form>
	<br>
	<table width="500" cellpadding ="0" cellspacing="0" border="1" align="center"
	>
		<tr>
			<td>번호</td>
			<td>관리자</td>
			<td>질의내용</td>
			<td>날짜</td>
			<td>히트</td>
			
		</tr>
		<c:forEach items="${list}" var="dto">
		<tr>
			<td>${dto.b_id}</td>
			<td>${dto.u_id}</td>
		
			
				<td style="font-family:Tahoma;
				font-size:10pt;" align="left">
				
				<c:choose>
			
				<c:when test = "${0 ne dto.b_lev}" >
				
				<c:forEach var="i" begin="0" end="${dto.b_lev*2}">&nbsp;</c:forEach>
				▶
				</c:when>
				<c:otherwise>
				★
				</c:otherwise>
				</c:choose>
			<a href="cs_content_view?b_id=${dto.b_id}" >${dto.b_title}</a>
			</td>

				<td>${dto.b_date}</td>
				<td>${dto.b_hit}</td>
		</tr>
		</c:forEach>
		
			
			
		<tr align=center height=20>
			<td colspan=7 style=font-family:Tahoma;font-size:10pt;>
			
				<c:choose>
					<c:when test = "${page<=1}" >
						[이전]&nbsp;
					</c:when>
					<c:otherwise>
						<a href="Repetition_QnA.jsp?page=${page-1}">[이전]</a>&nbsp;
					</c:otherwise>
				</c:choose>
				
	
				<c:forEach var="a" begin="${startpage}" end="${endpage}">
					<c:choose>
						<c:when test = "${a==page}">
							[${a}]
						</c:when>
						<c:otherwise>
							<a href="Repetition_QnA.jsp?page=${a}">[${a}]</a>&nbsp;
						</c:otherwise>
					</c:choose>
				</c:forEach>
					
				<c:choose>
					<c:when test ="${page>=maxpage}">
						[다음]
					</c:when>
					<c:otherwise>
						<a href="Repetition_QnA.jsp?page=${page+1}">[다음]</a>
					</c:otherwise>
				</c:choose>
				
				
				
				
			</td>
	</tr>

	<c:if test="${u_id eq 'Admin'}">
		<tr>
			<td colspan="5" > <a href="cs_write_view">글작성</a> </td>
		</tr>
	</c:if>
	</table>
				 	
				 	
				</div>
			</div>
	
	<jsp:include page="../footer.jsp" />
</body>
</html>