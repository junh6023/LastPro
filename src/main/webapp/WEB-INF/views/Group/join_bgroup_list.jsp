
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
						<c:set var="check" value="${check}" />
						<c:if test="${check eq true}">
						<li><a href="bg_joinlist_gi?u_id=test3">동호회 가입신청온 내역보기</a><!-- 로그인된 동호회장아이디 ${u_id}해야됨  --></li>
						</c:if>
						<li><a href="big_group_joinlist?u_id=test10">동호회 가입신청한 내역 보기</a></li>
						<li><a href="join_bgroup_list?u_id=test10">가입한 동호회 보기</a><!-- 로그인된 유저아이디 ${u_id}해야됨  --></li>
						<c:set var="check" value="${check}" />
						<c:if test="${check eq true}">
						<li><a href="bg_member_list?u_id=test3">내 동호회 멤버리스트</a><!-- 로그인된 모임장아이디 ${u_id}해야됨  --></li>
						</c:if>
						<li><h2>친목모임</h2></li>
						<c:set var="check" value="${s_check}" />
						<c:if test="${check eq true}">
						<li><a href="sg_joinlist_gi?u_id=test2">모임 가입신청온 내역보기</a><!-- 로그인된 모임장아이디 ${u_id}해야됨  --></li>
						</c:if>
						<li><a href="small_group_joinlist?u_id=test11">모임 가입신청한 내역 보기</a>	<!-- 로그인된 유저아이디 ${u_id}해야됨  --></li>
						<li><a href="join_sgroup_list?u_id=test11">가입한 모임 보기</a><!-- 로그인된 유저아이디 ${u_id}해야됨  --></li>
						<c:set var="check" value="${s_check}" />
						<c:if test="${check eq true}">
						<li><a href="sg_member_list?u_id=test2">내 모임 멤버리스트</a><!-- 로그인된 모임장아이디 ${u_id}해야됨  --></li>
						</c:if>
						
					</ul>
				</div>
				<div class="main-text" >
				<table  border="1" align="center">
					<tr>
						<td>랭킹</td>
						<td>동호회 명</td>
						<td>동호회 경험치</td>
						<td>동호회 레벨</td>
						<td>동호회 장</td>
						<td>개설 날짜</td>
						<td>비 고</td>
				
					</tr>
				
					<c:forEach items="${join_bg_list}" var="list" >
					<tr>
						<td>${list.bg_rank}</td>
						<td>${list.bg_name}</td>
						<td>${list.bg_experience}</td>
						<td>${list.bg_level}</td>
						<td>${list.u_id}</td>
						<td>${list.bg_date}</td>
						<td><a href="delete_bg_group?u_id=test8&bg_id=${list.bg_id}">동호회 탈퇴하기</a></td>
					</tr>
					
					</c:forEach>
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


