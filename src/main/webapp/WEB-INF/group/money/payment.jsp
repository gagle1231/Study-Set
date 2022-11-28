<%@page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel=stylesheet href="<c:url value='/css/group.css' />"
	type="text/css">
<link rel=stylesheet href="<c:url value='/css/modal.css' />"
	type="text/css">
<title>StudySet: ${studyGroup.groupName}</title>
<style>
.btn {
	border: 6px;
	background-color: #F2673B;
	color: white;
	border-radius: 10px;
	font-size: 25px;
	width: 132px;
	height: 45px;
	left: 1100px;;
	top: 200px;
}

.btn2 {
	border: 0px;
	width: 170px;
	height: 35px;
	font-size: 17px;
	background-color: #8cdbbc;
	border-radius: 20px;
	border: 0px;
}

.back {
	width: 97%;
	height: 600px;
	left: calc(50% - 1043px/ 2 + 10px);
	bottom: -154px;
	background: #CBD1CA;
	border-radius: 20px;
	border-collapse: collapse;
	text-align:center;
}

.individualBack {
	width: 960px;
	height: 30px;
	background: white;
	color: black;
	border-radius: 20px;
	border-collapse: collapse;
	font-family:궁서체;
	font-weight:bold;
}

.individualBack td:first-child {
	border-left-style: solid 0px;
	border-top-left-radius: 10px;
	border-bottom-left-radius: 10px;
}

.individualBack td:last-child {
	border-right-style: solid 0px;
	border-bottom-right-radius: 10px;
	border-top-right-radius: 10px;
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
					<!-- 이 테이블 안에 메인 화면 구성하면 될듯 -->
					<tr>
						<td colspan="2">
							<h2>&nbsp;&nbsp;${studyGroup.groupName}</h2>
							<h4 style="color: gray">&nbsp;&nbsp; 회비 사용 관리</h4>
						</td>
					</tr>
					<tr>
						<td width="50%" align="left">
						<form action="<c:url value="/group/money/dues"/>">
						<button class="btn2" onclick="submit()">
								<b>납부내역 확인하기</b>
							</button>
							</form> <br></td>
						<td width="50%" align="right" style="padding: 50px"><button
								class="btn">입력하기</button></td>
					</tr>
					<tr>
						<td colspan="2" width="100%" align="left">
							<table class="back">
								<tr style="height: 40px;">
									<td><b>사용 내역</b></td>
									<td><b>사용 금액</b></td>
									<td><b>사용 날짜</b></td>
								</tr>
								<tr style="height: 30px;">
									<td colspan="3"><hr style="border: solid 3px black;"></td>
								</tr>
								<tr>
									<td width="100%" colspan="3">
											<c:forEach var="payment" items="${list}">
												<tr class="individualBack">
													<td>${payment.paymentDescription}</td>
													<td>${payment.price}</td>
													<td>${payment.paymentDate}</td>
												</tr>
												<tr><td></td></tr>
											</c:forEach>
									</td>
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