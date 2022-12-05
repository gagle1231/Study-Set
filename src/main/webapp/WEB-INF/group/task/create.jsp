<%@page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>과제 생성 모달창</title>
<style>
#formInput {
	width: 250px;
	height: 40px;
	border: 0 solid black;
	background-color: #BEEDCD;
	opacity: 0.5;
	border-radius: 5px;
}

#submitBtn {
	width: 80px;
	height: 35px;
	border-radius: 7px;
	background-color: black;
	color: white;
}

.item {
	height: 10px;
	background-color: #FFFFFF;
	margin: auto;
	border-radius: 20px;
	color: black;
}
</style>
<script>
	function gc() {
		if (form1.name.value == "") {
			alert("과제 제목을 입력해주세요.");
			form1.taskTitle.focus();
			return false;
		}

		if (form1.description.value == "") {
			alert("과제 설명을 작성해주세요.");
			form1.taskDescription.focus();
			return false;
		}

		alert("새로운 과제가 생성되었습니다.");
		form1.submit();
	}
	var now_utc = Date.now()
	var timeOff = new Date().getTimezoneOffset() * 60000;
	var today = new Date(now_utc - timeOff).toISOString().split("T")[0];
	document.getElementById("Date").setAttribute("max", today);
</script>
<title>스터디 생성 모달창</title>
</head>
<body>
	<form name="form1" method="POST" autocomplete="off"
		action="<c:url value = '/group/task/form' /> ">
		<div
			style="text-align: center; background-color: white; border-radius: 16px;">
			<p>과제 제목:</p>
			<input type="text" id="formInput" name="name"
				style="width: 60%;" placeholder="과제 이름을 작성해주세요." />
			<p>과제 설명:</p>
			<input type="text" name="description" id="formInput"
				style="height: 160px; width: 76%;" placeholder="과제 설명을 작성해주세요.">
			<br>
			<p>생성 일자</p>
			<input type="date" id="Date" name="startDate"
				style="background-color: #BEEDCD;" />​
			<p>마감 일자</p>
			<input type="date" id="Date" name="endDate"
				style="background-color: #BEEDCD;"> <br /> <br /> <input
				type="button" onClick="gc()" id="submitBtn" value="생성"></input><br>
		</div>
	</form>
</body>
</html>