<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
   <title>회비 사용 내역 관리</title>
   <style>
   .menuItem{
      height: 140px;
      text-align: center;
   }
   a{
      color:black;
      font-size: 1.2rem;
      font-weight: bold;
   }
   .btn {
      border: 6px;
      background-color: #F2673B;
      color: white;
      position: absolute;
      border-radius: 10px;
      font-size: 25px;
      width: 132px;
      height: 45px;
      left: 1100px;;
      top: 200px;
   }
   .back {
      position: absolute;
      width: 1020px; height : 620px;
      left: calc(50% - 1043px/ 2 + 10px);
      bottom: -154px;
      background: #CBD1CA;
      border-radius: 20px;
   }
   .individualBack{
        display: none;
        width: 960px;
        height: 25px;
        position: absolute;
        top:50%;
        left: 50%;
        margin: -250px 0 0 -250px;
        background:white;
        z-index: 2;
        color:black;  
      border-radius: 20px;
    }
    .modal_wrap{
        display: none;
        width: 600px;
        height: 600px;
        position: absolute;
        top:50%;
        left: 50%;
        margin: -250px 0 0 -250px;
        background:white;
        z-index: 2;
        color:black;  
      border-radius: 15px;
    }
    .modal_close{
        width: 26px;
        height: 26px;
        position: absolute;
        top: -30px;
        right: 0;
        }
    .modal_close> a{
        display: block;
        width: 100%;
        height: 100%;
        background:url(https://img.icons8.com/metro/26/000000/close-window.png);
        text-indent: -9999px;
    }
   </style>
</head>

<body leftmargin="0" bgcolor="#DFE5DD">
<br>
   <table style="width:100%; border-collapse:collapse">
      <tr>
         <td style="text-align:left; width:130px;" ><img src="<c:url value='/images/studysetlogo.png'/>" width="100%" /></td>
         <td style="text-align:left"><br><br><br><h2>&nbsp;&nbsp;&nbsp;&nbsp;${studyGroup.groupName}</h2>
         <br><h4>&nbsp;&nbsp;&nbsp;&nbsp;회비 사용 관리</h4>
         <br>&nbsp;&nbsp;&nbsp;&nbsp;<button style="background-color:#8cdbbc" onClick="location.href='dues.jsp'">납부내역 확인하기</button>
         <button class="btn">입력하기</button>
         </td>
      </tr>
      <tr></tr>
        <tr>
            <td colspan="3">
                <jsp:include page="../menu.jsp" flush="false"/>
            </td>
            <td>
            <div class="back">
               <table>
                  <tr>
                     <td>사용 내역</td>
                     <td>사용 금액</td>
                     <td>사용 날짜</td>
                  </tr>
                  <tr>
                     <td colspan="3"><hr style="border: solid 3px black;"></td>
                  </tr>
               </table>
               <c:forEach var="i" items="${duesList}">
                  <p><c:out value="${i.userId}"/></p>
                  <p><c:out value="${i.price}"/></p>
                  <p><c:out value="${i.duesDate}"/></p>
               </c:forEach>
            </div>
            </td>
        </tr>
    </table>
</body>
</html>