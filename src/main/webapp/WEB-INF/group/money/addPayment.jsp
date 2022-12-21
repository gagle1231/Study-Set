<%@page contentType="text/html; charset=utf-8"%>
<%@page import="java.util.*, model.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>사용내역 생성 모달창</title>
<style>
.green {
   width:250px; 
   height:40px;
   border:0 solid black;
   background-color: #8cdbbc;
   opacity: 0.5;
   border-radius: 5px;
}
.close {
	width: 80px;
	height: 35px;
	border:0 solid black;
	background-color: black;
	color: white;
	border-radius: 5px;
}
</style>
<script>
function add() {
	form2.method="POST";		
	alert("입력이 완료되었습니다.");
	form2.submit();
}
function close() {
	form2.close();
}
</script>
</head>
<body>
	<h2>사용 내역 입력</h2>
	<form name="form2" method="POST" autocomplete="off" action="<c:url value='/group/money/addPayment' />">
		<div style="text-align:center;">
			<h4>사용 내역</h4>
			<input name="description" type="text" class="green">
			<br><br>
			<h4>사용 금액</h4>
			<input name="price" type="text"  class="green">
			<br><br>
			<h4>사용 날짜</h4>
			<input name="paymentDate" type="date"  class="green">
		</div>
			<br><br>
			<input type="button" onclick="add()" class="close" value="저장하기"></input>
	</form>
	<br>
</body>
</html>