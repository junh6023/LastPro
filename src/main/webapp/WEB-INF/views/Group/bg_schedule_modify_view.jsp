<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page import="mountain.mania.com_DTO.*" %>
    <%@ page import="java.util.*"%>
      <%@ page import="mountain.mania.com_DTO.MDto"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%	
	String year =String.valueOf(request.getAttribute("year"));
	String month =String.valueOf(request.getAttribute("month"));
	String day =String.valueOf(request.getAttribute("day")); 
	%>
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
						<li><h2>동호회</h2></li>
						<li><a href="big_group_list">동호회 리스트 보기 </a></li>
						<li><a href="bg_rank30">상위 10랭킹 </a></li>
						<li><a href="group_recruit">동호회 및 모임 모집글 </a></li>
						<li><a href="bg_Schedule?u_id=test3">일정</a></li><!-- 로그인된 동호회장아이디 ${u_id}해야됨  -->
						<li><a href="bg_rank">동호회 랭킹보기</a></li>
						<li><h2>모임</h2></li>
						<li><a href="small_group_list?">모임 리스트 보기</a>	</li>
						<li><a href="sg_Schedule?u_id=test15">일정</a><!-- 로그인된 동호회장아이디 ${u_id}해야됨  --></li>
					</ul>
				</div>
				<div class="main-text" >
			<c:forEach items="${list}" var="list">
			<form action="bg_schedule_modifyaction?u_id=test3" method="post">
			<table>
				<tr>
					<td>일정 :</td>
					<td>
						<input type="text" name="year" value="<%=year%>" size="3">년
						<input type="text" name="month" value="<%=month%>" size="3">월
						<input type="text" name="day" value="<%=day%>" size="3">일
						<input type="hidden" name="bgs_id" value="${list.bgs_id}">
					</td>
				</tr>
				<tr>
					<td>제목 :</td><td><input type="text" name="bgs_title" value="${list.bgs_title}"></td>
				</tr>
				<tr>
					<td>산이름 :</td><td><input type="text" name="m_name" value="${list.m_name}"></td>
				</tr>
				<tr>
					<td>코스 :</td><td><input type="text" name="c_name" value="${list.c_name}"></td>
				</tr>
				<tr>
					<td>동호회 :</td><td>${list.bg_name}</td>
				</tr>
				<tr>
					<td>내용 :</td><td><input type="text" name="content" value="${list.content}"></td>
				</tr>
			</table>
			<input type="submit" value="수정완료">
			</form>
			</c:forEach>
					
		
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

