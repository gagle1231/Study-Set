<%@page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="model.dao.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel=stylesheet href="<c:url value='/css/task.css' />"
	type="text/css">
<title>과제 제출</title>
<script>
	function gc() {
		if (form1.submitContents.value == "") {
			alert("과제를 제출해주세요.");
			form1.submitContents.focus();
			return false;
		}

		alert("과제가 제출되었습니다.");
		form1.submit();
	}
	document.getElementById('currentDate').value = new Date().toISOString()
			.substring(0, 10);
	document.getElementById('currentTime').value = new Date().toISOString()
			.slice(11, 16);
</script>
<style>
.ssbtn {
	background-color: #79D997;
	width: 78px;
	height: 47px;
	left: 1151px;
	border-radius: 20px;
	text-align: center;
	top: 401px;
}
</style>
</head>
<body leftmargin="0" bgcolor="#DFE5DD">
	<br>
	<table style="width: 100%; border-collapse: collapse">
		<tr>
			<td style="text-align: left; width: 130px;"><img
				src="<c:url value='/images/studysetlogo.png'/>" width="100%" /></td>
			<td style="text-align: left"><br> <br> <br>
				<h2>&nbsp;&nbsp;&nbsp;&nbsp;${task.name}:
					${loginmember.getUserName()}</h2></td>
			<td></td>
			<td style="padding: 14px; padding-top: 97px;"><input
				type="button" onClick="gc()" id="submitBtn" value="생성" class="ssbtn"></input></td>
		</tr>
		<tr>
			<td style="height: 30px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		</tr>
		<tr>
			<td colspan="3"><jsp:include page="../menu.jsp" flush="false" /></td>
		</tr>
	</table>
	<form name="submit" method="POST" autocomplete="off" action="#"
		onsubmit="return false">
		<table>
			<tr>
				<td><div class="task_submit_back">
						<input type='date' id='currentDate' name="submitDate" /> <input
							type='time' id='currentTime' name="submitDate" />
						<hr>
						<textarea name="submitContents" class="submit_text"
							placeholder="과제를 작성하세요."></textarea>
					</div></td>
				<td><input type="button" name="filePath" class="file_btn"
					value="파일첨부"></input></td>
			</tr>
		</table>
	</form>
</body>
</html>