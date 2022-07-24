<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-3.5.1.min.js">
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${empty allTypes }">
您还没有类型！
</c:if>
	<c:if test="${allTypes !=null }">
		<table border="1" bordercolor="PaleGreen">
			<tr>
				<th width="200px">类型id</th>
				<th width="600px">类型名称</th>
			</tr>
			<c:forEach items="${allTypes}" var="goodsType">
				<tr>
					<td>${goodsType.gstypeid }</td>
					<td>${goodsType.typeName }</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<form action="${pageContext.request.contextPath }/adminType/addType"
		method="post">
		类型名称： <input type="text" name="typeName" /> <input type="submit"
			value="添加" />
	</form>
</body>
</html>