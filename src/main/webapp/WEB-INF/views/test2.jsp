<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${path}/resources/css/publicCss.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100&display=swap"
	rel="stylesheet">
<script type="text/javascript" src="${path}/resources/js/jquery-3.6.0.min.js"></script>﻿
<meta charset="UTF-8">
<title>Insert title here</title>

<script>
$(document).ready(function(){
	$(".btn").click(function(){
		$(".popup_bg").css({"display" : "block"});
		
	});
	
	$(".popup_bg").click(function(){
		$(".popup_bg").css({"display" : "none"});
	})
});
</script>
<style>
	.btn{
	width:100px;
	height:40px;
	background:deeppink;
	color:#fff;
	text-algin: center;TEST

	cursor:pointer;
	}
	.popup_bg{
	display:none;
	position: absolute;
	top:0;
	left:0;
	width:100%;
	height:100%;
	background: rgba(0,0,0,0.7);
	}
	.popup{
	position:absolute;
	left:calc(50% - 150px);
	top:calc(50% - 250px);
	width:300px;
	height:500px;
	background:#fff;
	}
</style>

</head>

<body>
	 <div>
		<div class="btn">TEST</div>
			<div class="popup_bg">
				<div class="popup"></div>
			</div>
	</div>

	<div class="wrap">
		<div class="intro_bg">
		
			<div class="header" id="link_header">
				<div class="searchArea">
					<form>
						<input type="search" placeholder="Search"> <span>검색</span>
					</form>
				</div>
				<ul class="nav">
					<li><a href="#">로그인</a></li>
					<li><a href="#">회원가입</a></li>
					<li><a href="#">마이페이지</a></li>
					
				</ul>

			</div>
			<div class="intro_text">
				<h1>맛동산</h1>
			</div>
		</div>
	</div>
	<!-- intro end-->

	<ul class="amount">
		<li>
			<div>
				<div class="contents1">
				<a href="#">산정보</a>
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
	<!--amount end-->
	<div class="conteant" >
		<div class="mypage-nav" >
			<ul>
				<li><a href="#">메뉴1</a></li>
				<li><a href="#" class="active" >메뉴2</a></li>
				<li><a href="#">메뉴3</a></li>
				<li><a href="#">메뉴4</a></li>
				<li><a href="#">메뉴5</a></li>
			</ul>
		</div>
		<div class="main-text" >
			<div class="data" >1 <br>
			2</div>
		</div>
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