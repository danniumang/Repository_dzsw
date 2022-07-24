<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<style type="text/css">
* {
	margin: 0px;
	padding: 0px;
}

body {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	margin: 0px auto;
	height: auto;
	width: 800px;
	border: 1px solid #006633;
}

#header {
	height: 90px;
	width: 800px;
	background-image: url(images/admin/bb.jpg);
	margin: 0px 0px 3px 0px;
}

#header h1 {
	text-align: center;
	font-family: 华文彩云;
	color: #000000;
	font-size: 30px；
}

#navigator {
	height: 25px;
	width: 800px;
	font-size: 14px;
	background-image: url(images/admin/bb.jpg);
}

#navigator ul {
	list-style-type: none;
}

#navigator li {
	float: left;
	position: relative;
}

#navigator li a {
	color: #000000;
	text-decoration: none;
	padding-top: 4px;
	display: block;
	width: 98px;
	height: 22px;
	text-align: center;
	background-color: PaleGreen;
	margin-left: 2px;
}

#navigator li a:hover {
	background-color: #006633;
	color: #FFFFFF;
}

#navigator ul li ul {
	visibility: hidden;
	position: absolute;
}

#navigator ul li:hover ul, #navigator ul a:hover ul {
	visibility: visible;
}

#content {
	height: auto;
	width: 780px;
	padding: 10px;
}

#content iframe {
	height: 300px;
	width: 780px;
}

#footer {
	height: 30px;
	width: 780px;
	line-height: 2em;
	text-align: center;
	background-color: PaleGreen;
	padding: 10px;
}
</style>
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
	<div id="header">
		<br> <br>
		<h1>欢迎${auser.aname}进入系统</h1>
	</div>
	<div id="navigator">
		<ul>
			<li><a>商品管理</a>
				<ul>
					<li><a
						href="${pageContext.request.contextPath }/adminGoods/toAddGoods"
						target="center">添加商品</a></li>
					<li><a
						href="${pageContext.request.contextPath }/adminGoods/selectGoods?act=deleteSelect"
						target="center">删除商品</a></li>
					<li><a
						href="${pageContext.request.contextPath }/adminGoods/selectGoods?act=updateSelect"
						target="center">修改商品</a></li>
					<li><a
						href="${pageContext.request.contextPath }/adminGoods/selectGoods"
						target="center">查询商品</a></li>
				</ul></li>
			<li><a>类型管理</a>
				<ul>
					<li><a
						href="${pageContext.request.contextPath }/adminType/toAddType"
						target="center">添加类型</a></li>
					<li><a
						href="${pageContext.request.contextPath }/adminType/toDeleteType"
						target="center">删除类型</a></li>

				</ul></li>
			<li><a>用户管理</a>
				<ul>

					<li><a
						href="${pageContext.request.contextPath }/adminUser/userInfo"
						target="center">删除用户</a></li>

				</ul></li>
			<li><a>订单管理</a>
				<ul>

					<li><a
						href="${pageContext.request.contextPath }/adminOrder/orderInfo"
						target="center">删除订单</a></li>

				</ul></li>
			<li><a>公告管理</a>

				<ul>
					<li><a
						href="${pageContext.request.contextPath }/adminNotice/toAddNotice"
						target="center">添加公告</a></li>
					<li><a
						href="${pageContext.request.contextPath }/adminNotice/selectNotices?act=deleteSelect"
						target="center">删除公告</a></li>

				</ul></li>
			<li><a href="${pageContext.request.contextPath }/exit">安全退出</a></li>
		</ul>
	</div>
	<div id="content">
		<%-- <a href="${pageContext.request.contextPath }/adminlogin">adminlogin</a> --%>
		<iframe
			src="${pageContext.request.contextPath }/adminGoods/selectGoods"
			name="center" frameborder="0"></iframe>

	</div>

	<div id="footer">Copyright @liuyujie</div>
</body>
</html>