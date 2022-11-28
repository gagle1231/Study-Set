<%@page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="model.dao.*" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel=stylesheet href="<c:url value='/css/task.css' />"
	type="text/css">
<title>그룹원별 과제 확인</title>
</head>
<body leftmargin="0" bgcolor="#DFE5DD">
	<br>
	<table style="width: 100%; border-collapse: collapse">
		<tr>
			<td style="text-align: left; width: 130px;"><img
				src="<c:url value='/images/studysetlogo.png'/>" width="100%" /></td>
			<td style="text-align: left"><br> <br> <br>
				<h2>&nbsp;&nbsp;&nbsp;&nbsp;HW이름 - 그룹원 이름</h2></td>
				<td><a href="<c:url value='/group/task/submit' />" class="sbtn">과제제출하기</a></td>
		</tr>
		<tr>
			<td style="height: 30px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		</tr>
		<tr>
			<td colspan="3"><jsp:include page="../menu.jsp" flush="false" /></td>
		</tr>
		<td>
			<hr><div name="back" class="task_back"><br><hr>과제 설명 왈라라라랄</div>
		</td>
		<form>
			<td class="comment_td"><input type="text" name="comment" placeholder="피드백을 남겨주세요."
				class="comment_input">
				<button type="submit" class="comment_submit">↑</button>
				<label class="annonymous"><input type="checkbox" name="ann_box" value="annonymous" class="ann_box">익명</label></td>
		</form>
	</table>
</body>
</html>