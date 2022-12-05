<%@page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="model.dao.*"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel=stylesheet href="<c:url value='/css/task.css' />"
   type="text/css">
<style>
.submitBtn {
   background-color: #79D997;
   width: 81%;
   height: 43%;
   align-self: center;
   border-radius: 20px;
}
</style>
<title>과제 상세</title>
</head>
<body leftmargin="0" bgcolor="#DFE5DD">
   <br>
   <table style="width: 100%; border-collapse: collapse">
      <tr>
         <td style="text-align: left; width: 130px;">
         	<a href="<c:url value='http://localhost:8080/StudySet/user/group/list' />">
         	<img
            src="<c:url value='/images/studysetlogo.png'/>" width="100%" /></td>
         <td style="text-align: left"><br> <br> <br>
            <h2>&nbsp;&nbsp;&nbsp;&nbsp;${task.name}</h2></td>
      </tr>
      <tr>
         <td style="height: 30px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
      </tr>
      <tr>
         <td colspan="3"><jsp:include page="../menu.jsp" flush="false" /></td>
      </tr>
      <tr>
         <td><div class="descript_back">
               <br>
               &nbsp;&nbsp;<fmt:parseDate value="${task.startDate}" pattern="yyyy-MM-dd"
                  var="parsedRegDate" type="date" />
               <fmt:formatDate value="${parsedRegDate}" pattern="yyyy/MM/dd" />
               <hr>
               <br>&nbsp;&nbsp;${task.description}
            </div>
      </tr>
   </table>
   <div class="descript_back2">
      <table
         style="border-collapse: collapse; border-spacing: 0; width: 90%; margin-left: 58px; margin-top: 15px;">
         <c:forEach var="member" items="${list}">
            <tr valign="top">
               <td class="contents2"
                  style="margin-bottom: 10px; vertical-align: middle;"><a
                  href="<c:url value='/group/task/submit'>
                  <c:param name="userId" value="${member.userId}" />
                  <c:param name="userName" value="${member.userName}" />
                  <c:param name="taskId" value="${task.taskId}" />
               </c:url>">&nbsp;&nbsp;${member.userName}
               </a></td>
               <td class="contentsTime"
                  style="vertical-align: middle; text-align: -webkit-center;">
                  &nbsp;&nbsp;&nbsp;&nbsp;제출기한:&nbsp;&nbsp;<fmt:parseDate
                     value="${task.startDate}" pattern="yyyy-MM-dd"
                     var="parsedRegDate" type="date" /> <fmt:formatDate
                     value="${parsedRegDate}" pattern="yyyy/MM/dd" />&nbsp;&nbsp;~&nbsp;&nbsp;
                  <fmt:parseDate value="${submit.submitDate}" pattern="yyyy-MM-dd"
                     var="parsedRegDate" type="date" /> <fmt:formatDate
                     value="${parsedRegDate}" pattern="yyyy/MM/dd" />
               </td>
               <td class="contentsTime2" style="vertical-align: middle;"><a
                  type="button" class="submitBtn"
                  href="<c:url value='/group/task/submit/form' >
               </c:url>">&nbsp;&nbsp;제출&nbsp;&nbsp;</a></td>
            </tr>
            <tr style="height: 10px;">
               <td></td>
            </tr>
         </c:forEach>
      </table>
   </div>
</body>
</html>