<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page import="mountain.mania.com_DTO.*"%>
<% int levelresult=((Integer)request.getAttribute("levelresult")).intValue();%>
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
		<c:set var="test" value="${weather}" />
		<c:set var="testSubString" value="${fn:substring(test,22,23)}" />

	<jsp:include page="top.jsp" />
	<div class="conteant">
		<div class="mypage-nav">
			<ul>
				<li><a href="levelhigh?m_level=상">상 난이도</a></li>
				<li><a href="levelhigh?m_level=중">중 난이도</a></li>
				<li><a href="levelhigh?m_level=하">하 난이도</a></li>
			</ul>
		</div>
		<div class="main-text">
			<div class="data mount-info">
				<ul>
					<li><h1>내 레벨에 맞는 오늘의 추천산</h1></li>
					
					
					<c:if test="${testSubString eq '구' and levelresult > 4}">
					<li>
						<div class="swiper">
							<div class="swiper-wrapper">
								<div class="swiper-slide"><img src="resources/image/mo.png"></div>
								<div class="swiper-slide"><img src="resources/image/we.png"></div>
								<div class="swiper-slide"><img src="resources/image/aaa.png"></div>
							</div>
							<div class="swiper-pagination"></div>
							<div class="swiper-button-prev"></div>
							<div class="swiper-button-next"></div>						  
						 </div>
					
						<div class="data-tamp" >
							<div class="tamp-title" > 한라산</div>
							<div class="tamp-cont" >
								<div class="tamp-txt" >
									<span class="txt1" >높이:</span><span class="txt2">123 </span>
								</div>
								<div class="tamp-txt" >
									<span class="txt1" >난이도:</span><span class="txt2">1232 </span>
								</div>
								<div class="tamp-txt" >
									<span class="txt1" >지역:</span><span class="txt2">1233 </span>
								</div>
								<div class="tamp-txt" >
									<span class="txt1" >높이:</span><span class="txt2">1233 </span>
								</div>
							</div>
						</div>
						<div class="tamp-scont" >※이용자 분들의 레벨 그리고 현재 날씨에 따라 추천된 오늘의 추천산입니다.</div>
						<div class="tamp-btn" >
							<a href="cousesee?mid=1">코스보기</a>
							<a href="#">지금날씨보기</a>
						</div>
					</li>
					</c:if>
					
					
					<c:if test="${testSubString eq '흐' and levelresult > 4}">
							<li>
						<div class="swiper">
							<div class="swiper-wrapper">
								<div class="swiper-slide"><img src="resources/image/mo.png"></div>
								<div class="swiper-slide"><img src="resources/image/we.png"></div>
								<div class="swiper-slide"><img src="resources/image/aaa.png"></div>
							</div>
							<div class="swiper-pagination"></div>
							<div class="swiper-button-prev"></div>
							<div class="swiper-button-next"></div>						  
						 </div>
					
						<div class="data-tamp" >
							<div class="tamp-title" > 한라산</div>
							<div class="tamp-cont" >
								<div class="tamp-txt" >
									<span class="txt1" >높이:</span><span class="txt2">123 </span>
								</div>
								<div class="tamp-txt" >
									<span class="txt1" >난이도:</span><span class="txt2">1232 </span>
								</div>
								<div class="tamp-txt" >
									<span class="txt1" >지역:</span><span class="txt2">1233 </span>
								</div>
								<div class="tamp-txt" >
									<span class="txt1" >높이:</span><span class="txt2">1233 </span>
								</div>
							</div>
						</div>
						<div class="tamp-scont" >※이용자 분들의 레벨 그리고 현재 날씨에 따라 추천된 오늘의 추천산입니다.</div>
						<div class="tamp-btn" >
							<a href="cousesee?mid=1">코스보기</a>
							<a href="#">지금날씨보기</a>
						</div>
					</li>
					</c:if>
					<c:if test="${testSubString eq '비' and levelresult > 4}">
							<li>
						<div class="swiper">
							<div class="swiper-wrapper">
								<div class="swiper-slide"><img src="resources/image/mo.png"></div>
								<div class="swiper-slide"><img src="resources/image/we.png"></div>
								<div class="swiper-slide"><img src="resources/image/aaa.png"></div>
							</div>
							<div class="swiper-pagination"></div>
							<div class="swiper-button-prev"></div>
							<div class="swiper-button-next"></div>						  
						 </div>
					
						<div class="data-tamp" >
							<div class="tamp-title" > 한라산</div>
							<div class="tamp-cont" >
								<div class="tamp-txt" >
									<span class="txt1" >높이:</span><span class="txt2">123 </span>
								</div>
								<div class="tamp-txt" >
									<span class="txt1" >난이도:</span><span class="txt2">1232 </span>
								</div>
								<div class="tamp-txt" >
									<span class="txt1" >지역:</span><span class="txt2">1233 </span>
								</div>
								<div class="tamp-txt" >
									<span class="txt1" >높이:</span><span class="txt2">1233 </span>
								</div>
							</div>
						</div>
						<div class="tamp-scont" >※이용자 분들의 레벨 그리고 현재 날씨에 따라 추천된 오늘의 추천산입니다.</div>
						<div class="tamp-btn" >
							<a href="cousesee?mid=1">코스보기</a>
							<a href="#">지금날씨보기</a>
						</div>
					</li>
					</c:if>
					<c:if test="${testSubString eq '맑' and levelresult > 4}">
							<li>
						<div class="swiper">
							<div class="swiper-wrapper">
								<div class="swiper-slide"><img src="resources/image/mo.png"></div>
								<div class="swiper-slide"><img src="resources/image/we.png"></div>
								<div class="swiper-slide"><img src="resources/image/aaa.png"></div>
							</div>
							<div class="swiper-pagination"></div>
							<div class="swiper-button-prev"></div>
							<div class="swiper-button-next"></div>						  
						 </div>
					
						<div class="data-tamp" >
							<div class="tamp-title" > 한라산</div>
							<div class="tamp-cont" >
								<div class="tamp-txt" >
									<span class="txt1" >높이:</span><span class="txt2">123 </span>
								</div>
								<div class="tamp-txt" >
									<span class="txt1" >난이도:</span><span class="txt2">1232 </span>
								</div>
								<div class="tamp-txt" >
									<span class="txt1" >지역:</span><span class="txt2">1233 </span>
								</div>
								<div class="tamp-txt" >
									<span class="txt1" >높이:</span><span class="txt2">1233 </span>
								</div>
							</div>
						</div>
						<div class="tamp-scont" >※이용자 분들의 레벨 그리고 현재 날씨에 따라 추천된 오늘의 추천산입니다.</div>
						<div class="tamp-btn" >
							<a href="cousesee?mid=1">코스보기</a>
							<a href="#">지금날씨보기</a>
						</div>
					</li>
					</c:if>
					
					<c:if test="${testSubString eq '구' and levelresult < 5}">
							<li>
						<div class="swiper">
							<div class="swiper-wrapper">
								<div class="swiper-slide"><img src="resources/image/mo.png"></div>
								<div class="swiper-slide"><img src="resources/image/we.png"></div>
								<div class="swiper-slide"><img src="resources/image/aaa.png"></div>
							</div>
							<div class="swiper-pagination"></div>
							<div class="swiper-button-prev"></div>
							<div class="swiper-button-next"></div>						  
						 </div>
					
						<div class="data-tamp" >
							<div class="tamp-title" > 한라산</div>
							<div class="tamp-cont" >
								<div class="tamp-txt" >
									<span class="txt1" >높이:</span><span class="txt2">123 </span>
								</div>
								<div class="tamp-txt" >
									<span class="txt1" >난이도:</span><span class="txt2">1232 </span>
								</div>
								<div class="tamp-txt" >
									<span class="txt1" >지역:</span><span class="txt2">1233 </span>
								</div>
								<div class="tamp-txt" >
									<span class="txt1" >높이:</span><span class="txt2">1233 </span>
								</div>
							</div>
						</div>
						<div class="tamp-scont" >※이용자 분들의 레벨 그리고 현재 날씨에 따라 추천된 오늘의 추천산입니다.</div>
						<div class="tamp-btn" >
							<a href="cousesee?mid=1">코스보기</a>
							<a href="#">지금날씨보기</a>
						</div>
					</li>
					</c:if>
					<c:if test="${testSubString eq '흐' and levelresult < 5}">
						<li>
						<div class="swiper">
							<div class="swiper-wrapper">
								<div class="swiper-slide"><img src="resources/image/mo.png"></div>
								<div class="swiper-slide"><img src="resources/image/we.png"></div>
								<div class="swiper-slide"><img src="resources/image/aaa.png"></div>
							</div>
							<div class="swiper-pagination"></div>
							<div class="swiper-button-prev"></div>
							<div class="swiper-button-next"></div>						  
						 </div>
					
						<div class="data-tamp" >
							<div class="tamp-title" > 한라산</div>
							<div class="tamp-cont" >
								<div class="tamp-txt" >
									<span class="txt1" >높이:</span><span class="txt2">123 </span>
								</div>
								<div class="tamp-txt" >
									<span class="txt1" >난이도:</span><span class="txt2">1232 </span>
								</div>
								<div class="tamp-txt" >
									<span class="txt1" >지역:</span><span class="txt2">1233 </span>
								</div>
								<div class="tamp-txt" >
									<span class="txt1" >높이:</span><span class="txt2">1233 </span>
								</div>
							</div>
						</div>
						<div class="tamp-scont" >※이용자 분들의 레벨 그리고 현재 날씨에 따라 추천된 오늘의 추천산입니다.</div>
						<div class="tamp-btn" >
							<a href="cousesee?mid=1">코스보기</a>
							<a href="#">지금날씨보기</a>
						</div>
					</li>
					</c:if>
					<c:if test="${testSubString eq '비' and levelresult < 5}">
						<li>
						<div class="swiper">
							<div class="swiper-wrapper">
								<div class="swiper-slide"><img src="resources/image/mo.png"></div>
								<div class="swiper-slide"><img src="resources/image/we.png"></div>
								<div class="swiper-slide"><img src="resources/image/aaa.png"></div>
							</div>
							<div class="swiper-pagination"></div>
							<div class="swiper-button-prev"></div>
							<div class="swiper-button-next"></div>						  
						 </div>
					
						<div class="data-tamp" >
							<div class="tamp-title" > 한라산</div>
							<div class="tamp-cont" >
								<div class="tamp-txt" >
									<span class="txt1" >높이:</span><span class="txt2">123 </span>
								</div>
								<div class="tamp-txt" >
									<span class="txt1" >난이도:</span><span class="txt2">1232 </span>
								</div>
								<div class="tamp-txt" >
									<span class="txt1" >지역:</span><span class="txt2">1233 </span>
								</div>
								<div class="tamp-txt" >
									<span class="txt1" >높이:</span><span class="txt2">1233 </span>
								</div>
							</div>
						</div>
						<div class="tamp-scont" >※이용자 분들의 레벨 그리고 현재 날씨에 따라 추천된 오늘의 추천산입니다.</div>
						<div class="tamp-btn" >
							<a href="cousesee?mid=1">코스보기</a>
							<a href="#">지금날씨보기</a>
						</div>
					</li>
					</c:if>
					<c:if test="${testSubString eq '맑' and levelresult < 5}">
							<li>
						<div class="swiper">
							<div class="swiper-wrapper">
								<div class="swiper-slide"><img src="resources/image/mo.png"></div>
								<div class="swiper-slide"><img src="resources/image/we.png"></div>
								<div class="swiper-slide"><img src="resources/image/aaa.png"></div>
							</div>
							<div class="swiper-pagination"></div>
							<div class="swiper-button-prev"></div>
							<div class="swiper-button-next"></div>						  
						 </div>
					
						<div class="data-tamp" >
							<div class="tamp-title" > 한라산</div>
							<div class="tamp-cont" >
								<div class="tamp-txt" >
									<span class="txt1" >높이:</span><span class="txt2">123 </span>
								</div>
								<div class="tamp-txt" >
									<span class="txt1" >난이도:</span><span class="txt2">1232 </span>
								</div>
								<div class="tamp-txt" >
									<span class="txt1" >지역:</span><span class="txt2">1233 </span>
								</div>
								<div class="tamp-txt" >
									<span class="txt1" >높이:</span><span class="txt2">1233 </span>
								</div>
							</div>
						</div>
						<div class="tamp-scont" >※이용자 분들의 레벨 그리고 현재 날씨에 따라 추천된 오늘의 추천산입니다.</div>
						<div class="tamp-btn" >
							<a href="cousesee?mid=1">코스보기</a>
							<a href="#">지금날씨보기</a>
						</div>
					</li>
					</c:if>				
					
				
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
	<jsp:include page="footer.jsp" />
</body>
</html>