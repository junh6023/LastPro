<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="items_add"  method="post" enctype="multipart/form-data">
장비이름 : <input type="text" name="items_name"><br>
장비사진 : <input type="file" name="img"><br>
판매사이트 : <input type="text" size="30" name="site"><br>
<input type="submit">
</form>
</body>
</html>