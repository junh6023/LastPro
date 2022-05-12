<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="mcourse_add" method="post" enctype="multipart/form-data">
코스이름: 
코스레벨: <select name="course_lev">
			<option value="상">상</option>
			<option value="중">중</option>
			<option value="중">하</option>
		  </select><br>
휠체어 유무: <select name="wheelchair">
			<option value="유">유</option>
			<option value="무">무</option>
		  </select><br>
클리어시간: <input type="text" name="clear_time"><br>
운영시간: <input type="text" name="operating"><br>
코스이미지: <input type="file" name="img"><Br>

<input type="submit">
</form>
</body>
</html>