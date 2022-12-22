<%@page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel=stylesheet href="<c:url value='/css/memo.css' />"
	type="text/css">
<link rel=stylesheet href="<c:url value='/css/font.css' />"
	type="text/css">
<title>진행상황</title>
<style>
.tb {
	background-color: #c0c0c0;
	border-radius: 20px;
	width: 400px;
	height: 600px;
	text-align: top;
}

.notice {
	vertical-align: top;
	height: 80px;
	background-color: #ff8080;
	padding-left: 20px;
	padding-top: 20px;
	box-shadow: 2px 2px gray;
	font-size: 15px;
	font-style: bold;
}

[contenteditable="true"]:empty:before {
	content: attr(placeholder);
}

div[contenteditable=true] {
	color: #696969;
	padding: 5px;
}
</style>
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
					<!-- 메인화면 -->
					<tr>
						<td colspan="${count}">
							<h2>&nbsp;&nbsp;${studyGroup.groupName}</h2>
							<h4 style="color: gray">&nbsp;&nbsp; 진행상황</h4> <br> <br>
						</td>
					</tr>

					<tr>
						<td style="float: left; overflow-x: auto; white-space: nowrap;">
							<table>
								<tr>
									<c:forEach items="${groupMemberList}" var="member">
										<c:set var="i" value="${i+1}" />
										<td>
											<div>
												<table style="border-spacing: 5px; table-layout: fixed"
													class="tb">
													<tr>
														<td><h2>${member.userName}</h2></td>
													</tr>
													<tr>
														<td>
															<div style="height: 560px; overflow-y: scroll;">
																<table
																	style="padding: 5px; table-layout: fixed; width: 370px;">
																	<tr>
																		<td class="notice"
																			style="background-color:${colorArr[i-1]}; overflow-y: auto; ">
																			<div spellcheck="true" placeholder="add a new note.."
																				data-content-editable-leaf="true"
																				contenteditable="true"
																				style="max-width: 100%; width: auto; white-space: pre-wrap; word-break: break-word; caret-color: rgb(55, 53, 47); font-size: 14px; line-height: 1.5; min-height: 21px; font-weight: 500; flex-grow: 1; padding: 2px; cursor: text;">
																			</div> <br> <br>
																		</td>
																	</tr>
																	<c:forEach items="${memoList}" var="memo">
																	<c:if test="${memo.userId eq member.userId}">
																		<tr>
																			<td class="notice" style="background-color:${colorArr[i-1]}; overflow-y: auto; ">
																				${memo.memoContents}</td>
																		</tr>
																	</c:if>
																	</c:forEach>
																</table>
															</div>
														</td>
													</tr>
												</table>
											</div>
										</td>
										<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
									</c:forEach>
								</tr>

							</table>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>