<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/selectRole"
		method="post">
		<security:csrfInput />
		<input type="text" name="roleName" /><br> <input type="submit"
			value="提交" />
	</form>
</body>
</html>