<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

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
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
		<c:set var="skycode" value="${SKY}" />
		
		
		<c:if test="${skycode eq '1'}">
			<c:set var="sky" value="맑음"/>
		</c:if>
		<c:if test="${skycode eq '3'}">
			<c:set var="sky" value="구름많음"/>
		</c:if>
		<c:if test="${skycode eq '4'}">
			<c:set var="sky" value="흐림"/>
		</c:if>
		<c:if test="${PTY eq '1'}">
			<c:set var="sky" value="비"/>
		</c:if>
			<c:if test="${sky eq '맑음' }">
			<c:set var="weathericons" value="data1 weather1"/>
		</c:if>
		<c:if test="${sky eq '구름많음'}">
			<c:set var="weathericons" value="data1 weather2"/>
		</c:if>
		<c:if test="${sky eq '흐림' }">
			<c:set var="weathericons" value="data1 weather3"/>
		</c:if>
		
	<jsp:include page="top.jsp" />
	<div class="conteant" style="height:auto;" >
		<div class="mypage-nav">
			<ul>
				<li><a href="weather" class="active">전국 날씨보기</a></li>
				<li><a href="search_weather?area=60 127" >지역별 날씨보기</a></li>
			</ul>
		</div>
		<div class="main-text">
			
			<div class="data">
				<p class="set" >${searchArea}</p>
				<div class="${weathericons}" >
					${b1}º ${sky}
				</div>
				<div class="data2" >
					<div class="txt-box" >
						<span class="txt1" >기온:</span><span class="txt2" >${b1}'C</span>
					</div>
					<div class="txt-box" >
						<span class="txt1" >강수량:</span><span class="txt2" >${precipitation} mm</span>
					</div>
					<div class="txt-box" >
						<span class="txt1" >습도:</span><span class="txt2" >${REH}%</span>
					</div>
					<div class="txt-box" >
						<span class="txt1" >풍향:</span><span class="txt2" >${VEC}deg</span>
					</div>
					<div class="txt-box" >
						<span class="txt1" >풍속:</span><span class="txt2" >${WSD}m/s </span>
					</div>
			

				</div>
			</div>
			
			<c:if test="${sky eq '구름많음'}" >
				<c:set var="icon" value="icon weather1"/>
			</c:if>
				
			<c:if test="${sky eq '맑음'}" >
				<c:set var="icon" value="icon weather2"/>
			</c:if>
			
			<c:if test="${sky eq '흐림'}" >
				<c:set var="icon" value="icon weather3"/>
			</c:if>
			
			<c:if test="${sky eq '비'}" >
				<c:set var="icon" value="icon weather4"/>
			</c:if>
			
			
			
			<div class="areaselect">
				<h3 >조회할 지역을 선택해주세요.</h3>
					<form action="search_weather?actives=weather">
						날씨 조회할 지역검색 : <select name="area">
						<option value="60 127">지역선택</option>
						<option value="60 127">서울/경기</option>
						<option value="98 76">부산</option>
						<option value="89 90">대구</option>
						<option value="73 134">춘천</option>
						<option value="92 131">강릉</option>
						<option value="60 121">수원</option>
						<option value="63 89">전주</option>
						<option value="58 74">광주</option>
						<option value="50 67">목포</option>
						<option value="52 38">대구</option>
						<option value="74 66">여수</option>
						<option value="102 84">울산</option>
						<option value="91 106">안동</option>
						<option value="76 122">원주</option>
						<option value="144 123">독도</option>
					</select>
					<input type="submit" value="검색">
					</form>
			</div>
			
		</div>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>