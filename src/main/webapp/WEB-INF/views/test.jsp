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
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=e6006c0dea6c7917bf7fb858c45d5153&libraries=services,clusterer,drawing"></script><!-- ????????? ???????????? ????????? ??????????????? ???????????? -->	
</head>

<body>

	<jsp:include page="top.jsp" />




	<div class="main_text0" id="link_main_text0">
		
		<ul class="icons">
			<li>
				<div class="contents1_bold">?????????</div>
				<div class="icon_img">
					<div class="main-table" >
						<div class="table-ul">
							<%
								for(int i=0;i<boardList.size();i++){
									GDto bl=(GDto)boardList.get(i);
							%>	
							<%String str = bl.getBg_date(); %>
							<div class="table-li">
								<p class="name" ><%=bl.getBg_name() %></p>
								<p class="level">lv.<%=bl.getBg_level() %></p>
								<p class="u-id" ><%=bl.getU_id() %></p>
								<p class="date" ><%=str.substring(0, 11) %></p>
							</div>
							<%} %>
						</div>
					</div>
				 
		
						
						
				</div>
				
				<div class="more"><a href="big_group_list">MORE</a></div>
			</li>
			<li>
				<div class="contents1_bold">?????????</div>
				<div class="icon_img">
				<div class="main-table" >
						<div class="table-ul">
							<%
								for(int i=0;i<SgList.size();i++){
									SGDto sbl=(SGDto)SgList.get(i);
							%>	
							<%String str = sbl.getSg_date(); %>
							<div class="table-li">
								<p class="name" ><%=sbl.getSg_name() %></p>
								
								<p class="u-id" ><%=sbl.getU_id() %></p>
								<p class="date" ><%=str.substring(0, 11) %></p>
							</div>
							<%} %>
						</div>
					</div>
			
			
						
				</div>
				
				<div class="more"><a href="small_group_list">MORE</a></div>
			</li>
			<li>
				<div class="contents1_bold">???????????????</div>
				<div class="icon_img">
				<div class="main-table" >
						<div class="table-ul">
								<%
									for(int i=0;i<rankList.size();i++){
										GDto rank=(GDto)rankList.get(i);
								%>
								<%String str = rank.getBg_date(); %>
							<div class="table-li">
								<p class="name" ><%=rank.getBg_name() %></p>
								<p class="level"><%=rank.getBg_rank() %></p>
								<p class="u-id" ><%=rank.getU_id() %></p>
								<p class="date" ><%=str.substring(0, 11)%></p>
								
							</div>
							<%} %>
						</div>
					</div>
		
				 	
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
				<div><h1>???????????????</h1></div>
				<div id="map" style="width:90%;height:650px;"> </div>
					
<c:forEach var="list" items="${list}" >
<script>
	var mapContainer = document.getElementById('map'), // ????????? ????????? div 
	    mapOption = {
	        center: new kakao.maps.LatLng(36.41998709219585,128.58149633573066), // ????????? ????????????
	        level: 14 // ????????? ?????? ??????
	    };  
	
	// ????????? ???????????????    
	var map = new kakao.maps.Map(mapContainer, mapOption); 
	
	// ??????-?????? ?????? ????????? ???????????????
	var geocoder = new kakao.maps.services.Geocoder();
	
	// ????????? ????????? ???????????????
	geocoder.addressSearch("${list.m_address}", function(result, status) {
	
	    // ??????????????? ????????? ??????????????? 
	     if (status === kakao.maps.services.Status.OK) {
	
	        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
	
	        // ??????????????? ?????? ????????? ????????? ???????????????
	        var marker = new kakao.maps.Marker({
	            map: map,
	            position: coords
	        });
	
	
	     // ????????? ??????????????? ????????? ??????  
	        var content =  '<div class="customoverlay">' +
	        '  <a href="map?m_name=${list.m_name}" target="_blank">' +
	        '    <span class="title">${list.m_name}</span>' +
	        '  </a>' +
	        '</div>';
	        
	     // ????????? ??????????????? ????????? ??????????????? 
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
				<h1>????????? ??????</h1>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
	
</body>
</html>