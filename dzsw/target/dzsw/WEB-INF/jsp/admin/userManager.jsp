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
<base href="<%=basePath%>">
<meta charset="UTF-8">
<title>userManager</title>
<script type="text/javascript">
		function changeColor(obj){
			obj.className = "bgcolor";
		}
		function changeColor1(obj){
			obj.className = "";
		}
		function checkDel(buserid){
  			if(window.confirm("是否删除该用户？")){
  				window.location.href = "adminUser/deleteuserManager?buserid="+buserid;
  			}
  		}
	</script>
</head>
<body>
	<br>
	<table border="1" bordercolor="PaleGreen">
		<tr>
			<th width="150px">用户id</th>
			<th width="150px">用户E-mail</th>
			<th width="150px">密码</th>
			<th width="150px">操作</th>
		</tr>
		<c:forEach var="n" items="${userList }">
			<tr onmousemove="changeColor(this)" onmouseout="changeColor1(this)">
				<td>${n.buserid}</td>
				<td>${n.bemail}</td>
				<td>${n.bpwd}</td>
				<td><a href="javaScript:checkDel('${n.buserid }')">删除</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>