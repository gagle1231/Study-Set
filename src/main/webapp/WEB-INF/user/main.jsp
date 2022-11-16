<%@page contentType="text/html; charset=utf-8"%>
<%-- <%@page import="java.util.*, model.*" %> --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
	@SuppressWarnings("unchecked") 
	List<User> userList = (List<User>)request.getAttribute("userList");
	String curUserId = (String)request.getAttribute("curUserId");
--%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel=stylesheet href="<c:url value='/css/user.css' />"
	type="text/css">
<title>StudySet</title>
</head>
<body bgcolor="099987">
	<table style="width: 100%; text-align: center;">
		<tr>
			<td>
				<table style="width: 80%; margin-left:100px">
					<tr height="100px">
						<td style="text-align: left;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img height="100px" src="<c:url value='/images/studysetlogo.png' />" />
						</td>
					</tr>
					<tr>
						<td></td>
					</tr>
					<tr>
						<td style="text-align: left;"><b>${loginmeber.getUserName()}님의 스터디</b></td>
						<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button"
							value="스터디 생성" onClick="login()" class="btn">
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>

</body>
</html>