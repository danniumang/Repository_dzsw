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
<style type="text/css">
table {
	text-align: center;
	border-collapse: collapse;
}

.bgcolor {
	background-color: #F08080;
}
</style>
<script type="text/javascript">
		function changeColor(obj){
			obj.className = "bgcolor";
		}
		function changeColor1(obj){
			obj.className = "";
		}
	</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${allGoods.size()==0}">
您还没有商品。
</c:if>
	<c:if test="${allGoods.size()!=0}">
		<table border="1" bordercolor="PaleGreen">
			<tr>
				<th width="100px">id</th>
				<th width="200px">名称</th>
				<th width="200px">价格</th>
				<th width="100px">库存</th>
				<th width="200px">详情</th>
			</tr>
			<c:forEach items="${allGoods }" var="goods">
				<tr onmousemove="changeColor(this)" onmouseout="changeColor1(this)">
					<td>${goods.goodid}</td>
					<td>${goods.gName}</td>
					<td>${goods.goprice}</td>
					<td>${goods.gstore}</td>
					<td><a href="adminGoods/selectAGoods?goodid=${goods.goodid}"
						target="_blank">详情</a></td>
					<td><a
						href="adminGoods/selectAGoods?goodid=${goods.goodid}&act=updateAgoods"
						target="_blank">修改</a></td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="5" align="right">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;共${totalCount}条记录&nbsp;&nbsp;共${totalPage}
					页&nbsp;&nbsp;第${pageCur}页&nbsp;&nbsp; <c:url var="url_pre"
						value="adminGoods/selectGoods">
						<c:param name="pageCur" value="${pageCur-1}" />
					</c:url> <c:url var="url_next" value="adminGoods/selectGoods">
						<c:param name="pageCur" value="${pageCur+1}" />
					</c:url> <c:if test="${pageCur !=1}">
						<a href="${url_pre}">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
    	
    </c:if> <c:if test="${pageCur!=totalPage && totalPage !=0}">
						<a href="${url_next}">下一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
    	
    </c:if>
				</td>


			</tr>

		</table>
	</c:if>
</body>
</html>