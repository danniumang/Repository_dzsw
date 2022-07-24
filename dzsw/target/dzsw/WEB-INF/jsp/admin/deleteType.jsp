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
<!-- javascript 的学习还需加强。?gstypeid的参数名与控制端的参数名要保持一致 -->
<script type="text/javascript">
  		function checkDel(id){
  			if(window.confirm("是否删除该商品类型？")){
  				window.location.href = "${pageContext.request.contextPath }/adminType/deleteType?gstypeid="+id;
  			}
  		}
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
				<th width="300px">类型名称</th>
				<th width="300px">删除操作</th>
			</tr>
			<c:forEach items="${allTypes}" var="goodsType">
				<tr>
					<td>${goodsType.gstypeid }</td>
					<td>${goodsType.typeName }</td>
					<td><a href="javascript:checkDel('${goodsType.gstypeid}')">删除</a>
					</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="3">${msg}</td>
			</tr>

		</table>

	</c:if>
	<form action="${pageContext.request.contextPath }/adminType/addType"
		method="post">
		类型名称： <input type="text" name="typeName" /> <input type="submit"
			value="添加" />
	</form>
</body>
</html>