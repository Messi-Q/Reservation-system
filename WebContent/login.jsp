<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员登录</title>
<link rel="stylesheet" href="css/login.css" />
</head>
<body>
<div class="main">
			<div class="top"></div>
			<div class="middle">
				<div class="left">
					<img src="img/logo.png" id="img"/>
					<span id="email"><img src="img/icon-mail2.gif"/>&nbsp;客户服务邮箱：admin@apsfc.com</span>
					<span id="web"><img src="img/icon-phone.gif"/>&nbsp;官方网站：http://www.apsfc.com</span>
					<a href="#" id="info"><img src="img/icon-demo.gif"/>&nbsp;使用说明</a>
					<a href="#" id="kefu"><img src="img/icon-login-seaver.gif"/>&nbsp;在线客服</a>
				</div>
				<div class="center">
					<form action="AdminInfoServlet" method="post">
						<span id="title">登录网上订餐后台管理</span>
						<label id="name">管理员：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="text" class="input" name="adminName"/></label>
						<br />
						<label id="password">密&nbsp;&nbsp;&nbsp;码：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="password" class="input" name="pwd"/>
						</label>
						<span id="luck">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
						<br />
						<label id="ck"><input type="checkbox"/>5天内自动登录</label>
						<br />
						<input type="submit"  value="登录" class="but"/>
						<input type="reset"  value="取消"class="but"/>
					</form>
				</div>
				<div class="end">
					<img src="img/login-wel.gif"/>
				</div>
				<div class="buttom">
					Copyright&copy;2015-2020
				</div>
			</div>
		</div>
</body>
</html>