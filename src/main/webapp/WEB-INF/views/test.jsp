<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page import="com.slacademy.last_project.GDTO.*" %>
    <%@ page import="mountain.mania.com_DTO.*" %>
    <%@ page import="java.util.*"%>
    <%@ page import="com.slacademy.last_project.SGDTO.*" %>
    <%
    List boardList=(List)request.getAttribute("list6"); 
    List SgList=(List)request.getAttribute("slist6"); 
    List rankList=(List)request.getAttribute("bg_rank"); 
    %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="${path}/resources/css/style.css">
<link rel="stylesheet" href="${path}/resources/css/publicCss.css?after">
<script type="text/javascript" src="${path}/resources/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="${path}/resources/js/public.js"></script>

<style>
    .customoverlay {position:relative;bottom:85px;border-radius:6px;border: 1px solid #ccc;border-bottom:2px solid #ddd;float:left;}
.customoverlay:nth-of-type(n) {border:0; box-shadow:0px 1px 2px #888;}
.customoverlay a {display:block;text-decoration:none;color:#000;text-align:center;border-radius:6px;font-size:14px;font-weight:bold;overflow:hidden;background: #d95050;background: #d95050 url(https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/arrow_white.png) no-repeat right 14px center;}
.customoverlay .title {display:block;text-align:center;background:#fff;margin-right:35px;padding:10px 15px;font-size:14px;font-weight:bold;}
.customoverlay:after {content:'';position:absolute;margin-left:-12px;left:50%;bottom:-12px;width:22px;height:12px;background:url('https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/vertex_white.png')}

</style>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=e6006c0dea6c7917bf7fb858c45d5153&libraries=services,clusterer,drawing"></script><!-- 서비스 클러스터 드로잉 라이브러리 불러오기 -->	
</head>

<body>

	<jsp:include page="top.jsp" />




	<div class="main_text0" id="link_main_text0">
		
		<ul class="icons">
			<li>
				<div class="contents1_bold">대모임</div>
				<div class="icon_img">
				 	<table  border="1" align="center">
						<tr>
							<th>번호</th>
							<th>동호회 명</th>
							<th>동호회 경험치</th>
							<th>동호회 레벨</th>
							<th>동호회 장</th>
							<th>개설 날짜</th>
					
						</tr>
					<%
						for(int i=0;i<boardList.size();i++){
							GDto bl=(GDto)boardList.get(i);
					%>	
						<tr>
							<td><%=bl.getBg_id() %></td>
							<td><%=bl.getBg_name() %></td>
							<td><%=bl.getBg_experience() %></td>
							<td><%=bl.getBg_level() %></td>
							<td><%=bl.getU_id() %></td>
							<td><%=bl.getBg_date() %></td>
						</tr>
					<!--  	<c:forEach items="${list6}" var="list6" >
						<tr>
							<td>${list6.bg_id}</td>
							<td><a href="big_group_content?bg_id=${list6.bg_id}">${list6.bg_name}</a></td>
							<td>${list6.bg_experience}</td>
							<td>${list6.bg_level}</td>
							<td>${list6.u_id}</td>
							<td>${list6.bg_date}</td>
						</tr>
						</c:forEach>
						-->
						<%} %>
						</table>
						
				</div>
				
				<div class="more"><a href="big_group_list">MORE</a></div>
			</li>
			<li>
				<div class="contents1_bold">소모임</div>
				<div class="icon_img">
				<table  border="1" align="center">
						<tr>
							<th>번호</th>
							<th>동호회 명</th>
							<th>동호회 장</th>
							<th>개설 날짜</th>
					
						</tr>
					<%
						for(int i=0;i<SgList.size();i++){
							SGDto sbl=(SGDto)SgList.get(i);
					%>	
						<tr>
							<td><%=sbl.getSg_id() %></td>
							<td><%=sbl.getSg_name() %></td>
							<td><%=sbl.getU_id() %></td>
							<td><%=sbl.getSg_date() %></td>
							
						</tr>
					
						<%} %>
						</table>
						
				</div>
				
				<div class="more"><a href="small_group_list">MORE</a></div>
			</li>
			<li>
				<div class="contents1_bold">실시간랭킹</div>
				<div class="icon_img">
				 	<table  border="1" align="center">
						<tr>
							<td>동호회 랭킹</td>
							<td>동호회 명</td>
							<td>동호회 경험치</td>
							<td>동호회 레벨</td>
							<td>동회회 장</td>
							<td>개설 날짜</td>
					
						</tr>
					<%
						for(int i=0;i<rankList.size();i++){
							GDto rank=(GDto)rankList.get(i);
					%>	
						<tr>
							<td><%=rank.getBg_rank() %></td>
							<td><%=rank.getBg_name() %></td>
							<td><%=rank.getBg_experience() %></td>
							<td><%=rank.getBg_level() %></td>
							<td><%=rank.getU_id() %></td>
							<td><%=rank.getBg_date() %></td>
							
						</tr>
					
						<%} %>
						</table>
				</div>
				
				<div class="more"><a href="bg_rank30">MORE</a></div>
			</li>

		</ul>
		
	</div>
	<!--main_text0 end-->
	<div class="main_text1" id="link_main_text1">
		<h1>SERVICE</h1>
		<div class="contents1"></div>
		<div class="service">
			<div class="food_photo">
				<div><h1>전국산지도</h1></div>
				<div id="map" style="width:90%;height:650px;"> </div>
					
<c:forEach var="list" items="${list}" >
<script>
	var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	    mapOption = {
	        center: new kakao.maps.LatLng(36.41998709219585,128.58149633573066), // 지도의 중심좌표
	        level: 14 // 지도의 확대 레벨
	    };  
	
	// 지도를 생성합니다    
	var map = new kakao.maps.Map(mapContainer, mapOption); 
	
	// 주소-좌표 변환 객체를 생성합니다
	var geocoder = new kakao.maps.services.Geocoder();
	
	// 주소로 좌표를 검색합니다
	geocoder.addressSearch("${list.m_address}", function(result, status) {
	
	    // 정상적으로 검색이 완료됐으면 
	     if (status === kakao.maps.services.Status.OK) {
	
	        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
	
	        // 결과값으로 받은 위치를 마커로 표시합니다
	        var marker = new kakao.maps.Marker({
	            map: map,
	            position: coords
	        });
	
	
	     // 커스텀 오버레이에 표출될 내용  
	        var content =  '<div class="customoverlay">' +
	        '  <a href="map?m_name=${list.m_name}" target="_blank">' +
	        '    <span class="title">${list.m_name}</span>' +
	        '  </a>' +
	        '</div>';
	        
	     // 커스텀 오버레이가 표시될 위치입니다 
            var overlay = new kakao.maps.CustomOverlay({
                content: content,
                map: map,
                position: marker.getPosition()       
            });


	    } 
	}); 
	
	
</script>
</c:forEach>

			</div>
			<div class="contents2">
				<h1>오늘의 뉴스</h1>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
	
</body>
</html>