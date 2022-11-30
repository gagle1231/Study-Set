<%@page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<style type="text/css" media="screen">
#our_table {
	
}

th {
	width: 140px;
	background-color: #ccc;
}

#our_table td {
	width: 140px;
	height: 20px;
	text-align: center;
	vertical-align: middle;
}

table td.highlighted {
	background-color: rgba(0, 0, 0, 0.1);
}
</style>
</head>
<body leftmargin="0" bgcolor="#DFE5DD">
	<br>
	<table style="width: 100%; height: 100%; border-collapse: collapse">
		<tr>
			<td style="vertical-align: top; text-align: left; width: 130px;">
				<!-- 왼쪽 사이드(로고, 메뉴) 구성 -->
				<table>
					<tr>
						<td><a href="<c:url value='http://localhost:8080/StudySet/user/group/list' />"><img src="<c:url value='/images/studysetlogo.png'/>"
							width="130px" /></a><br> <br></td>
					</tr>
					<tr>
						<td><jsp:include page="../menu.jsp" flush="false" /></td>
					</tr>
				</table>
			</td>
			<td style="vertical-align: top">
				<table style="width: 100%; height: 100%; padding: 60px;">
					<!-- 이 테이블 안에 메인 화면 구성하면 될듯 -->
					<tr>
						<td colspan="2">
							<h1>${studyGroup.groupName}</h1>
							<h2 style="color: gray">일정</h2>
						</td>
					</tr>
					<tr><td>
						<form name="createSchedule" action="<c:url value=''/>"/>
							<input type="text" name="scheduleTitle">
							
						</form>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>