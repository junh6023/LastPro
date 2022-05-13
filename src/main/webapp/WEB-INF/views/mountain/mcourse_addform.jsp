<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%int m_id = Integer.parseInt(request.getParameter("m_id")); %>
<body>

<%=m_id%>
<form action="mcourse_add" method="post" enctype="multipart/form-data">


<input type="hidden" name="m_id" value="<%=m_id%>">
코스레벨: <select name="course_lev">
			<option value="상">상</option>
			<option value="중">중</option>
			<option value="중">하</option>
		  </select><br>



코스이미지: <input type="file" name="img"><Br>

<input type="submit">
</form>
</body>
</html>