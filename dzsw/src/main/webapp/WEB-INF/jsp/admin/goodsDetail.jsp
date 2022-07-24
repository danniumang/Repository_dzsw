<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>goodsDetail</title>
</head>
<body>
	<table border="1" style="border-collapse: collapse">
		<caption>
			<font size=4 face=华文新魏>商品详情</font>
		</caption>
		<tr>
			<td>名称</td>
			<td>${goods.gName}</td>
		</tr>
		<tr>
			<td>原价</td>
			<td>${goods.goprice}</td>
		</tr>
		<tr>
			<td>折扣价</td>
			<td>${goods.grprice}</td>
		</tr>
		<tr>
			<td>库存</td>
			<td>${goods.gstore}</td>
		</tr>
		<tr>
			<td>图片</td>
			<td><c:if test="${goods.gricture!='' }">
					<img alt="" width="250" height="250"
						src="${imgaePath}/${goods.gricture}">
				</c:if></td>
		</tr>
		<tr>
			<td>类型</td>
			<td>${goods.typename}</td>
		</tr>
	</table>
	****************

</body>
</html>