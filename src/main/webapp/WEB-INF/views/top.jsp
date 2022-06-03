<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="wrap">
		<div class="intro_bg">
		${userid}
			<div class="header" id="link_header">
				<div class="searchArea">
					<form action="msearch">
						<input type="search" placeholder="Search"> <span type="submit">검색</span>
					</form>
				</div>
				<ul class="nav">
				<c:set var="userid" value="${res.u_id}"/>
				<c:choose>
				 <c:when test="${empty userid}">
					<li><a href="member/loginform.do">로그인</a></li>
					<li><a href="member/write.do">회원가입</a></li>
				
				</c:when>
				<c:otherwise>
					<li><a href="#">${userid}님 환영합니다.</a></li>
					<li><a href="logout">로그아웃</a></li>	
						<li><a href="mypage">마이페이지</a></li>
				</c:otherwise>
				</c:choose>
				
								
				

				</ul>

			</div>
			<div class="intro_text">
				<a href="test"><h1>맛동산</h1></a>
			</div>
		</div>
	</div>
	<!-- intro end-->

	<ul class="amount">
		<li>
			<div>
				<div class="contents1">
					<a href="mountaininfo?actives=mountaininfo" class="test1"
						id="test1">산정보</a>
				</div>

			</div>
		</li>
		<li>
			<div>
				<div class="contents1">
					<a href="search_weather?area=60 127&actives=weather" class="test1" id="test2">날씨</a>
				</div>

			</div>
		</li>
		<li>
			<div>
				<div class="contents1">
					<a href="group_recruit?actives=group"  class="test1" id="test3">모임</a>
				</div>

			</div>
		</li>
		<li>
			<div>
				<div class="contents1">
					<a href="n_list?actives=board"  class="test1" id="test4">게시판</a>
				</div>
			</div>
		</li>
		<li>
			<div>
				<div class="contents1">
					<a href="itemslist?actives=item&item=상" class="test1" id="test5">등산장비</a>
				</div>
			</div>
		</li>
		<li>
			<div>
				<div class="contents1">
					<a href="Repetition_QnA?actives=uscen" class="test1" id="test6">고객센터</a>
				</div>
			</div>
		</li>
	</ul>
	<!--amount end-->
	<script>
	
	
	
	<%String top_page = request.getParameter("actives");

//class 추가부분
//main 클릭시 작동
if (top_page == null || top_page.equals("main")) {%>
		document.getElementById("top_main").className += ' active';
	<%}
	//newItem
	else if (top_page.equals("mountaininfo")) {%>
		document.getElementById("test1").className += ' active';
	<%}

	//bestitem
	else if (top_page.equals("group")) {%>
		document.getElementById("test3").className += ' active';
	<%}

	else if (top_page.equals("item")) {%>
		document.getElementById("test5").className += ' active';
	<%}

	else if (top_page.equals("uscen")) {%>
		document.getElementById("test6").className += ' active';
	<%}

	else if (top_page.equals("weather")) {%>
		document.getElementById("test2").className += ' active';
	<%}	
	
	else if (top_page.equals("board")) {%>
	document.getElementById("test4").className += ' active';
<%}%>
	</script>
</body>
</html>