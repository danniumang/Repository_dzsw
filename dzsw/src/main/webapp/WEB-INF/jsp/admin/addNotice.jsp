<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>this is add Notice!</title>
</head>
<body>
	<c:if test="${empty allNotice }">
您还没有公告！
</c:if>
	<c:if test="${allNotice !=null }">
		<table border="1" bordercolor="PaleGreen">
			<tr>
				<th width="200px">公告id</th>
				<th width="600px">标题</th>
				<th width="600px">公告时间</th>
			</tr>
			<c:forEach items="${allNotice}" var="notices">
				<tr>
					<td>${notices.noticeid }</td>
					<td>${notices.ntitle }</td>
					<td>${notices.ntime }</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<form
		action="${pageContext.request.contextPath }/adminNotice/addNotice"
		method="post">
		<table border="1" style="border-collapse: collape">
			<caption>
				<font size=4 face=华文新魏>添加公告</font>
			</caption>
			<tr>
				<td>标题：</td>
				<td><input type="text" name="ntitle" /></td>
			</tr>
			<tr>
				<td>内容：</td>
				<td colspan="3"><input type="text" name="ncontent" /></td>
			</tr>
			<tr>
				<td align="center"><input type="submit" value="提交" /></td>
				<td align="center"><input type="reset" value="重置" /></td>
			</tr>
		</table>
	</form>
</body>
</html>