<%@page contentType="text/html; charset=utf-8"%>
<%@page import="java.util.*, model.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>납부 내역 생성 모달창</title>
	<style>
	.green {
        width: 600px;
        height: 25px;
        position: absolute;
        top:50%;
        left: 50%;
        margin: -250px 0 0 -250px;
        background:#8cdbbc;
        z-index: 2;
        color:black;  
		border-radius: 20px;
	}
	</style>
	<script>
	function add() {
		form.method="POST";		
		alert("입력이 완료되었습니다.");
		form.submit();
	}
	</script>
</head>
<body>
	<h2>납부 내역 입력</h2>
	<form name="addForm" method="POST" autocomplete="off" action="<c:url value='/group/money' />">
		<h4>이름</h4><br>
		<input name="userName" type="text" class="green">
		<br><br>
		<h4>납부 금액</h4><br>
		<input name="price" type="text" class="green">
		<br><br>
		<h4>사용 날짜</h4><br>
		<input name="duesDate" type="date" class="green">
		<button onclick="add()" style="background-color:#302d2c;color: white;">저장하기</button>
		&nbsp;&nbsp;&nbsp;&nbsp;
		<button style="background-color:#302d2c;color: white;">취소하기</button>
	</form>
	<br>
</body>
</html>