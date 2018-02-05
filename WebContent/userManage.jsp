<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员信息</title>
	</head>
	<link rel="stylesheet" href="css/userManage.css">
		</head>
	<body>
		<div class="main">
		<div class="top"></div>
		<div class="list">
			管理员信息
		</div>
		<div class="body">
		<form action="UpdateAdminInfo" method="post">
			<table border="1px" cellspacing="0px">
			<tr>
				<td>更改管理员信息</td>
			</tr>
			<tr>
				<td>管理员姓名：<input type="text" name="adminName" value="<%=request.getParameter("adminName") %>"/></td>
			</tr>
			<tr>
				<input type="text" name="adminId" value="<%=request.getParameter("adminId") %>" style="visibility: hidden;"/>
				<td>管理员密码：<input type="password"name="pwd"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="修改" /></td>
			</tr>
		</table>
		</form>
		</div>
		</div>
	</body>
</html>