<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>StudySet</title>
<link rel=stylesheet href="<c:url value='/css/user.css' />" type="text/css">
<script>
function login() {
	if (form.userId.value == "") {
		alert("사용자 ID를 입력하십시오.");
		form.userId.focus();
		return false;
	} 
	if (form.password.value == "") {
		alert("비밀번호를 입력하십시오.");
		form.password.focus();
		return false;
	}		
	form.submit();
}

function userCreate(targetUri) {
	form.action = targetUri;
	form.method="GET";		// register form 요청
	form.submit();
}
</script>
</head>
<body bgcolor="099987">
<!-- login form  -->
<form name="form" method="POST" action="<c:url value='/user/login' />">
<br><br><br><br>
  <table style="width:100%">
	<tr>
	  <td align="center">
	  	<img src="<c:url value='/images/studysetlogo.png' />" />
	    <br><br>	  
	    <table class="tableForm">
	    <tr height="40"><td></td></tr>
	  	  <tr height="40">
			<td width="150" align="center" >ID</td>
			<td width="250">
				<input type="text" class="input-field" name="userId">
			</td>
		  </tr>
	  	  <tr height="40">
			<td width="150" align="center">PASSWORD</td>
			<td width="250">
				<input type="password" class="input-field" style="width:240" name="password">
			</td>
		  </tr>
		  <tr height="40">
		  	<td colspan="2" style="text-align:center">
		  	<c:if test="${loginFailed}">
	  	  		<font style="color:red; font-size:small;"><c:out value="${exception}" /></font>
	    	</c:if>
	    	</td>
	    </tr>
	    </table>
	    <br> 	 
		<input type="button" value="로그인" onClick="login()" class="btn"> &nbsp;
		<br><br>
			<a href="<c:url value='/user/join/form' />" style="color:white">회원가입 하러가기</a>
	  </td>	  
	</tr>
  </table>  
</form>
</body>
</html>