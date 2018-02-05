<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
		<link rel="stylesheet" href="css/top.css">
	</head>
	<body>
		<div class="top">
			<img src="img/logo.gif" />
		</div>
		<div class="usermessage">
			管理员：<%=request.getParameter("adminName") %> 你好，感谢登陆使用!
		</div>
		<div class="back">
			<a href=""><img src="img/out.gif" /></a>
		</div>
	</body>
</html>