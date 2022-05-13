<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>활동내역 추가폼</title>
</head>
<body>
<form action="bg_active_save" method="post"  >
<input type="hidden" name="u_id" value="test5">
<table>
<tr>
<td>동호회:</td><td><input type="text" name="bg_id"></td>
</tr>
<tr>
<td>산:</td><td><input type="text" name="m_id"></td>
</tr>
<tr>
<td>코스:</td><td><input type="text" name="c_id"></td>
</tr>
<tr>
<td>경험치:</td><td><input type="text" name="bg_experience"></td>
</tr>
<tr>
<td>등정횟수:</td><td><input type="text" name="climb"></td>
</tr>
<tr>
<td colspan="2"><input type="submit" value="입력"></td>
</tr>

</table>
</form>
</body>
</html>