<%@page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel=stylesheet href="<c:url value='/css/memo.css' />"
	type="text/css">
<title>진행상황-상세</title>
</head>
<body leftmargin="0" bgcolor="#DFE5DD">
	<br>
	<table style="width: 100%; border-collapse: collapse">
		<tr>
			<td rowspan='2' style="text-align: left; width: 130px;"><img
				src="<c:url value='/images/studysetlogo.png'/>" width="100%" /></td>
			<td style="text-align: left; vertical-align: top;"><br> <br>
				<br> &nbsp;&nbsp;&nbsp;&nbsp;스터디</td>
		</tr>
		<tr>
			<td>&nbsp;&nbsp;&nbsp;&nbsp;진행상황</td>
		</tr>
		<tr>
			<td colspan="3"><jsp:include page="../menu.jsp" flush="false" /></td>
		</tr>
	</table>
</body>
</html>