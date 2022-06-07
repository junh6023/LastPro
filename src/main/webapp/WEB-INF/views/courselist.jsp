<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page import="mountain.mania.com_DTO.*" %>
    <%@ page import="java.util.*"%>
    
    <%
	List boardList=(List)request.getAttribute("clist");
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
			CDto bl=(CDto)boardList.get(i);
	%>
	코스레벨:<%=bl.getC_level()%>  <a href="mcourse_delete?c_id=<%=bl.getC_id() %>">삭제하기</a><br>
    <img src="./mimg/<%=bl.getImg()%>" width="200px" height="200px;"> <br>
	
	
	<%} %>
</body>
</html>