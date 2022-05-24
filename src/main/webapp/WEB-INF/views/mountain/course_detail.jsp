<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page import="mountain.mania.com_DTO.*"%>
<% List CList=(List)request.getAttribute("list");%>

<c:set var="path" value="${pageContext.request.contextPath}" />
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


<link rel="stylesheet" href="https://unpkg.com/swiper@8/swiper-bundle.min.css"/>

<script src="https://unpkg.com/swiper@8/swiper-bundle.min.js"></script>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<jsp:include page="../top.jsp" />
	<div class="conteant">
		<div class="mypage-nav">
			<ul>
				<li><a href="mountaininfo?actives=mountaininfo">산 선택하러가기</a></li>
				<li><a href="search_weather?area=60 127&actives=weather">날씨보러가기</a></li>
				
				
			</ul>
		</div>
		<div class="main-text">
			<div class="data mount-info">
				<ul>
					<li><h1>평균클리어시간!</h1></li>
					
					
					
					<li>
					
						<div class="swiper">
							<div class="swiper-wrapper">
							<%
			for(int i=0;i<CList.size();i++){
				CDto bl=(CDto)CList.get(i);
		%>
								<div class="swiper-slide"><img src="./mimg/<%=bl.getImg()%>"></div>
								<div class="swiper-slide"><img src="resources/image/we.png"></div>
							
							</div>
							<div class="swiper-pagination"></div>
							<div class="swiper-button-prev"></div>
							<div class="swiper-button-next"></div>						  
						 </div>
					
						<div class="data-tamp" >
							<div class="tamp-title" > 코스번호:<%=bl.getC_id()%></div>
							<div class="tamp-cont" >
								<div class="tamp-txt" >
									<span class="txt1" >코스레벨:</span><span class="txt2"><%=bl.getC_level() %></span>
								</div>
								<div class="tamp-txt" >
									<span class="txt1" >평균클리어시간:</span><span class="txt2">
									<%if(bl.getCleartime()==null){ %>
									없음
									<%}else{ %>
			
								<%=bl.getCleartime()%>
									<%} %>
									</span>
								</div>
						
								
							</div>
						</div>
						<div class="tamp-scont" >※이용자 분들의 코스 평균클리어시간입니다.</div>
						<div class="tamp-btn" >
							<a href="javascript:history.back()">코스재선택</a>
							<a href="search_weather?area=74 66">지금날씨보기</a>
						</div>
						<%} %>
					</li>
					
					
				</ul>	
			</div>
		</div>
	</div>
	<script>
		$(function(){
			const swiper = new Swiper('.swiper', {
			  // Optional parameter
			  loop: true,
			  navigation: {
			    nextEl: '.swiper-button-next',
			    prevEl: '.swiper-button-prev',
			  },
			  pagination: {
			    el: '.swiper-pagination',
			  },
			  autoplay : {  // 자동 슬라이드 설정 , 비 활성화 시 false
				  delay : 3000,   // 시간 설정
				  disableOnInteraction : false,  // false로 설정하면 스와이프 후 자동 재생이 비활성화 되지 않음
				},
			});
		})
	</script>
	<jsp:include page="../footer.jsp" />
</body>
</html>