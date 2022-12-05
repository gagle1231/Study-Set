<%@page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="model.dao.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel=stylesheet href="<c:url value='/css/task.css' />"
	type="text/css">
<link rel=stylesheet href="<c:url value='/css/modal.css' />"
	type="text/css">
<script>
	function gc() {
		alert("댓글생성");
		form1.submit();
	}
</script>
<style>
.comm {
	width: 1066px;
	height: 52px;
	background: rgba(179, 224, 143, 0.4);
	border-radius: 10px;
	height: 52px;
}

.comm_con {
	position: relative;
    width: 1019px;
    left: 2%;
    top: 19%;
    background: #FFFFFF;
    border-radius: 8px;
    height: 35px;
}
</style>
<title>${task.name}_${userName}과제</title>
</head>
<body leftmargin="0" bgcolor="#DFE5DD">
	<br>
	<table style="width: 100%; border-collapse: collapse">
		<tr>
			<td style="text-align: left; width: 130px;">
				<a href="<c:url value='http://localhost:8080/StudySet/user/group/list' />">
				<img
				src="<c:url value='/images/studysetlogo.png'/>" width="100%" /></td>
			<td style="text-align: left"><br> <br> <br>
				<h2>&nbsp;&nbsp;&nbsp;&nbsp;${task.name}_${userName}</h2></td>
			<td>
		</tr>
		<tr>
			<td style="height: 30px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		</tr>
		<tr>
			<td colspan="3"><jsp:include page="../menu.jsp" flush="false" /></td>
		</tr>
	</table>
	<table>
		<tr>
			<td>
				<hr>
				<div class="task_back">
					<br> <br>&nbsp;&nbsp;${submit.submitDate}
					<hr>
					<br>&nbsp;&nbsp;${submit.submitContents}
				</div>
			</td>
		</tr>
	</table>
	<div style="position: absolute; width: 1072px; left: 15%; top: 83%;">
		<table>
			<c:forEach var="comment" items="${list}">
				<tr valign="top">
					<td class="comm"><div class="comm_con">&nbsp;&nbsp;${comment.userId}&nbsp;|&nbsp;&nbsp;${comment.commentContents}</div></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<form name="form1" method="POST" class="comment_td" style="top: 108%;"
		action="<c:url value='/group/task/submit/comment'><c:param name="userName" value="${loginmember.getUserName()}" /></c:url>">
		<input type="text" name="commentContents" placeholder="피드백을 남겨주세요."
			class="comment_input"><label class="annonymous"> <input
			type="checkbox" name="annonymous" value="1" class="ann_box">
			<input type="checkbox" name="annonymous" value="N" class="ann_box">익명
		</label> <input type="button" onClick="gc()" class="comment_submit" value="↑">
	</form>
</body>
</html>