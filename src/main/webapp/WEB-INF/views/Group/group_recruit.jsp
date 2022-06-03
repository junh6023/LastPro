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
<script type="text/javascript" src="${path}/resources/js/public.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<jsp:include page="../top.jsp" />
			<div class="conteant" >
				<div class="mypage-nav" >
					<ul>
						<li><a href="group_recruit" class="active"><h2>동호회 만들기</h2> </a></li>
						<li><h2>동호회</h2></li>
						<li><a href="big_group_list?actives=group" >동호회 리스트 보기 </a></li>
						<li><a href="bg_rank30?actives=group">상위 30랭킹 </a></li>
						<li><a href="group_recruit?actives=group">동호회 및 모임 모집글 </a></li>
						<li><a href="bg_Schedule?actives=group">일정</a></li><!-- 로그인된 동호회장아이디 ${u_id}해야됨  -->
						<li><h2>모임</h2></li>
						<li><a href="small_group_list?actives=group">모임 리스트 보기</a>	</li>
						<li><a href="sg_Schedule?actives=group">일정</a><!-- 로그인된 동호회장아이디 ${u_id}해야됨  --></li>
					</ul>
				</div>
				<div class="main-text" >
					 <!-- ${u_id} 세션으로 아이디값 받아오는 것도 이렇게..? -->
				 	<ul class="group-recruit" >	
				 		<!-- <li><h1>동호회 및 모임 모집 페이지</h1><br></li> -->
						<li><h1>동호회 모집</h1></li>
						<li>
							<p>동호회를 개설하여 운영하실 동호회장을 모십니다~!<br>
							즐거운 등산을 더욱 신나고 활기차게 이끌어나가실 리더십 있는 분들께서는 어서 동호회를 만들어주세요~<br>
							여럿이 하면 즐거움도 두배!<br>
							신나는 등산을 하면서 경험치도 올리고 다른 동호회들과 랭킹도 겨뤄보세요!<br>
							많은 관심 부탁드립니다~!
							</p>
						</li>
						<li>
							<a href="Create_big_group">동호회 만들기</a>
						</li>
					</ul>
					<ul class="group-recruit" >	
						<li><h1>모임 모집</h1></li>
						<li>모집 관련 글</li>
						<li>
							<p>
								test
								test
								test
								test
							</p>
						</li>
						<li><a href="Create_small_group">모임 만들기</a></li>
					</ul>	
		
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