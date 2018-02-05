<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
	<link rel="stylesheet" href="css/logins.css" />
	<script type="text/javascript" src="js/login.js"></script>
</head>
<body>
	<iframe src="tops.jsp" frameborder="no" scrolling="no" width="100%"></iframe>
	<div class="login">
		<div class="d1">
			<form action="UserLoginServlet" method="post" id="form">
				<table class="t1">
					<tr>
						<td>登录帐号</td>
						<td><input type="text" size="16" name="username"></td>
					</tr>
					<tr>
						<td>登录密码</td>
						<td><input type="password" size="16" name="userpwd"></td>
					</tr>
					<tr>
						<td colspan="2"><font>${error }</font></td>
					</tr>
					<tr>
						<td></td>
						<td><input style="padding-top: 10px;" type="image"
							onclick="return login()" src="img/denglu.gif" /> <a
							href="register.jsp"><img src="img/zhuce.gif" /></a></td>
					</tr>
				</table>
			</form>
		</div>
		<div class="d2">
			<div class="d3">
				<img src="img/cateitems.gif" />如果你已是会员，请在左侧登录<br />
				<br /> <img src="img/cateitems.gif" />如果你还没有注册会员，<span><a
					href="register.jsp" class="s1">点这里注册会员</a></span><br />
				<br /> <img src="img/cateitems.gif" />如果你忘记了密码，<span><a
					href="userUpdate.jsp" class="s2">点这里重置密码</a></span><br />
				<br />
			</div>
		</div>
	</div>
	<br />
	<br />
	<iframe src="footer.html" frameborder="no" scrolling="no" width="100%"></iframe>
</body>
</html>