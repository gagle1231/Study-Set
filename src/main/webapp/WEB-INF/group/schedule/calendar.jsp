<%@page contentType="text/html; charset=utf-8"%>
<%@page import="java.util.*, model.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel=stylesheet href="<c:url value='/css/group.css' />"
	type="text/css">
<link rel=stylesheet href="<c:url value='/css/modal.css' />" type="text/css">
<title>StudySet: ${studyGroup.groupName}</title>
<script src="https://cdn.jsdelivr.net/npm/@fullcalendar/core@4.2.0/main.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@fullcalendar/daygrid@4.2.0/main.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@fullcalendar/interaction@4.2.0/main.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/@fullcalendar/core@4.2.0/main.min.css" rel="stylesheet"/>
<style>
.fc-today{
color:white;

}

.fc-head .fc-day-header{color: white; background-color: #3d2d2b; height: 35px;}

.black_bg{
    display: none;
    position: absolute;
    content: "";
    width: 100%;
    height: 107%;
    background-color:rgba(0, 0, 0, 0.5);
    top:0;
    left: 0;
    z-index: 1;
}
</style>
<script type="text/javascript">
function onClick() {
    document.querySelector('.modal_wrap').style.display ='block';
    document.querySelector('.black_bg').style.display ='block';
}   

function offClick() {
    document.querySelector('.modal_wrap').style.display ='none';
    document.querySelector('.black_bg').style.display ='none';
    history.replaceState({}, null, location.pathname);
}


var eventsArray = [ 
	<%
	List<Schedule> slist = (List<Schedule>)request.getAttribute("scheduleList");
	for(Schedule s: slist){%>
	{ date: '<%=s.getDate()%>', title: '<%=s.getTitle()%>', id: '<%=s.getScheduleId()%>', textColor: 'black',
		<%if(s.getImportant()=='Y'){%>
		color : "#F2673B"
		<%}else{%>
		color: "#F2E03B"
		<%}%>
	},
	<%}%>
 ];
 

document.addEventListener('DOMContentLoaded', function() {
   var calendarEl = document.getElementById('calendar');

   var calendar = new FullCalendar.Calendar(calendarEl, {
       height: 700,
       plugins: [ 'dayGrid', 'interaction' ],
       titleFormat: function (date) {
    	      year = date.date.year;
    	      month = date.date.month + 1;

    	      return year + "년 " + month + "월";
    	    },
    	    
    	    lang: 'ko',
    	    firstDay: 1,
    	    navLinks: true,
    	    displayEventTime: false, 
    	    
       dateClick: function(info) {
        onClick();
        calendar.refetchEvents();
       },
     
       eventClick: function(info) {
         alert(info.event.title)
       },
     
       events: function(info, successCallback, failureCallback) {
         successCallback(eventsArray);
       }
   });

   calendar.render();
 });
</script>
</head>
<body leftmargin="0" bgcolor="#DFE5DD">
	<br>
	<table style="width: 100%; border-collapse: collapse">
		<tr>
			<td style="vertical-align: top; text-align: left; width: 130px;">
				<!-- 왼쪽 사이드(로고, 메뉴) 구성 -->
				<table>
					<tr>
						<td>
							<a href="<c:url value='http://localhost:8080/StudySet/user/group/list' />">
							<img src="<c:url value='/images/studysetlogo.png'/>" width="130px" /></a>
                     		<br><br>
                     	</td>
					</tr>
					<tr>
						<td><jsp:include page="../menu.jsp" flush="false" /></td>
					</tr>
				</table>
			</td>
			<td style="vertical-align: top">
				<table style="width: 100%; padding: 20px;">
					<!-- 이 테이블 안에 메인 화면 구성하면 될듯 -->
					<tr>
						<td colspan="2">
							<h2>&nbsp;&nbsp;${studyGroup.groupName}</h2>
							<h4 style="color: gray">
								일정
							</h4>
						</td>
					</tr>
					<tr>
						<td><form name="form" action="<c:url value='/schedule/chart'/>">
						<input type="button" name="newScheduleButton" value="새 스캐줄 생성" onClick="onClick()">
						<div class="black_bg"></div>
						<button  onClick="chkChart(<c:url value='/schedule/chart'/>)">일정 조율표 확인하기</button>
					</form></td>
					</tr>
					<tr>
						<td colspan="2">
							<div id="calendar"></div>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
<div style="display: none; height: 600px;" class="modal_wrap">
		<div class="modal_close" onclick="offClick()">
			<a href="#" onClick="offClick()">close</a>
		</div>
		<div align="center">
			<jsp:include page="addSchedule.jsp"></jsp:include>
		</div>
	</div>
</body>
</html>