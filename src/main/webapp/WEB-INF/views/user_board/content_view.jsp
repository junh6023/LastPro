
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page import="mountain.mania.com_DTO.*" %>
    <%@ page import="java.util.*"%>
     <%
	int b_id=Integer.parseInt(request.getParameter("b_id"));
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
<script type="text/javascript" src="${path}/resources/js/public.js"></script>

<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<jsp:include page="../top.jsp" />
			<div class="conteant" >
				<div class="mypage-nav" >
					<ul>
						<li><h2>게시판</h2></li>
						<li><a href="list">자유게시판</a></li>
						<li><a href="n_list?u_id=Admin">공지게시판</a></li>
						<li><a href="e_list?u_id=Admin">이벤트게시판</a></li>
					</ul>
				</div>
				<div class="main-text" >

    <table width="500" cellpadding="0" cellspacing="0" border="1">
        <form action="modify" method="post">
            <input type="hidden" name="b_id" value="${content_view.b_id}">
            <tr>
                <td> 번호 </td>
                <td> ${content_view.b_id} </td>
            </tr>
            <tr>
                <td> 히트 </td>
                <td> ${content_view.b_hit} </td>
            </tr>
            <tr>
                <td> 이름 </td>
                <td>${content_view.u_id}</td>
            </tr>
            <tr>
                <td> 제목 </td>
                <td> ${content_view.b_title}</td>
            </tr>
            <tr>
                <td> 내용 </td>
                <td > <textarea rows="10" >${content_view.b_content}</textarea></td>
            </tr>
          
             <tr>
                <td> 사진 </td>
                 <td style="font-family: 돋음; font-size: 12"><c:if test="${not empty content_view.b_img}">
               <a href="img/${content_view.b_img}"> ${content_view.b_img} </a>
            </c:if>
            </td>
            </tr>
            <tr >
                <td colspan="2"> <input type="submit" value="수정"> &nbsp;&nbsp; <a href="list">목록보기</a>
                 &nbsp;&nbsp; <a href="delete?b_id=${content_view.b_id}">삭제</a> &nbsp;&nbsp; 
                 <a href="reply_view?b_id=${content_view.b_id}&u_id=test2">답변</a></td>
            </tr>
        </form>
    </table>
				
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
