<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><!-- jstl사용하려면 임포트 필수-->
<%@ page import="java.lang.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>활동내역 보여주기</title>
</head>
<body>
<c:set  value="${climb}" var="climb"/>
총 등정횟수 : ${climb}

<table  border="1" align="center">
	<tr>
		<td>동호회</td>
		<td>산</td>
		<td>코스</td>

	</tr>

	<c:forEach items="${list}" var="list" >
	<tr>
		<td>${list.sg_name}</td> 
		<td>${list.m_name}</td> 
		<td>${list.c_level}</td> 
	
	</tr>
	</c:forEach>
</table>
</body>
</html>