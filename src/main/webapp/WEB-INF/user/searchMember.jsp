<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title> 스터디 가입 모달창 </title>
<style>
.title {
   width:400px; 
   height:30px;
   background-color: #F2E03B;
   opacity: 0.5;
   border-radius: 15px;
   font-size:20px;
   color: black;
   font-weight: bold;
   text-align: center;
   font-size: 20px;
   padding-top: 10px;
   padding-bottom: 10px;
}
#formInput2 {
   width:180px; 
   height:40px;
   border:0 solid black;
   background-color: #F2E03B;
   opacity: 0.5;
   border-radius: 5px;
}
#submitBtn2 {
   width: 40px;
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
.searchField {
   width: 90%;
   font-size: 23px;
   border: 1;
   border-radius: 20px;
   text-align: center;
}
</style>
<script>
function searchMember(){
   if (searchMemberForm.groupName.value == "") {
      alert("그룹을 선택해주세요.");
      searchMemberForm.group.focus();
      return false;
   }

   if (searchMemberForm.userName.value == "") {
      alert("그룹원을 입력해주세요.");
      searchMemberForm.code.focus();
      return false;
   }
   //window.opener.parent.location.reload();
   searchMemberForm.submit();
}
</script>
</head>
<body>
   <form name="searchMemberForm" method="POST" autocomplete="off" 
   		action="<c:url value = '/user/search/member'/> " onsubmit="return false;">
      <p class="title"> 스터디 선택 후 이름을 검색하세요 </p>    
      <div style="text-align:center; align:center;">
      <br>
      	<div style="padding-right:60px;">
	       <p>스터디:&nbsp;
		     <select name="groupName" id="formInput2" style="background-color:#E6E6E6;">
		          <option value="" style="font-color:#424242;">- 그룹 -</option>
		          <c:forEach var="group" items="${joinList}">
			          <option value="${group.groupId}">${group.groupName}</option>
		          </c:forEach>
		      </select>  
	       </p>
	 	</div>
	 	<div>
	       <p>이름: &nbsp;
	       	<input type="text" id="formInput2" name="userName" style="background-color:#F2E03B; weight:20px;" placeholder="찾고 싶은 그룹원의 이름"/>
	       	&nbsp;&nbsp;&nbsp;
			<input type="button" id="submitBtn2" value="↑" onClick="searchMember()"></input>
	       </p>
	     </div>
	     <br>
	     <c:choose>
			<c:when test="${findMemberList ne null}">
				<c:forEach var="mem" items="${findMemberList}">
					<hr>${mem.userName} | 
				 연락처: ${mem.phone}&nbsp; <a href="mailto:">${mem.email}</a><br>
					<hr>
				</c:forEach>
			</c:when>
			<c:when test="${findMemberList eq null}">
			검색 결과 없음
			</c:when>
			<c:otherwise>
				그룹원 검색
			</c:otherwise>
		</c:choose> 
	     <br>                                                      
      </div>
   </form>   
</body>
</html>