<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>this is add goods!</title>
</head>
<body>

	<form:form
		action="${pageContext.request.contextPath }/adminGoods/addGoods"
		modelAttribute="goods" method="post" enctype="multipart/form-data">
		<table border="1" style="border-collapse: collape">
			<caption>
				<font size=4 face=华文新魏>添加商品</font>
			</caption>
			<tr>
				<td>名称<font color="red">*</font></td>
				<td><form:input path="gName" /></td>
			</tr>
			<tr>
				<td>原价<font color="red">*</font></td>
				<td><form:input path="goprice" /></td>
			</tr>
			<tr>
				<td>折扣价</td>
				<td><form:input path="grprice" /></td>
			</tr>
			<tr>
				<td>库存</td>
				<td><form:input path="gstore" /></td>
			</tr>
			<tr>
				<td>图片</td>
				<td><input type="file" name="logoImage" /></td>
			</tr>
			<tr>
			<tr>
				<td>类型</td>
				<td><form:select path="gstypeid">
						<form:options items="${goodsType }" itemLabel="typeName"
							itemValue="gstypeid" />
					</form:select></td>
			</tr>
			<tr>
				<td align="center"><input type="submit" value="提交" /></td>
				<td align="center"><input type="reset" value="重置" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>