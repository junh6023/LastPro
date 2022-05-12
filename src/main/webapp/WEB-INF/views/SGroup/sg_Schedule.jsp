<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.*" %>
<%@page import="com.slacademy.last_project.SGDTO.SGSDto"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!--fullcalendar css -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/fullcalendar@5.10.1/main.css">

<script src="https://cdn.jsdelivr.net/npm/fullcalendar@5.10.1/main.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.18.1/moment.min.js"></script>
<!--fullcalendar 언어 설정관련 script -->
<script src="https://cdn.jsdelivr.net/npm/fullcalendar@5.10.1/locales-all.js"></script>
<title>Insert title here</title>
</head>
<body>
<div id='calendar'></div>

<c:set var="check" value="${check}" />
<c:if test="${check eq true}">
<script type="text/javascript">
document.addEventListener('DOMContentLoaded', function() {
	var calendarEl = document.getElementById('calendar');
	var calendar = new FullCalendar.Calendar(calendarEl, {
		initialView : 'dayGridMonth', // 초기 로드 될때 보이는 캘린더 화면(기본 설정: 달)
		locale: 'ko', // 한국어 설정
		headerToolbar : { // 헤더에 표시할 툴 바
			start : 'prev next today',
			center : 'title',
			end : 'dayGridMonth,dayGridWeek,dayGridDay'
		},
		//재우 스케줄은 해당 동호회 멤버들이 볼 수 있도록..
		eventClick: function(title) {
			alert('watch Schedule!');
			var realTitle = title.el.fcSeg.eventRange.def.title;
			var num = title.el.fcSeg.eventRange.def.extendedProps.num;
			var sg_name= title.el.fcSeg.eventRange.def.extendedProps.sg_name;
			alert("realTitle :"+realTitle+"sgsid : "+num);
			location.href="sg_Schedule_check?title="+realTitle+"&&sgs_id="+num+"&&sg_name="+sg_name+"&&u_id=test11";
		},
		titleFormat : function(date) {
			return date.date.year + '년 ' + (parseInt(date.date.month) + 1) + '월';
		},
		//재우 스케줄 입력할수있는 펑션은 모임장이거나 동호회장일때만 가능하도록 할수있도록..
		dateClick: function(start) {
			    alert('add Schedule!');
			    
			    var tempDate =start;
			    var year = tempDate.dateStr.substring(0,4);
			    var month = tempDate.dateStr.substring(5,7);
			    var day = tempDate.dateStr.substring(8,10);
			    alert("year : "+year + "  month : "+month+"  day : "+day);
			    location.href="sg_Schedule_write_view1?year="+year+"&&month="+month+"&&day="+day;
		},
		//initialDate: '2021-07-15', // 초기 날짜 설정 (설정하지 않으면 오늘 날짜가 보인다.)
		selectable : true, // 달력 일자 드래그 설정가능
		droppable : true,
		editable : true,
		nowIndicator: true, // 현재 시간 마크
			events : [ 
	    	    <%ArrayList<SGSDto> calendarList = (ArrayList<SGSDto>)request.getAttribute("schedule");%>
	            <%if (calendarList != null) {%>
	            <%for (SGSDto sgsdto : calendarList) {%>
	            {
	            	num : '<%=sgsdto.getSgs_id() %>',
	            	title : '<%=sgsdto.getSgs_title()  %>',
	            	sg_name : '<%=sgsdto.getSg_name()  %>',
	            	m_name: '<%=sgsdto.getM_name()  %>',
	            	c_name : '<%=sgsdto.getC_name()  %>',
	            	content : '<%=sgsdto.getContent()  %>',
	                start : '<%=sgsdto.getSgs_date() %>',
	                color : '#' + Math.round(Math.random() * 0xffffff).toString(16)
	             },
		<%}
	}%>
					]
					
				});
	calendar.render();
});
</script>
</c:if>


<c:set var="check" value="${check}" />
<c:if test="${check eq false}">
<script type="text/javascript">
document.addEventListener('DOMContentLoaded', function() {
	var calendarEl = document.getElementById('calendar');
	var calendar = new FullCalendar.Calendar(calendarEl, {
		initialView : 'dayGridMonth', // 초기 로드 될때 보이는 캘린더 화면(기본 설정: 달)
		locale: 'ko', // 한국어 설정
		headerToolbar : { // 헤더에 표시할 툴 바
			start : 'prev next today',
			center : 'title',
			end : 'dayGridMonth,dayGridWeek,dayGridDay'
		},
		//재우 스케줄은 해당 동호회 멤버들이 볼 수 있도록..
		eventClick: function(title) {
			alert('watch Schedule!');
			var realTitle = title.el.fcSeg.eventRange.def.title;
			var num = title.el.fcSeg.eventRange.def.extendedProps.num;
			var sg_name= title.el.fcSeg.eventRange.def.extendedProps.sg_name;
			alert("realTitle :"+realTitle+"sgsid : "+num);
			location.href="sg_Schedule_check?title="+realTitle+"&&sgs_id="+num+"&&sg_name="+sg_name+"&&u_id=test11";
		},
		titleFormat : function(date) {
			return date.date.year + '년 ' + (parseInt(date.date.month) + 1) + '월';
		},
		
		//initialDate: '2021-07-15', // 초기 날짜 설정 (설정하지 않으면 오늘 날짜가 보인다.)
		selectable : true, // 달력 일자 드래그 설정가능
		droppable : true,
		editable : true,
		nowIndicator: true, // 현재 시간 마크
			events : [ 
	    	    <%ArrayList<SGSDto> calendarList = (ArrayList<SGSDto>)request.getAttribute("schedule");%>
	            <%if (calendarList != null) {%>
	            <%for (SGSDto sgsdto : calendarList) {%>
	            {
	            	num : '<%=sgsdto.getSgs_id() %>',
	            	title : '<%=sgsdto.getSgs_title()  %>',
	            	sg_name : '<%=sgsdto.getSg_name()  %>',
	            	m_name: '<%=sgsdto.getM_name()  %>',
	            	c_name : '<%=sgsdto.getC_name()  %>',
	            	content : '<%=sgsdto.getContent()  %>',
	                start : '<%=sgsdto.getSgs_date() %>',
	                color : '#' + Math.round(Math.random() * 0xffffff).toString(16)
	             },
		<%}
	}%>
					]
					
				});
	calendar.render();
});
</script>
</c:if>
</body>
</html>