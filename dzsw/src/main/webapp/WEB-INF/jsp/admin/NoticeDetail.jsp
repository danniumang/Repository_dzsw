<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NoticeDetail</title>
</head>
<body>
	<table border="1" style="border-collapse: collapse">
		<caption>
			<font size=4 face=华文新魏>公告详情</font>
		</caption>
		<tr>
			<td>标题</td>
			<td>${notice.ntitle}</td>
		</tr>
		<tr>
			<td>内容</td>
			<td>${notice.ncontent}</td>
		</tr>
		<tr>
			<td>发布时间</td>
			<td>${notice.ntime}</td>
		</tr>
	</table>
</body>
</html>