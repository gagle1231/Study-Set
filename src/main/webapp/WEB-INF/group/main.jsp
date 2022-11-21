<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>StudySet 그룹 메인화면</title>

<body leftmargin="0" bgcolor="#DFE5DD">
<br>
	<table style="width:100%; border-collapse:collapse">
		<tr>
			<td style="text-align:left; width:130px;" ><img src="<c:url value='/images/studysetlogo.png'/>" width="100%" /></td>
			<td style="text-align:left"><br><br><br><h2>&nbsp;&nbsp;&nbsp;&nbsp;스터디 이름</h2></td>
		</tr>
		<tr><td style="height:30px"></td></tr>
        <tr>
            <td colspan="3">
                <jsp:include page="menu.jsp" flush="false"/>
            </td>
            <td>
            <div name="contents">
            	
            </div>
            </td>
        </tr>
    </table>
</body>
</html>