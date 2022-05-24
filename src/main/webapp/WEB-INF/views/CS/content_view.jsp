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
    <table width="500" cellpadding="0" cellspacing="0" border="1">
        <form action="cs_modify" method="post">
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
                <td> 관리자 </td>
                <td>${content_view.u_id}</td>
            </tr>
            <tr>
                <td> 질의내용 </td>
                <td> ${content_view.b_title}</td>
            </tr>
            <tr>
                <td> 답변 </td>
                <td > <textarea rows="10" >${content_view.b_content}</textarea></td>
            </tr>
          
            </tr>
            <tr >
                <td colspan="2"> 
                 <c:if test="${u_id eq 'Admin'}">
                <input type="submit" value="수정">
                </c:if> &nbsp;&nbsp; 
                <a href="Repetition_QnA">목록보기</a>
                
                 <c:if test="${u_id eq 'Admin'}">
                 &nbsp;&nbsp; <a href="cs_delete?b_id=${content_view.b_id}">삭제</a> &nbsp;&nbsp; 
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


