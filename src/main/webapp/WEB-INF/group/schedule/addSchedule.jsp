<%@page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel=stylesheet href="<c:url value='/css/group.css' />"
	type="text/css">
<title>스캐줄 생성 모달창</title>
<style type="text/css">
.table td {
	width: 100%;
}

.inputField {
	background-color: rgb(187, 244, 227);
	color: black;
	font-size: 13px;
	border: 0px;
	border-radius: 5px;
	text-align: center;
}

.inputField2 {
	background-color: rgb(187, 244, 220);
	color: black;
	font-size: 13px;
	border: 0px;
	border-radius: 5px;
	text-align: center;
}
#title {
	background-color: gray;
	color: black;
	font-size: 22px;
	border: 0px;
	border-radius: 5px;
}
</style>
</head>
<body>
	<form name="addSchedule" method="POST"
		action="<c:url value = '/schedule/calendar/detail' /> ">
		<p>
		<h2>일정 추가하기</h2>
		</p>
		<table style="width: 80%;" class="table">
			<tr>
				<td style="text-align: center;"><input type="text"
					placeholder="일정 제목" name="sTitle" id="title" maxlength="20"> &nbsp;
					&nbsp;중요 일정<input type="checkbox" name="importance" value="1"><br></td>
			</tr>
			<tr>
				<td><br>
				<h4>날짜</h4> <input type="date" name="sDate" class="inputField2" style="width: 500px; height: 30px;" 
				<c:if test='${param.date ne null}'>value="{param.date}"</c:if>></td>
			</tr>
			<tr>
				<td>
					<h4>시간</h4> <input class="inputField" type="time" name="startTime" style="width: 200px; height: 30px;">
					~ <input type="time" class="inputField" name="endTime" style="width: 200px; height: 30px;">
				</td>
			</tr>
			<tr>
				<td>
					<h4>장소</h4> <input type="text" name="location" class="inputField"
					style="width: 500px; height: 30px;">
				</td>
			</tr>
			<tr>
				<td><br>
				<h4>일정 내용</h4> <textarea class="inputField2" name="description"
						maxlength="80" style="width: 100%; height: 100px;"></textarea></td>
			</tr>
			<tr>
				<td align="center"><button onClick="submit()">생성</button></td>
			</tr>
		</table>
	</form>
</body>
</html>