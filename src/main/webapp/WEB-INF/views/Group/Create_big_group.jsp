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

<c:set var="check" value="${check}" />
<c:if test="${check eq false}">
	<script>
		alert("이미 동호회장이거나 동호회 가입 멤버입니다.");
		location.href="group_recruit";
	</script>
</c:if>

<c:if test="${idnull eq 'idnull' }">
	<script>
		alert("로그인 해주세요");
		location.href="member/loginform.do";
	</script>

</c:if>
	<jsp:include page="../top.jsp" />
			<div class="conteant" >
				<div class="mypage-nav" >
					<ul>
						<li><h2>동호회</h2></li>
						<li><a href="big_group_list">동호회 리스트 보기 </a></li>
						<li><a href="bg_rank30">상위 30랭킹 </a></li>
						<li><a href="group_recruit">동호회 및 모임 모집글 </a></li>
						<li><a href="bg_Schedule">일정</a></li><!-- 로그인된 동호회장아이디 ${u_id}해야됨  -->
						<li><h2>모임</h2></li>
						<li><a href="small_group_list">모임 리스트 보기</a>	</li>
						<li><a href="sg_Schedule">일정</a><!-- 로그인된 동호회장아이디 ${u_id}해야됨  --></li>
					</ul>
				</div>
				<div class="main-text" >
				 	<form name="Create_Group_form" action="big_group_addCommand" method="post">
						<table>
							<tr>
							<td>신청자 아이디: </td><td><input type="text" name="u_id" value="${res.u_id}"  readonly></td><!-- 로그인된 유저아이디 ${u_id}해야됨  -->
							</tr>
							<tr>
							<td>동호회 이름 : </td><td><input type="text" name="g_name"></td>			
							</tr>	
							<tr>
							<td>동호회 소개 : </td><td><textarea name="g_intro"></textarea></td>			
							</tr>
							<tr>
							<td colspan="2"><input type="submit" value="신청하기"></td>			
							</tr>
						</table>
					</form>
						
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