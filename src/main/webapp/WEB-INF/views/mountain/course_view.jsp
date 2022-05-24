<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page import="mountain.mania.com_DTO.*" %>
    <%@ page import="java.util.*"%>

<% List CList=(List)request.getAttribute("list");%>
   
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
				<li><a href="mountaininfo?actives=mountaininfo">내레벨 추천산 보기</a></li>
				<li><a href="search_weather?area=60 127&actives=weather">날씨체크하러가기</a></li>
			</ul>
		</div>
		<div class="main-text" >
			<div class="data table-wrap"  >
				<div class="table" width=50% border="0" cellpadding="0" cellspacing="0">
					<div class="table-tr" align="center" valign="middle" bordercolor="#333333"
						onmouseover="this.style.backgroundColor='F8F8F8'"
						onmouseout="this.style.backgroundColor=''">
							<%
								for(int i=0;i<CList.size();i++){
									CDto bls=(CDto)CList.get(i);
							%>	
						<div class="table-box" >
							<input type="hidden" name="<%=bls.getC_id() %>">
							<div class="table-con" style="font-family:Tahoma;font-size:10pt;"  >
								<div align="center" class="table-img" ><a href="#"><img src="./mimg/<%=bls.getImg()%>"></a></div>
								<div align="center" class="table-text" >
									<a href="#"><%=bls.getC_level()%></a>
								</div>
							</div>
							<div class="pop" id="pop" >
								<div class="pop-bg" ></div>
								<div class="pop-content" >
									<ul>
										
										<li><div class="img" ><img src="./mimg/<%=bls.getImg()%>" width="100%" height="400px"></div></li>
									
										<li><h2><p class="txt02">코스 난이도: <%=bls.getC_level() %></p></h2></li>		
										<li><h2><a href="course_detail?c_id='<%=bls.getC_id()%>'">코스별 평균클리어시간 보러가기</a></h2></li>
							
									</ul>
								</div>
							</div>
						</div>
						<!-- 
						<td style="font-family:Tahoma;font-size:10pt;">
							
						</td>
						 -->
									
					<%} %>
					</div>
				
				</div>
			</div>
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