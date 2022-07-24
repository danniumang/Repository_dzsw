<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" bordercolor="PaleGreen">
		<tr>
			<th width="150px" style="display: none">userid</th>
			<th width="150px">uname</th>
			<th width="150px">sex</th>
			<th width="150px">rolename</th>
		</tr>
		<c:forEach var="n" items="${sysuserList}">
			<tr>
				<td style="display: none">${n.userid}</td>
				<td>${n.uname}</td>
				<td>${n.usex}</td>
				<td>${n.rolename}</td>
			</tr>


		</c:forEach>

	</table>
	<!--  
<c:forEach items="${userList}" var="user">
${user.userid }
${user.uname }
${user.usex }
${user.rolename}
<br>
</c:forEach>
-->
</body>
</html>