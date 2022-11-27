<%@page contentType="text/html; charset=utf-8"%>
<%@page import="java.util.*, model.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel=stylesheet href="<c:url value='/css/group.css' />"
	type="text/css">
<link rel=stylesheet href="<c:url value='/css/main.css' />"
	type="text/css">
<title>StudySet: ${studyGroup.groupName}</title>
<script src="<c:url value='/js/main.css' />"></script>


<style>

</style>
<link
	href="https://cdn.jsdelivr.net/npm/@fullcalendar/core@4.2.0/main.min.css"
	rel="stylesheet" />
</head>
<body leftmargin="0" bgcolor="#DFE5DD">
	<br>
	<table style="width: 100%; border-collapse: collapse">
		<tr>
			<td style="vertical-align: top; text-align: left; width: 130px;">
				<!-- 왼쪽 사이드(로고, 메뉴) 구성 -->
				<table>
					<tr>
						<td><img src="<c:url value='/images/studysetlogo.png'/>"
							width="130px" /><br> <br></td>
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
							<h2 style="color: gray">일정</h2>
						</td>
					</tr>
					<tr><td><form name="form" action="<c:url value='/schedule/chart'/>">
						<input type="button" name="newScheduleButton" value="새 스캐줄 생성" onClick="newSchedule()">
						<input type="submit" name="time" value="일정 조윮표 확인하기">
					</form></td></tr>
					<tr>
						<td colspan="2">
							<div id="calendar"></div>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>

</html>