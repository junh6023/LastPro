<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${usercheck eq 'no'}">
<script>
alert("패스워드가 다릅니다.")
location.href="admin";
</script>
</c:if>
<a href="mname_form">산정보추가</a> <br>
<a href="mdelete_form">산정보삭제</a> <br>
<a href="items_addform">산장비 추가</a> <br>
<a href="idelete_form">산장비 삭제</a> <br>
<a href="mcourse_form">산 개별 코스 추가</a> <br>
</body>
</html>