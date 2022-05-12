<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${path}/resources/css/loginform.css">
<link rel="stylesheet" href="${path}/resources/css/publicCss.css?after">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100&display=swap"
	rel="stylesheet">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="wrap">
		<div class="intro_bg">
		
			<div class="header" id="link_header">
				<div class="searchArea">
					<form>
						<input type="search" placeholder="Search"> <span>검색</span>
					</form>
				</div>
				<ul class="nav">
					<li><a href="loginform">로그인</a></li>
					<li><a href="#">회원가입</a></li>
					<li><a href="#">마이페이지</a></li>
					
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
				<a href="#" class="active">산정보</a>
				</div>
				
			</div>
		</li>
		<li>
			<div>
				<div class="contents1">
				<a href="#">날씨</a>
				</div>
				
			</div>
		</li>
		<li>
			<div>
				<div class="contents1">
				<a href="#">모임</a>
				</div>
				
			</div>
		</li>
		<li>
			<div>
				<div class="contents1">
				<a href="#">게시판</a>
				</div>
			</div>
		</li>
		<li>
			<div>
				<div class="contents1">
				<a href="#">등산장비</a>
				</div>
			</div>
		</li>
		<li>
			<div>
				<div class="contents1">
				<a href="#">고객센터</a>
				</div>
			</div>
		</li>
	</ul>
	<div class="main_text0" id="link_main_text0">
	<form action="" method="post">
	
		<fieldset class="lo">
			<legend>로그인</legend>
			<div class="login">
				<ul class="top">
					<li><label for="txt1">아이디</label><input type="text" id="txt1"></li>
					<li><label for="txt2">비밀번호</label><input type="text" id="txt2"></li>
					<li class="btn"><a href="#a">로그인</a></li>
					<li class="save"><input type="checkbox" id="chk1"><label for="chk1">ID 저장</label></li>
				</ul>
				<ul class="btm">
					<li>아이디를 잊으셨나요?<a href="#a">아이디찾기</a></li>
					<li>비밀번호를 잊으셨나요?<a href="#a">비밀번호찾기</a></li>
				</ul>
			</div>	
		</fieldset>

	</form>
	</div>
		<footer>
			<div>LOGO</div>
			<div>
				CEO. 타모디자인 <br> Addr.서울특별시 금천구 가산1로 280-3 우림하이엔드타워 6차 14F 고객센터
				02 - 223 - 2912~5 <br> COPYRIGHT 2019. TAMO. ALL RIGHT
				RESERVED.
			</div>
		</footer>
</body>
</html>