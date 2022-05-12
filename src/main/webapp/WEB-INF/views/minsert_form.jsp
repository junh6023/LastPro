<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="${path}/resources/js/jquery-3.6.0.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<form action="minsert" method="post" enctype="multipart/form-data"
		>
		산 이름: <select class="m-name" name="m_name">
		<c:forEach var="mountain" items="${mname}">
		<option value="${mountain}">${mountain}</option> 
		</c:forEach>
	    </select><br>  
		산 난이도: <select name="m_level">
					<option value="상">상</option>
					<option value="중">중</option>
					<option value="하">하</option>
					
				</select>
		 <br> 
		산 이미지: <input type="file" name="m_img" multiple> <br>
		산 지역: <input type="text" name="m_area"> <br> 
		산 주차장 사진: <input type="file" name="m_parking" multiple> <br> 
		산 주소: 	
		<select class="m_address" name="m_address">
		<c:forEach var="m_address" items="${maddress}">
		<option value="${m_address}">${m_address}</option> 
		</c:forEach>
		</select><br>
		추천장비이름: <input type="text" name="items_name"> <br> 
		추천장비이미지:<input type="file" name="items_img" multiple> <br> 
		<input type="submit"> <br>
		
	</form>
	<script>
		$(function(){
			$('.m-name').change(function(){
				var index = $(".m-name option").index($(".m-name option:selected"));
				var remove = $(".m_address option").index($(".m_address option:selected"))
				$('.m_address option:eq('+remove+')').removeAttr('selected');
				$('.m_address option:eq('+index+')').attr('selected','selected');
			})
			
		})
	</script>

</body>
</html>