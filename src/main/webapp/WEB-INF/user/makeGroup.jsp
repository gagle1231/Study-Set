<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html>
<head>
<title>스터디 생성 모달창</title>
<style>
#formInput {
   width:250px; 
   height:40px;
   border:0 solid black;
   background-color: #F2E03B;
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
.searchField {
   width: 90%;
   font-size: 23px;
   border: 1;
   border-radius: 20px;
   text-align: center;
}
</style>
<script>
function gc(){
   if (form1.groupName.value == "") {
      alert("그룹명을 입력해주세요.");
      form1.groupName.focus();
      return false;
   }
   
   if (form1.groupCategory.value == "") {
      alert("분야를 선택해주세요.");
      form1.groupCategory.focus();
      return false;
   }
   
   if (form1.code.value == "") {
      alert("코드를 입력해주세요.");
      form1.code.focus();
      return false;
   }
   alert("새로운 그룹이 생성되었습니다.");
   form1.submit();
}
</script>
<title>스터디 생성 모달창</title>
</head>
<body>
   <form name="form1" method="POST" autocomplete="off" action="<c:url value = '/group/register' /> ">                        
      <div style="text-align:center;">
         <p>새로운 그룹명을 작성해주세요</p>
         <input type="text" id="formInput" name="groupName"/>
         <p>우리 스터디의 분야는?</p>
            <select name="groupCategory" id="formInput" style="background-color:#E6E6E6;">
                 <option value="" style="font-color:#424242;">- 분야 -</option>
                 <option value=1>프로그래밍</option>
                 <option value=2>외국어</option>
                 <option value=3>디자인</option>
                 <option value=4>취업</option>
                 <option value=5>취미</option>
                 <option value=6>경영</option>
                 <option value=7>기타</option>
             </select>
         <p>스터디 소개</p>
         <input type="text" id="formInput" style="background-color:#E6E6E6;" name="groupDescription"
         placeholder="간단한 설명을 작성해주세요"/>
         <p>그룹 가입을 위한 코드를 작성해주세요</p>
         <input type="text" id="formInput" name="code" placeholder="숫자 코드"/>
         <br/><br/>
         <input type="button" onClick="gc()" id="submitBtn" value="생성"></input>
      </div>   
   </form>   
</body>
</html>