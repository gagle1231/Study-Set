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
<link rel=stylesheet href="<c:url value='/css/modal.css' />" type="text/css">
<script>
window.onload = function() {
    
    function onClick() {
        document.querySelector('.modal_wrap').style.display ='block';
    }   
    function offClick() {
        document.querySelector('.modal_wrap').style.display ='none';
    }
 
    document.getElementById('modal_btn').addEventListener('click', onClick);
    document.querySelector('.modal_close').addEventListener('click', offClick); 
};
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
                  <td style="text-align: left;"><h2>&nbsp;&nbsp;${loginmember.getUserName()}님의
                        스터디</h2></td>
                  <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                     <div style="float: right; width: 20%;">
                        <p id="modal_btn2" class="btn">
                           <a href="#modal2" rel="modal:open" type="button" style="color:white;">스터디 가입</a>
                        </p>
                     </div>
                     <div style="float: right; width: 20%;">
                        <p id="modal_btn" class="btn">
                           <a href="#modal1" rel="modal:open" type="button" style="color:white;">스터디 생성</a>
                        </p>
                     </div>
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
                                          href="<c:url value='/group'><c:param name="groupName" value="${group.groupName}" />
                                          </c:url>">&nbsp;●&nbsp;${group.groupName}</a>
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
<div style="display: none; height: 460px;" class="modal_wrap">
      <!--스터디생성 모달창 영역-->
      <div class="modal_close">
         <a href="#">close</a>
      </div>
      <div align="center">
         <jsp:include page="makeGroup.jsp"></jsp:include>
      </div>
</div>
<div style="display: none; height: 460px;" class="modal_wrap2">
      <!--스터디가입 모달창 영역-->
      <div class="modal_close2">
         <a href="#">close</a>
      </div>
      <div align="center">
         <jsp:include page="joinGroup.jsp"></jsp:include>
      </div>
</div>
</body>
</html>