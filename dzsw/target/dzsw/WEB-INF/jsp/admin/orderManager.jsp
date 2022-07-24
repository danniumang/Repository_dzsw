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
<title>orderManager</title>
<script type="text/javascript">
		function changeColor(obj){
			obj.className = "bgcolor";
		}
		function changeColor1(obj){
			obj.className = "";
		}
		function checkDel(orderid){
  			if(window.confirm("是否删除该订单？")){
  				window.location.href = "adminOrder/deleteorderManager?orderid="+orderid;
  			}
  		}
	</script>
</head>
<body>
	<br>
	<table border="1" bordercolor="PaleGreen">
		<tr>
			<th width="150px">订单编号</th>
			<th width="150px">用户E-mail</th>
			<th width="150px">订单金额</th>
			<th width="150px">订单状态</th>
			<th width="150px">订单日期</th>
			<th width="150px">操作</th>
		</tr>
		<c:forEach var="n" items="${orderList }">
			<tr onmousemove="changeColor(this)" onmouseout="changeColor1(this)">
				<td>${n.ORDERID}</td>
				<td>${n.BEMAIL}</td>
				<td>${n.AMOUNT}</td>
				<td><c:if test="${n.STATUS==0}">未付款</c:if>
					<c:if test="${n.STATUS==1}">已付款</c:if></td>
				<td>${n.ORDERDATE}</td>
				<td><c:if test="${n.STATUS==0}">
						<a href="javaScript:checkDel('${n.ORDERID }')">删除</a>
					</c:if></td>
			</tr>


		</c:forEach>

	</table>
</body>
</html>