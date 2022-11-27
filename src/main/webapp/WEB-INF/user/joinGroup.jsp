joinGroup.jsp


<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script
   src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.0.0/jquery.min.js"></script>
<script
   src="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.js"></script>
<script
   src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<link rel="stylesheet"
   href="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.css" />
<script>
function groupCreate(){
   if (form.groupName.value == "") {
      alert("그룹명 입력하십시오.");
      form.groupName.focus();
      return false;
   }
   
   form.submit();
}
</script>
<style>
#input {
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
  a {
      text-decoration: none;
      <%--버튼 안에 텍스트 정렬 조정 부분.. 브라우저마다 다르게 적용되는 듯--%>
      line-height: 50px;
      padding-left: 10px;
   }
   a:link a:visited {
      text-align: center;
   }
</style>
<title>스터디 가입 모달창</title>
</head>
<body>
   <form method="POST" autocomplete="off">
      <div id="modal2" class="modal" style="text-align:center;">
            <p>가입할 그룹 이름</p>
            <input type="text" id="input" name="name"/>
            <p>그룹 코드</p>
            <input type="text" id="input" name="code" style="background-color:#E6E6E6;" placeholder="가입 시 필요한 숫자 코드"/>
            <br/><br/><input type="submit" id="submitBtn" value="가입"></input>                                                      
      </div>
   </form>   
</body>
</html>