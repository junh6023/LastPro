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
						<li><a href="big_group_list?actives=group">동호회 리스트 보기 </a></li>
						<li><a href="bg_rank30?actives=group" class="active">상위 30랭킹 </a></li>
						<li><a href="group_recruit?actives=group">동호회 및 모임 모집글 </a></li>
						<li><a href="bg_Schedule">일정</a></li><!-- 로그인된 동호회장아이디 ${u_id}해야됨  -->
						<li><h2>모임</h2></li>
						<li><a href="small_group_list?actives=group">모임 리스트 보기</a>	</li>
						<li><a href="sg_Schedule?actives=group">일정</a><!-- 로그인된 동호회장아이디 ${u_id}해야됨  --></li>
					</ul>
				</div>
				<div class="main-text" >
					 <table  border="1" align="center">
						<tr>
							<th>동호회 랭킹</th>
							<th>동호회 명</th>
							<th>동호회 경험치</th>
							<th>동호회 레벨</th>
							<th>동회회 장</th>
							<th>개설 날짜</th>
						</tr>
					
						<c:forEach items="${bg_rank}" var="rank"  begin="0" end="30">
						<tr>
							<td>${rank.bg_rank}</td> <!--  GDto.java에 bg_rank 필드 및 게터셋터 추가해줘야함 안그럼 에러-->
							<td>${rank.bg_name}</td>
							<td>${rank.bg_experience}</td>
							<td>${rank.bg_level}</td>
							<td>${rank.u_id}</td>
							<td>${rank.bg_date}</td>
						</tr>
						</c:forEach>
							
			
					</table>
						<h3><a href="bg_rank">더보기</a></h3>
							
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