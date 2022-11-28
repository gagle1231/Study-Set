<%@page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="model.dao.*" %>
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
				<h2>&nbsp;&nbsp;&nbsp;&nbsp;HW이름</h2></td>
		</tr>
		<tr>
			<td style="height: 30px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		</tr>
		<tr>
			<td colspan="3"><jsp:include page="../menu.jsp" flush="false" /></td>
		</tr>
		<td>
			<div name="back" class="descript_back">과제 설명 왈라라라랄</div>
		</td>
	</table>
	<a href="<c:url value='/group/task/view' />">제출한 과제 보기</a>
</body>
</html>