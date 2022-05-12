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
			<table  border="1" align="center">
				<tr>
					<td>번호</td>
					<td>모임 명</td>
					<td>모임 장</td>
					<td>개설 날짜</td>
			
				</tr>
			
				<c:forEach items="${list}" var="list" >
				<tr>
					<td>${list.sg_id}</td>
					<td><a href="small_group_content?sg_id=${list.sg_id}">${list.sg_name}</a></td>
					<td>${list.u_id}</td>
					<td>${list.sg_date}</td>
				</tr>
				</c:forEach>
			</table>
			<br>
			<a href="small_group_list?">모임 리스트 보기</a>	
			<br>
			<a href="small_group_joinlist?u_id=test11">모임 가입신청한 내역 보기</a>	<!-- 로그인된 유저아이디 ${u_id}해야됨  -->
			<br>
			<!-- 여기는 조건문 걸어야됨 -->	
			<!-- if u_id==모임장들 아이디 모아놓은 리스트...? 생각을 좀 해보자-->
			<a href="sg_joinlist_gi?u_id=test2">모임 가입신청온 내역보기</a><!-- 로그인된 모임장아이디 ${u_id}해야됨  -->
			<br>
			
			<a href="join_sgroup_list?u_id=test11">가입한 모임 보기</a><!-- 로그인된 유저아이디 ${u_id}해야됨  -->
			<br>
			<a href="sg_member_list?u_id=test2">내 모임 멤버리스트</a><!-- 로그인된 모임장아이디 ${u_id}해야됨  -->
			<br>
			<a href="sg_Schedule?u_id=test15">일정</a><!-- 로그인된 동호회장아이디 ${u_id}해야됨  -->
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
