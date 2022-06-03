
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
						<li><a href="n_list">공지게시판</a></li>
						<li><a href="list" class="active">자유게시판</a></li>
						<li><a href="e_list">이벤트게시판</a></li>
					</ul>
				</div>
				<div class="main-text" >
					 	<c:set var="result1" value="${result}"/>
<c:choose>
<c:when test="${result1 == 'ok'}">
	<script>
		alert("답변 등록완료");
	</script>
</c:when>
<c:when test="${result1 eq 'no'}">
	<script>
		alert("욕설은 등록할 수 없습니다.");
	</script>
</c:when>
<c:otherwise> 
	<script>
		alert("자유게시판 입니다~! 회원간 욕설은 삼가주세요.");
	</script>
</c:otherwise>
</c:choose>
<br><br>
<h1 >자유 게시판</h1>
<br><br>
		<span>
		 &nbsp;&nbsp;&nbsp;총 게시글 수 : ${count}
		</span><br>
		<span id="usearch">
		<form action="search_uboard" method="post" align="center">
			<input type="text" name="searchs">&nbsp;<input type="submit" value="검색">
		</form>
		</span>
	<table width="500" cellpadding ="0" cellspacing="0" border="1" align="center"
	>
	
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>이름</th>
			<th>날짜</th>
			<th>히트</th>
			
		</tr>
		<c:forEach items="${list}" var="dto">
		<tr>
			<td>${dto.b_id}</td>
			
				
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
				
			<a href="content_view?b_id=${dto.b_id}" >${dto.b_title}</a>
			</td>
				
			<td>${dto.u_id}</td>		


				<td>${dto.b_date}</td>
				<td>${dto.b_hit}</td>
		</tr>
		</c:forEach>
	<tr>
			<td colspan="5" > <a href="write_view">글작성</a> </td>
			</tr>
	
			<tr align=center height=20>
			<td colspan=7 style=font-family:Tahoma;font-size:10pt;>
			
				<c:choose>
					<c:when test = "${page<=1}" >
						[이전]&nbsp;
					</c:when>
					<c:otherwise>
						<a href="list?page=${page-1}">[이전]</a>&nbsp;
					</c:otherwise>
				</c:choose>
				
	
				<c:forEach var="a" begin="${startpage}" end="${endpage}">
					<c:choose>
						<c:when test = "${a==page}">
							[${a}]
						</c:when>
						<c:otherwise>
							<a href="list?page=${a}">[${a}]</a>&nbsp;
						</c:otherwise>
					</c:choose>
				</c:forEach>
					
				<c:choose>
					<c:when test ="${page>=maxpage}">
						[다음]
					</c:when>
					<c:otherwise>
						<a href="list?page=${page+1}">[다음]</a>
					</c:otherwise>
				</c:choose>
			</td>
	</tr>
	
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



