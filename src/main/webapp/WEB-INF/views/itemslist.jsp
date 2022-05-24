<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page import="mountain.mania.com_DTO.*" %>
    <%@ page import="java.util.*"%>

<%
	List boardList=(List)request.getAttribute("boardlist");
	int listcount=((Integer)request.getAttribute("listcount")).intValue();
	int nowpage=((Integer)request.getAttribute("page")).intValue();
	int maxpage=((Integer)request.getAttribute("maxpage")).intValue();
	int startpage=((Integer)request.getAttribute("startpage")).intValue();
	int endpage=((Integer)request.getAttribute("endpage")).intValue();
%>
    
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
	<jsp:include page="top.jsp" />
	<div class="conteant" >
		<div class="mypage-nav" >
			<ul>
				<li><a href="itemslist?actives=item&item=상">상 난이도장비</a></li>
				<li><a href="itemslist?actives=item&item=중">중 난이도장비</a></li>
				<li><a href="itemslist?actives=item&item=하">하 난이도장비</a></li>
				
			</ul>
		</div>
		<div class="main-text" >
			<div class="data table-wrap"  >
				<div class="table" width=50% border="0" cellpadding="0" cellspacing="0">
					<div class="table-tr" align="center" valign="middle" bordercolor="#333333"
						onmouseover="this.style.backgroundColor='F8F8F8'"
						onmouseout="this.style.backgroundColor=''">
					<%
						for(int i=0;i<boardList.size();i++){
							IDto bl=(IDto)boardList.get(i);
					%>	
						<div class="table-box" >
							<input type="hidden" name="<%=bl.getItem_id() %>">
							<div class="table-con" style="font-family:Tahoma;font-size:10pt;"  >
								<div align="center" class="table-img" ><a href="#"><img src="./mimg/<%=bl.getImg()%>"></a></div>
								<div align="center" class="table-text" >
									<a href="#"><%=bl.getItems_name()%></a>
								</div>
							</div>
							<div class="pop" id="pop" >
								<div class="pop-bg" ></div>
								<div class="pop-content" >
									<ul>
										
										<li><div class="img" ><img src="./mimg/<%=bl.getImg()%>" width="100%" height="400px"></div></li>
										<li><h2><p class="txt01" >장비이름: <%=bl.getItems_name() %></p></h2></li>
										<li><h2><p class="txt02" >추천사이트: <%=bl.getSite() %></p></h2><br></li>					
										
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
					<div class="pager"  align=center height=20>
						<div style=font-family:Tahoma;font-size:10pt;>
							<%if(nowpage<=1){ %>
							[이전]&nbsp;
							<%}else{ %>
							<a href="itemslist?page=<%=nowpage-1 %>">[이전]</a>&nbsp;
							<%} %>
							
							<%for(int a=startpage;a<=endpage;a++){
								if(a==nowpage){%>
								[<%=a %>]
								<%}else{ %>
								<a href="itemslist?page=<%=a %>">[<%=a %>]</a>&nbsp;
								<%} %>
							<%} %>
							
							<%if(nowpage>=maxpage){ %>
							[다음]
							<%}else{ %>
							<a href="itemslist?page=<%=nowpage+1 %>">[다음]</a>
							<%} %>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
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