<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page import="mountain.mania.com_DTO.*" %>
    <%@ page import="java.util.*"%>
    
    <%
	List boardList=(List)request.getAttribute("boardlist");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%
		for(int i=0;i<boardList.size();i++){
			MDto bl=(MDto)boardList.get(i);
	%>
	산이름:<%=bl.getM_name()%>  <a href="mdelete?m_id=<%=bl.getM_id() %>">삭제하기</a><br>
    <img src="./mimg/<%=bl.getM_img()%>" width="200px" height="200px;"> <br>
	
	
	<%} %>
</body>
</html>