
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
						<li><a href="bg_joinlist_gi">동호회 가입신청온 내역보기</a><!-- 로그인된 동호회장아이디 ${u_id}해야됨  --></li>
						</c:if>
						<li><a href="big_group_joinlist">동호회 가입신청한 내역 보기</a></li>
						<li><a href="join_bgroup_list">가입한 동호회 보기</a><!-- 로그인된 유저아이디 ${u_id}해야됨  --></li>
						<c:set var="check" value="${check}" />
						<c:if test="${check eq true}">
						<li><a href="bg_member_list">내 동호회 멤버리스트</a><!-- 로그인된 모임장아이디 ${u_id}해야됨  --></li>
						</c:if>
						<li><a href="bg_active">내 동호회 활동내역 보기</a>
						<li><h2>친목모임</h2></li>
						<c:set var="check" value="${s_check}" />
						<c:if test="${check eq true}">
						<li><a href="sg_joinlist_gi">모임 가입신청온 내역보기</a><!-- 로그인된 모임장아이디 ${u_id}해야됨  --></li>
						</c:if>
						<li><a href="small_group_joinlist">모임 가입신청한 내역 보기</a>	<!-- 로그인된 유저아이디 ${u_id}해야됨  --></li>
						<li><a href="join_sgroup_list">가입한 모임 보기</a><!-- 로그인된 유저아이디 ${u_id}해야됨  --></li>
						<c:set var="check" value="${s_check}" />
						<c:if test="${check eq true}">
						<li><a href="sg_member_list">내 모임 멤버리스트</a><!-- 로그인된 모임장아이디 ${u_id}해야됨  --></li>
						</c:if>
						<li><a href="sg_active">내 모임 활동내역 보기</a>
					</ul>
				</div>
				<div class="main-text" >
					 <!-- 모임장일때만 볼수있는 페이지가 되어야됨
					select u_id from big_group_list 로 모임장들의 아이디를 뽑은 다음
					 if (u_id==${u_id}이런식...으로 모임장인지 구분한다.....? -->
					<table  border="1" align="center">
						<tr>
							<td>신청자</td>
							<td>경험치</td>
							<td>레벨</td>
							<td>신청일자</td>
							<td>승인 여부</td>
							<td>비고</td>
							<td colspan="2">choose</td>
						</tr>
						<c:forEach items="${joinlist}" var="joinlist">
						<tr>
							<td>${joinlist.u_id}</td>
							<td>${joinlist.u_experience}</td>
							<td>${joinlist.u_level}</td>
							<td>${joinlist.bgj_date}</td>
							<td>${joinlist.y_n}</td>
							<td>${joinlist.note}</td>
							<td><a href="yes?u_id=${joinlist.u_id}&bg_id=${joinlist.bg_id}&bgj_id=${joinlist.bgj_id}">승인</a></td>
							<td><a href="no?bgj_id=${joinlist.bgj_id}">거절</a></td>
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
</html>