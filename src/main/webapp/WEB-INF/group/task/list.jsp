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
<link rel=stylesheet href="<c:url value='/css/modal.css' />"
	type="text/css">
<script>
	window.onload = function() {

		function onClick() {
			document.querySelector('.modal_wrap').style.display = 'block';
		}
		function offClick() {
			document.querySelector('.modal_wrap').style.display = 'none';
		}

		document.getElementById('modal_btn').addEventListener('click', onClick);
		document.querySelector('.modal_close').addEventListener('click',
				offClick);
	};
</script>
</head>
<body leftmargin="0" bgcolor="#DFE5DD">
	<br>
	<table style="width: 100%; border-collapse: collapse">
		<tr>
			<td style="vertical-align: top; text-align: left; width: 130px;">
				<!-- 왼쪽 사이드(로고, 메뉴) 구성 -->
				<table>
					<tr>
						<td><a
							href="<c:url value='http://localhost:8080/StudySet/user/group/list' />">
								<img src="<c:url value='/images/studysetlogo.png'/>"
								width="130px" />
						</a> <br> <br></td>
					</tr>
					<tr>
						<td><jsp:include page="../menu.jsp" flush="false" /></td>
					</tr>
				</table>
			</td>
			<td style="vertical-align: top">
				<table style="width: 100%; padding: 20px;">
					<!-- 이 테이블 안에 메인 화면 구성하면 될듯 -->
					<tr>
						<td colspan="2">
							<h2>&nbsp;&nbsp;${studyGroup.groupName}</h2>
							<h2 style="color: gray">&nbsp; 과제</h2>
						</td>
					</tr>
					<tr>
						<td></td>
						<td><div style="float: right; width: 20%;">
								<p id="modal_btn" class="btn">
									<a href="#modal1" rel="modal:open" type="button"
										style="color: white;">과제 생성</a>
								</p>
							</div></td>
					</tr>
					<tr text-align="ceneter">
						<td class="back">
							<table>
								<c:forEach var="task" items="${taskList}">
									<tr>
										<td style="height: 10px" class="contents"><a href="<c:url value='/group/task/detail'>
											<c:param name="groupId" value="${studyGroup.groupId}"/></c:url>">&nbsp;&nbsp;${task.taskName}</a>
										</td>
									</tr>
								</c:forEach>
							</table>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	<div style="display: none; height: 460px;" class="modal_wrap">
		<!--스터디생성 모달창 영역-->
		<div class="modal_close">
			<a href="#">close</a>
		</div>
		<div align="center">
			<jsp:include page="create.jsp"></jsp:include>
		</div>
	</div>
</body>
</html>