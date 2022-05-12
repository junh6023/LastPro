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
			IDto bl=(IDto)boardList.get(i);
	%>
	아이템이름: <%=bl.getItems_name()%></a> <br>
	<a href="idelete?item_id=<%=bl.getItem_id() %>">삭제하기</a>
	산 사진: <img src="./mimg/<%=bl.getImg()%>" width="200px" height="200px;"> <br>
	
	
	<%} %>
</body>
</html>