<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<% List CList=(List)request.getAttribute("list");%>
<%@ page import="mountain.mania.com_DTO.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

		<%
			for(int i=0;i<CList.size();i++){
				CDto bl=(CDto)CList.get(i);
		%>	
			코스레벨:<%=bl.getC_level() %><br>
			<a href="course_detail?c_id='<%=bl.getC_id()%>'">코스별 평균클리어시간 보러가기</a><br>
			<%if(bl.getCleartime()==null){ %>
				아직 클리어 한 사람이 없습니다.
			<%}else{ %>
			
			평균클리어시간: <%=bl.getCleartime()%>
			<%} %><br>
			
			코스이미지:<img src="./mimg/<%=bl.getImg()%>" weight="200px" height="200px"><br><Br>
			
			test
			------------------------------------------------------------------------<br>
			
		
				
		<%} %>
					

</body>
</html>