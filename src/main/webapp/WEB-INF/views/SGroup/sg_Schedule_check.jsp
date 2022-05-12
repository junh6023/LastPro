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
						<table>
							<tr>
								<td>일정 :</td><td>${list.sgs_date}</td>
							</tr>
							<tr>
								<td>제목 :</td><td>${list.sgs_title}</td>
							</tr>
							<tr>
								<td>산이름 :</td><td>${list.m_name}</td>
							</tr>
							<tr>
								<td>코스 :</td><td>${list.c_name}</td>
							</tr>
							<tr>
								<td>동호회(모임) :</td><td>${list.sg_name}</td>
							</tr>
							<tr>
								<td>내용 :</td><td>${list.content}</td>
							</tr>
						</table>
					<c:set var="check" value="${check}" />
					<c:if test="${check eq true}">
					<a href="sg_schedule_modify?sgs_id=${list.sgs_id}&title=${list.sgs_title}&sgs_date=${list.sgs_date}">수정하기</a>
					<a href="sg_schedule_delete?sgs_id=${list.sgs_id}&u_id=test15">삭제하기</a>
					</c:if>
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