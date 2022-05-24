<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page import="mountain.mania.com_DTO.*" %>
    <%@ page import="java.util.*"%>
        <%@ page import="mountain.mania.com_DTO.MDto"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%	
	String year =request.getParameter("year");
	String month =request.getParameter("month");
	String day =request.getParameter("day"); 
	%>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="${path}/resources/css/publicCss.css?after">
<script type="text/javascript" src="${path}/resources/js/jquery-3.6.0.min.js"></script>

<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<jsp:include page="../top.jsp" />
			<div class="conteant" >
				<div class="mypage-nav" >
					<ul>
								<li><h2>동호회</h2></li>
						<li><a href="big_group_list">동호회 리스트 보기 </a></li>
						<li><a href="bg_rank30">상위 30랭킹 </a></li>
						<li><a href="group_recruit">동호회 및 모임 모집글 </a></li>
						<li><a href="bg_Schedule">일정</a></li><!-- 로그인된 동호회장아이디 ${u_id}해야됨  -->
						<li><h2>모임</h2></li>
						<li><a href="small_group_list">모임 리스트 보기</a>	</li>
						<li><a href="sg_Schedule">일정</a><!-- 로그인된 동호회장아이디 ${u_id}해야됨  --></li>
					</ul>
				</div>
				<div class="main-text" >
<form name="schedule_write_form" action="sg_Schedule_write1"  method="post">
	<table>
		<tr>
			<td>산이름 : </td>
			<td>
				<select name="mountain">
					 <c:forEach items="${list}" var="list">
					 <option value="${list.m_id}">${list.m_name}</option>
					 </c:forEach>
				</select>
			</td>
		<td><input type="hidden" name="year" value="<%=year%>">	
			<input type="hidden" name="month" value="<%=month%>">	
			<input type="hidden" name="day" value="<%=day%>"></td>				
		<td><input type="submit" value="코스선택하기"></td>			
		</tr>
	</table>
</form>

<form name="schedule_write_form2" action="sg_Schedule_save" method="post">
	<table>
		<tr> 
			<c:forEach items="${m_name}" var="m">
			<td>산이름 :</td>
			<td>${m.m_name} </td>
			<input type="hidden" name="m_id" value="${m.m_id}">		
			</c:forEach>
		</tr>
		<tr>
			<td>코스이름 : </td>
			<td>
				<select name="course">
					 <c:forEach items="${course}" var="course">
					 <option value="${course.c_id}">${course.c_level}</option>
					 </c:forEach>
				</select>
			</td>	
		</tr>
		<tr>			
			<td>제목 : </td>	
			<td><input type="text" name="title"></td>			
		</tr>
		<tr>			
			<td>내용</td>
			<td><textarea name="content"></textarea></td>				
		</tr>
		<tr>			
			<td>날짜</td>	
			<td>
				<!--<select id="select_year" name="year" onchange="javascript:lastday();"></select> 년
				<select id="select_month" name="month" onchange="javascript:lastday();"></select>월 
				<select id="select_day" name="day"></select>일  -->
				<input type="text" name="year" value="<%=year%>" size="3">년
				<input type="text" name="month" value="<%=month%>" size="3">월
				<input type="text" name="day" value="<%=day%>" size="3">일
			</td>		
		</tr>
		<tr>			
			<td colspan="2"><input type="submit" value="일정 등록하기"></td>			
		</tr>
	</table>
</form>
		
				</div>
			</div>

	
	<jsp:include page="../footer.jsp" />
	<script>
		$(function(){
			$('.table-con').click(function(){
				var popin = $(this).siblings('#pop');
				popin.fadeIn();
				
			})
			$('#pop .pop-bg').click(function(){
				var popout = $(this).parent('#pop');
				$(popout).fadeOut();

			})
				
			
			
		})
	</script>	
</body>
</html>

