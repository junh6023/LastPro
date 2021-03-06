

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
						<li><a href="n_list" class="active">공지게시판</a></li>
						<li><a href="list">자유게시판</a></li>
						<li><a href="e_list">이벤트게시판</a></li>
					</ul>
				</div>
				<div class="main-text" >
					 	
<br><br>
<h1 >공지 게시판</h1>
<br><br>
	<span>
	 &nbsp;&nbsp;&nbsp;총 게시글 수 : ${count}
	</span><br>
		<span id="usearch">
		<form action="search_nboard" method="post" align="center">
			<input type="text" name="searchs">&nbsp;<input type="submit" value="검색">
		</form>
		</span>
	<table width="500" cellpadding ="0" cellspacing="0" border="1" align="center">
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

				<c:forEach var="i" begin="0" end="${dto.b_lev*2}"></c:forEach>

				★

			<a href="n_content_view?b_id=${dto.b_id}" >${dto.b_title}</a>
			</td>
			<td>${dto.u_id}</td>

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
						<a href="n_list?page=${page-1}">[이전]</a>&nbsp;
					</c:otherwise>
				</c:choose>
				
	
				<c:forEach var="a" begin="${startpage}" end="${endpage}">
					<c:choose>
						<c:when test = "${a==page}">
							[${a}]
						</c:when>
						<c:otherwise>
							<a href="n_list?page=${a}">[${a}]</a>&nbsp;
						</c:otherwise>
					</c:choose>
				</c:forEach>
					
				<c:choose>
					<c:when test ="${page>=maxpage}">
						[다음]
					</c:when>
					<c:otherwise>
						<a href="n_list?page=${page+1}">[다음]</a>
					</c:otherwise>
				</c:choose>
			</td>
	</tr>

		<c:if test="${u_id eq 'Admin'}">
		<tr>
			<td colspan="5" > <a href="n_write_view">글작성</a> </td>
		</tr>
	</c:if>

	
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



