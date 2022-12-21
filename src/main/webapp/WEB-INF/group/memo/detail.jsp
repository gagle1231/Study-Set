<%@page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel=stylesheet href="<c:url value='/css/memo.css' />"
   type="text/css">
<title>진행상황-상세</title>
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
               <!-- 메인화면 -->
               <tr>
                  <td colspan="${count}">
                     <h2>&nbsp;&nbsp;${studyGroup.groupName}</h2>
                     <h4 style="color: gray">&nbsp;&nbsp; 진행상황</h4>
                  </td>
              </tr>
              <tr>
                 <td style="text-align: left"><br> <br> <br>
                  <h3>&nbsp;&nbsp;&nbsp;&nbsp;김지민</h3></td>
               <td>
              </tr>
              <tr>
               <td style="height: 30px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
            </tr>
            <tr>
               <td>
                  <div style="bgcolor:blue; border-radius: 15px;">
                     <br> 3주차 예습 <br>
                     MVC 구조: <br>
                     <br>
                     Model : business logic 및 data 저장 관리 수행 <br>
                     View : UI 및 presentation logic 구현 <br>
                     Controller : Model과 View 사이의 실행 흐름 제어 <br>
                  </div>
               </td>
            </tr>
         </table>
         <div
            style="position: absolute; height: 25%; left: 12%; top: 69%; overflow: auto;"
            class="scroll">
            <table>
               <c:forEach var="comment" items="${list}">
                  <tr valign="top">
                     <td class="comm"><div class="comm_con">
                           &nbsp;&nbsp;
                           <c:if test="${comment.annonymous eq 'Y'}"> 익명 </c:if>
                           <c:if test="${comment.annonymous eq 'N'}">${comment.userId}</c:if>
                           &nbsp;|&nbsp;&nbsp;${comment.commentContents}
                     </div></td>
                  </tr>
               </c:forEach>
            </table>
         </div>
         <div
            style="position: absolute; width: 80%; height: 25%; left: 12%; top: 95%;">
            <form name="form1" method="POST" class="comment_td"
               action="<c:url value='/group/task/submit'>
            <c:param name="userId" value="${userId}" />
            <c:param name="userName" value="${userName}" />
            <c:param name="taskId" value="${task.taskId}" />
               <c:param name="taskId" value="${submit.submitId}" /></c:url>">
               <input type="text" name="commentContents" placeholder="댓글을 남겨주세요."
                  class="comment_input"><label class="annonymous"> <input
                  type="checkbox" name="annonymous" value="1" class="ann_box">
                  <input type="checkbox" name="annonymous" value="N" class="ann_box">익명
               </label> <input type="button" onClick="gc()" class="comment_submit" value="↑">
            </form>
         </div>
            
      
   </table>
</body>
</html>