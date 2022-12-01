<%@page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="model.dao.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel=stylesheet href="<c:url value='/css/task.css' />"
	type="text/css">
<title>과제 상세</title>
</head>
<body leftmargin="0" bgcolor="#DFE5DD">
	<br>
	<table style="width: 100%; border-collapse: collapse">
		<tr>
			<td style="text-align: left; width: 130px;"><img
				src="<c:url value='/images/studysetlogo.png'/>" width="100%" /></td>
			<td style="text-align: left"><br> <br> <br>
				<h2>&nbsp;&nbsp;&nbsp;&nbsp;${task.name}</h2></td>
		</tr>
		<tr>
			<td style="height: 30px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		</tr>
		<tr>
			<td colspan="3"><jsp:include page="../menu.jsp" flush="false" /></td>
		</tr>
		<tr>
			<td><div class="descript_back">
					<br>&nbsp;&nbsp;${task.startDate}
					<hr>
					<br>&nbsp;&nbsp;${task.description}
				</div>
		</tr></table>
		<div class="descript_back2">
			<table
				style="border-collapse: collapse; border-spacing: 0; width: 90%; margin-left: 58px; margin-top: 15px;">
				<c:forEach var="member" items="${list}">
					<tr valign="top">
						<td class="contents2" style="margin-bottom: 10px;"><a
							href=<c:url value='/group/task/view'/>>&nbsp;&nbsp;${member.userName}</a></td>
						<td class="contentsTime">과제 생성 시간</td>
						<td class="contentsTime">제출 시간</td>
						<td class="contentsTime2"><a type="button" class="submitBtn"
						href="<c:url value='/group/task/submit'/>">제출</a></td>
					</tr>
					<tr style="height: 10px;">
						<td></td>
					</tr>
				</c:forEach>
			</table>
			
		</div>
	<a href="<c:url value='/group/task/view' />">제출한 과제 보기</a>
</body>
</html>