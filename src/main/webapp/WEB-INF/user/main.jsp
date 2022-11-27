<%@page contentType="text/html; charset=utf-8"%>
<%@page import="java.util.*, model.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel=stylesheet href="<c:url value='/css/user.css' />"
	type="text/css">
<title>StudySet</title>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.0.0/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.css" />
<script>
function search(){
	
}
</script>
<style>
.item {
	height: 10px;
	background-color: #FFFFFF;
	margin: auto;
	border-radius: 20px;
	color: black;
}

.searchField {
	width: 90%;
	font-size: 23px;
	border: 1;
	border-radius: 20px;
	text-align: center;
}

  a {
      text-decoration: none;
      <%--버튼 안에 텍스트 정렬 조정 부분.. 브라우저마다 다르게 적용되는 듯--%>
      line-height: 50px;
      padding-left: 10px;
   }
   a:link a:visited {
      color:white;
      text-align: center;
   }
</style>
</head>
<body bgcolor="099987">
	<table style="width: 100%">
		<tr>
			<td>
				<table style="width: 90%; border: 1; margin: auto;">
					<tr height="100px">
						<td style="text-align: left;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<img height="100px" src="<c:url value='/images/studysetlogo.png' />" />
						</td>
						<td align="right">
							<img height="100px" src="<c:url value='/images/userIcon.jpg' />" />
						</td>
					</tr>
					<tr>
						<td></td>
					</tr>
					<tr>
						<td style="text-align: left;"><h2>&nbsp;&nbsp;${loginmeber.getUserName()}님의
								스터디</h2></td>
						<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<div style="float: right; width: 20%;">
								<p class="btn">
									<a href="#modal1" rel="modal:open" type="button">스터디 생성</a>
								</p>
								<div id="modal1" class="modal">
									<p>스터디 생성 내용</p>
									<a href="#" rel="modal:close">닫기</a>
								</div>
							</div>
							<div style="float: right; width: 20%;">
								<p class="btn">
									<a href="#modal2" rel="modal:open" type="button">스터디 가입</a>
								</p>
								<div id="modal2" class="modal">
									<p>스터디 가입 내용</p>
									<a href="#" rel="modal:close">닫기</a>
								</div>
							</div> <br>
						</td>
					</tr>
					<tr>
						<td colspan="2"><form name="searchForm" action="search()">
							<table style="width: 100%; height: 650px; background-color: #C8E8E4; border-radius: 20px;">
								<tr>
									<td style="text-align: center; height: 100px;"><input
										type="text" placeholder="스터디를 검색해주세요" name="studyName"
										class="searchField" onkeypress="return search(event);"/></td>
									<td style="text-align: center; height: 100px;"><input
										type="text" placeholder="그룹원을 검색해주세요" name="memberName"
										class="searchField" /></td>
								</tr>
								<tr>
									<td valign="top"><table width="100%">
											<c:forEach var="group" items="${joinList}">
												<tr>
													<td style="height: 10px" class="item"><a
														href="<c:url value='/group'><c:param name="groupName" value="${group.groupName}"/></c:url>">&nbsp;●&nbsp;${group.groupName}</a>
													</td>
												</tr>
											</c:forEach>
										</table></td>
								<tr>
							</table></form>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>

</body>
</html>