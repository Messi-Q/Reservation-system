<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
	<link rel="stylesheet" href="css/register.css" />
	<script type="text/javascript" src="js/register.js"></script>
</head>
<body>
	<iframe src="tops.jsp"  frameborder="no" scrolling="no" width="100%"></iframe>
	<div>
		<form action="UserRegisterServlet" method="post" id="form">
			<table align="center" cellspacing="0">
				<tr>
					<td align="center" colspan="3">请填写用户信息(带<font>*</font>为必填项)
					</td>
				</tr>
				<tr>
					<td><font>用户名：</font></td>
					<td><input type="text" name="UserName" id="UserName" /></td>
					<td><font>*</font>你用来登录的用户名</td>
				</tr>
				<tr>
					<td colspan="3"><font>${error }</font></td>
				</tr>
				<tr>
					<td><font>密码：</font></td>
					<td><input type="password" name="UserPwd" id="UserPwd" /></td>
					<td><font>*</font>长度必须大于5个小于16个字符，只能为英语、数字</td>
				</tr>
				<tr>
					<td><font>确认密码：</font></td>
					<td><input type="password" name="IsPwd" id="IsPwd" /></td>
					<td><font>*</font>请将输入的密码再次输入</td>
				</tr>
				<tr>
					<td><font>真实姓名：</font></td>
					<td><input type="text" name="RealName" /></td>
					<td><font>*</font>填写你的真实姓名</td>
				</tr>
				<tr>
					<td><font>性别：</font></td>
					<td><input type="radio" value="男" checked="checked" name="Sex" />男
						<input type="radio" value="女" name="Sex" />女</td>
					<td><font>*</font>请填写你的真实信息</td>
				</tr>
				<tr>
					<td><font>年龄：</font></td>
					<td><input type="text" name="Age" /></td>
					<td><font>*</font>请填写你的真实年龄</td>
				</tr>
				<tr>
					<td><font>身份证号：</font></td>
					<td><input type="text" name="CardId" /></td>
					<td><font>*</font>请填写你的真实信息</td>
				</tr>
				<tr>
					<td><font>家庭住址：</font></td>
					<td><input type="text" name="UserAddress" /></td>
					<td><font>*</font>请填写你的真实信息</td>
				</tr>
				<tr>
					<td><font>手机号码：</font></td>
					<td><input type="text" name="UserTel" /></td>
					<td><font>*</font>请填写你的真实信息(格式为02411111111或13911111111)</td>
				</tr>
				<tr>
					<td><font>电子邮箱：</font></td>
					<td><input type="text" name="Email" id="Email" /></td>
					<td><font>*</font>请填写你的邮件地址，以便我们为你提供有效的服务</td>
				</tr>
				<tr>
					<td><font>邮政编码：</font></td>
					<td><input type="text" name="Ems" /></td>
					<td><font>*</font>请填写你的真实信息(格式为111111)</td>
				</tr>
				<tr>
					<td align="center" colspan="3">
					<input type="submit" value="注册" onclick="return checkAll()"/></td>
				</tr>
			</table>
		</form>
	</div>
	<br />
	<br />
	<iframe src="footer.html" frameborder="no" scrolling="no" width="100%"></iframe>
</body>
</html>