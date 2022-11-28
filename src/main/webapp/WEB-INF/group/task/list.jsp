<%@page contentType="text/html; charset=utf-8"%>
<%@page import="java.util.*, model.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel=stylesheet href="<c:url value='/css/task.css' />"
	type="text/css">
<title>StudySet: ${studyGroup.groupName}_과제 홈</title>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.0.0/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.css" />
</head>
<body leftmargin="0" bgcolor="#DFE5DD">
	<br>
	<table style="width: 100%; border-collapse: collapse">
		<tr>
			<td rowspan='2' style="text-align: left; width: 130px;">							
				<a href="<c:url value='http://localhost:8080/StudySet/user/group/list' />">
				<img src="<c:url value='/images/studysetlogo.png'/>" width="130px" /></a></td>
			<td class="title" style="text-align: left; vertical-align: top;"><br>
				<br> <br> &nbsp;&nbsp;&nbsp;&nbsp;${studyGroup.groupName}
				스터디</td>
		</tr>
		<tr>
			<td class="title">&nbsp;&nbsp;&nbsp;&nbsp;과제</td>
			<td><div style="float: right; width: 20%;">
					<a href="#modal1" rel="modal:open" type="button" class="btn">과제생성</a>
					<div id="modal1" class="modal" style="text-align:center;">
					<h2>과제 생성</h2>
						<p>과제 이름</p>
						<input class="task_title" type="text" placeholder="과제 이름을 작성해주세요."><br>
						<p>과제 설명</p>
						<textarea style="width: 80%; height: 100px;"
							placeholder="과제 설명을 작성해주세요." class="task_des"></textarea>
						<br><br><br><br><br>
						<p>생성 일자</p>
						<input class="startDate" type="date">&nbsp;<input class="startTime" type="time"><br><br>
						<p>마감 일자</p>
						<input class="endDate" type="date">&nbsp;<input class="endTime" type="time"><br>
						<input type="submit" value="제출" class="btn2">
						<a href="#" rel="modal:close" class="btn3">닫기</a>
					</div>
				</div></td>
		</tr>
		<tr>
			<td style="height: 30px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		</tr>
		<tr>
			<td colspan="3"><jsp:include page="../menu.jsp" flush="false" /></td>
		</tr>
		<tr>
			<td class="back">
				<table>
					<c:forEach var="task" items="${taskList}">
						<tr>
							<td style="height: 10px" class="contents"><a
								href="<c:url value='/group/task/detail'>
						<c:param name="groupId" value="${studyGroup.groupId}"/></c:url>">&nbsp;&nbsp;${task.taskName}</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</td>
		</tr>
	</table>
	<a href="<c:url value='/group/task/detail' />">상세과제</a>
</body>
</html>