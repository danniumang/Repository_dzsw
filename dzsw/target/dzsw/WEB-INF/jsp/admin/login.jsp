<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	//确定按钮
	function gogo(){
		document.loginform.submit();
	}
	//取消按钮
	function cancel(){
		document.loginform.action="";
	}
	function refreshCode(){
		document.getElementById("code").src = "validateCode?" + Math.random();
    }
	</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form action="${pageContext.request.contextPath }/adminlogin"
		modelAttribute="auser" method="post">
		<table>
			<tr>
				<td colspan="2"
					src="${pageContext.request.contextPath }/images/admin/login.gif"></td>
			</tr>
			<tr>
				<td>姓名：</td>
				<td><form:input path="aname" cssClass="textSize" /></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><form:password path="apwd" cssClass="textSize" maxLength=""></form:password>
				</td>
			</tr>
			<%--   <tr>
			<td>验证码：</td>
			<td><input type="text" name="code" class="textSize"/></td>
		</tr>
		  <tr>
  <td>
  <img alt="code" id="code" src="${pageContext.request.contextPath }/validateCode">
  </td>
  <td class="ared">
  <a href="javascript:refreshCode();"><font color="blue">看不清，换一个！</font></a>
  </td>
  </tr> --%>
			<tr>
				<td colspan="2"><input type="image"
					src="${pageContext.request.contextPath }/images/admin/ok.gif"
					onclick="gogo()"> <input type="image"
					src="${pageContext.request.contextPath }/images/admin/cancel.gif"
					onclick="cancel()"></td>


			</tr>




		</table>

	</form:form>
	${msg}
</body>
</html>