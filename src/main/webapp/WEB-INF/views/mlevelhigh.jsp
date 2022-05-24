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
    <%String getlevel= request.getParameter("m_level"); %>
   
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
				<li><a href="levelhigh?m_level=상&actives=mountaininfo" <%if(getlevel.equals("상")){ %>class="active"<%} %>>상 난이도 </a></li>
				<li><a href="levelhigh?m_level=중&actives=mountaininfo" <%if(getlevel.equals("중")){ %>class="active"<%} %>>중 난이도 </a></li>
				<li><a href="levelhigh?m_level=하&actives=mountaininfo" <%if(getlevel.equals("하")){ %>class="active"<%} %>>하 난이도 </a></li>
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
							MDto bl=(MDto)boardList.get(i);
					%>	
						<div class="table-box" >
							<input type="hidden" name="<%=bl.getM_id() %>">
							<div class="table-con" style="font-family:Tahoma;font-size:10pt;"  >
								<div align="center" class="table-img" ><a href="#"><img src="./mimg/<%=bl.getM_img()%>"></a></div>
								<div align="center" class="table-text" >
									<a href="#"><%=bl.getM_name()%></a>
								</div>
							</div>
							<div class="pop" id="pop" >
								<div class="pop-bg" ></div>
								<div class="pop-content" >
									<ul>
										
										<li><div class="img" ><img src="./mimg/<%=bl.getM_img()%>" width="100%" height="400px"></div></li>
										<li><h2><p class="txt01" >산이름: <%=bl.getM_name() %></p></h2></li>
										<li><h2><p class="txt02" >산 난이도: <%=bl.getM_level() %></p></h2><br></li>		
										<h3><a href="courseview?m_id='<%=bl.getM_id()%>'" >산 코스보기 Click!</a></h3>	
										
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
							<a href="levelhigh?page=<%=nowpage-1 %>&m_level=<%=getlevel%>">[이전]</a>&nbsp;
							<%} %>
							
							<%for(int a=startpage;a<=endpage;a++){
								if(a==nowpage){%>
								[<%=a %>]
								<%}else{ %>
								<a href="levelhigh?page=<%=a%>&m_level=<%=getlevel%>">[<%=a %>]</a>&nbsp;
								<%} %>
							<%} %>
							
							<%if(nowpage>=maxpage){ %>
							[다음]
							<%}else{ %>
							<a href="levelhigh?page=<%=nowpage+1 %>&m_level=<%=getlevel%>">[다음]</a>
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