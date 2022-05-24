<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><!-- jstl사용하려면 임포트 필수-->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="top.jsp" />
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
					<h3>나의 가입신청내역</h3>
<table  border="1" align="center">
	<tr>
		<td>모임 명</td>
		<td>신청날짜</td>
		<td>승인여부</td>
		<td>비고</td>
	</tr>
	<c:forEach items="${join_list}" var="join_list">
		<tr>
			<td>${join_list.sg_name}</td>
			<td>${join_list.sgj_date}</td>
			<td>${join_list.y_n}</td>
			<td>${join_list.note}</td>
		</tr>
	</c:forEach>
</table>
				</div>
			</div>

	
<jsp:include page="footer.jsp" />
</body>
</html>