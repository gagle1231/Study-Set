<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>스캐줄 상세보기</title>
</head>
<body>
	<form name="editSchedulefrm" method="POST"
		action="<c:url value = '/schedule/calendar/detail' /> ">
		<p>
		<h2>일정 수정하기</h2>
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