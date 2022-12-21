<%@page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel=stylesheet href="<c:url value='/css/memo.css' />"
   type="text/css">
<title>진행상황</title>
<style>
.tb{
   background-color: #c0c0c0;
   border-radius: 20px;
   width:80%;
   height:600px;
   text-align: top;
}
.notice{
   vertical-align: top;
   height:80px;
   background-color: #ff8080;
   padding-left:20px;
   padding-top:20px;
   box-shadow: 2px 2px gray;
   font-size: 15px;
   font-style: bold;
}
</style>
</head>
<body leftmargin="0" bgcolor="#DFE5DD">
<%
String[] colorArr = { "#ff8080", "orange", "yellow", "blue", "purple"};
%>
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
               <td style="float: left; overflow-x:auto; white-space:nowrap;" >
               <table>
                  <% // 이름 먼저 출력하고 이름이 바뀔때마다 열 바꾸기
                  
                  %>
                  <tr>
                  <td>
                  <div style="min-width:100pt; maxwidth:100pt;">
                     <table style="border-spacing:5px;" class="tb">
                  <tr><td><h4>이름</h4></td></tr>
                  <tr><td bgcolor="ivory" style="border-radius: 15px;"><h6>최근 제출한 과제</h6></td></tr>
                  <tr><td>
                     <div style="overflow: auto;" class="scroll">
                        <table style="padding:5px">
                           <tr><td class="notice"><b>새로운 메모</b><br><br>
                           <textarea style="background-color:transparent;" name="memoContents" rows="5" cols="50" placeholder="add a new note.." onfocus="this.placeholder=''" onblur="this.placeholder='add a new notes..'"></textarea>
                                    <br><br></td></tr>
                                    <tr>
                                    <td class="notice" style="background-color:orange">
                                       <b>JDBC란?</b><br><br>
                                       Java DataBase Connectivity의 약어로, Java Application과 DBMS를 연동하기 위한 API이다. JDBC 드라이버를 사용하면 DBMS에 독립적인 프로그래밍이 가능하다.
                                    </td>
                                 </tr>
                        </table>
                     </div>
                  </td></tr>                 
                     </table>
                     </div>
                  </td>
                  <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                   <td>
                  <div style="min-width:100pt; maxwidth:100pt;">
                     <table style="border-spacing:5px;" class="tb">
                  <tr><td><h4>이름</h4></td></tr>
                  <tr><td bgcolor="ivory" style="border-radius: 15px;"><h6>최근 제출한 과제</h6></td></tr>
                  <tr><td>
                     <div style="overflow: auto;" class="scroll">
                        <table style="padding:5px">
                           <tr><td class="notice"><b>새로운 메모</b><br><br>
                           <textarea style="background-color:transparent;" name="memoContents" rows="5" cols="50" placeholder="add a new note.." onfocus="this.placeholder=''" onblur="this.placeholder='add a new notes..'"></textarea>
                                    <br><br></td></tr>
                                    <tr>
                                    <td class="notice" style="background-color:orange">
                                       <b>JDBC란?</b><br><br>
                                       Java DataBase Connectivity의 약어로, Java Application과 DBMS를 연동하기 위한 API이다. JDBC 드라이버를 사용하면 DBMS에 독립적인 프로그래밍이 가능하다.
                                    </td>
                                 </tr>
                        </table>
                     </div>
                  </td></tr>                 
                     </table>
                     </div>
                  </td>
                  <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                  <td>
                  <div style="min-width:100pt; maxwidth:100pt;">
                     <table style="border-spacing:5px;" class="tb">
                  <tr><td><h4>이름</h4></td></tr>
                  <tr><td bgcolor="ivory" style="border-radius: 15px;"><h6>최근 제출한 과제</h6></td></tr>
                  <tr><td>
                     <div style="overflow: auto;" class="scroll">
                        <table style="padding:5px">
                           <tr><td class="notice"><b>새로운 메모</b><br><br>
                           <textarea style="background-color:transparent;" name="memoContents" rows="5" cols="50" placeholder="add a new note.." onfocus="this.placeholder=''" onblur="this.placeholder='add a new notes..'"></textarea>
                                    <br><br></td></tr>
                                    <tr>
                                    <td class="notice" style="background-color:orange">
                                       <b>JDBC란?</b><br><br>
                                       Java DataBase Connectivity의 약어로, Java Application과 DBMS를 연동하기 위한 API이다. JDBC 드라이버를 사용하면 DBMS에 독립적인 프로그래밍이 가능하다.
                                    </td>
                                 </tr>
                        </table>
                     </div>
                  </td></tr>                 
                     </table>
                     </div>
                  </td>
                  <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                  <td>
                  <div style="min-width:100pt; maxwidth:100pt;">
                     <table style="border-spacing:5px;" class="tb">
                  <tr><td><h4>이름</h4></td></tr>
                  <tr><td bgcolor="ivory" style="border-radius: 15px;"><h6>최근 제출한 과제</h6></td></tr>
                  <tr><td>
                     <div style="overflow: auto;" class="scroll">
                        <table style="padding:5px">
                           <tr><td class="notice"><b>새로운 메모</b><br><br>
                           <textarea style="background-color:transparent;" name="memoContents" rows="5" cols="50" placeholder="add a new note.." onfocus="this.placeholder=''" onblur="this.placeholder='add a new notes..'"></textarea>
                                    <br><br></td></tr>
                                    <tr>
                                    <td class="notice" style="background-color:orange">
                                       <b>JDBC란?</b><br><br>
                                       Java DataBase Connectivity의 약어로, Java Application과 DBMS를 연동하기 위한 API이다. JDBC 드라이버를 사용하면 DBMS에 독립적인 프로그래밍이 가능하다.
                                    </td>
                                 </tr>
                        </table>
                     </div>
                  </td></tr>                 
                     </table>
                     </div>
                  </td>
                  <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                  <td>
                  <div style="min-width:100pt; maxwidth:100pt;">
                     <table style="border-spacing:5px;" class="tb">
                  <tr><td><h4>이름</h4></td></tr>
                  <tr><td bgcolor="ivory" style="border-radius: 15px;"><h6>최근 제출한 과제</h6></td></tr>
                  <tr><td>
                     <div style="overflow: auto;" class="scroll">
                        <table style="padding:5px">
                           <tr><td class="notice"><b>새로운 메모</b><br><br>
                           <textarea style="background-color:transparent;" name="memoContents" rows="5" cols="50" placeholder="add a new note.." onfocus="this.placeholder=''" onblur="this.placeholder='add a new notes..'"></textarea>
                                    <br><br></td></tr>
                                    <tr>
                                    <td class="notice" style="background-color:orange">
                                       <b>JDBC란?</b><br><br>
                                       Java DataBase Connectivity의 약어로, Java Application과 DBMS를 연동하기 위한 API이다. JDBC 드라이버를 사용하면 DBMS에 독립적인 프로그래밍이 가능하다.
                                    </td>
                                 </tr>
                        </table>
                     </div>
                  </td></tr>                 
                     </table>
                     </div>
                  </td>
                  <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                  <td>
                  <div style="min-width:100pt; maxwidth:100pt;">
                     <table style="border-spacing:5px;" class="tb">
                  <tr><td><h4>이름</h4></td></tr>
                  <tr><td bgcolor="ivory" style="border-radius: 15px;"><h6>최근 제출한 과제</h6></td></tr>
                  <tr><td>
                     <div style="overflow: auto;" class="scroll">
                        <table style="padding:5px">
                           <tr><td class="notice"><b>새로운 메모</b><br><br>
                           <textarea style="background-color:transparent;" name="memoContents" rows="5" cols="50" placeholder="add a new note.." onfocus="this.placeholder=''" onblur="this.placeholder='add a new notes..'"></textarea>
                                    <br><br></td></tr>
                                    <tr>
                                    <td class="notice" style="background-color:orange">
                                       <b>JDBC란?</b><br><br>
                                       Java DataBase Connectivity의 약어로, Java Application과 DBMS를 연동하기 위한 API이다. JDBC 드라이버를 사용하면 DBMS에 독립적인 프로그래밍이 가능하다.
                                    </td>
                                 </tr>
                        </table>
                     </div>
                  </td></tr>                 
                     </table>
                     </div>
                  </td>
                  <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                </tr>
               
               </table>
               </td>
               </tr>
            </table>
         </td>
      </tr>
   </table>
</body>
</html>