<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="${path}/resources/css/style.css">
<link rel="stylesheet" href="${path}/resources/css/publicCss.css?after">
<script type="text/javascript" src="${path}/resources/js/public.js"></script>

</head>
<body>

	<jsp:include page="../top.jsp" />
	
	<div class="conteant" >
				<div class="mypage-nav" >
					<ul>
						<li><a href="Repetition_QnA">자주 묻는 질문</a></li>
						<li><a href="QnA_list">문의하기</a></li>
						
					</ul>
				</div>
				<div class="main-text" >
<c:set  var ="u_id" value="${u_id}"/>
<c:set  var ="content_view" value="${content_view}"/>
<c:if test="${u_id ne 'Admin'}">
<c:choose >
<c:when test="${u_id ne content_view.u_id}">
	<script type="text/javascript">
	alert("해당 게시물을 읽을 권한이 없습니다.")
	window.location.href = 'QnA_list';
	</script>
</c:when>
</c:choose>
</c:if>

    <table width="500" cellpadding="0" cellspacing="0" border="1">
        <form action="QnA_modify" method="post">
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
                <td> 글쓴이 </td>
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
          
            <tr >
                <td colspan="2"> 
                 
                <input type="submit" value="수정">
                &nbsp;&nbsp; 
                <a href="QnA_list">목록보기</a>                
                &nbsp;&nbsp; 
                 <a href="QnA_delete?b_id=${content_view.b_id}">삭제</a> &nbsp;&nbsp; 
                 <c:if test="${u_id eq 'Admin'}">
                 <a href="QnA_reply_view?b_id=${content_view.b_id}">답변</a>
                 </c:if>
                 </td>
            </tr>
        </form>
    </table>
				</div>
			</div>
	
	<jsp:include page="../footer.jsp" />
</body>
</html>

