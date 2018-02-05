<%@page import="com.hp.util.DBUtil"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户中心</title>
<link rel="stylesheet" href="css/userUpdate.css" />
<script type="text/javascript" src="js/userUpdate.js"></script>
</head>
<body>
	<iframe src="tops.jsp" frameborder="no" scrolling="no" width="100%"></iframe>
	<form action="UserCenterServlet" method="post" id="form">
	<div>
		<%
			Connection conn = DBUtil.getConn();
			String sql = "select * from UserInfo";
			ResultSet rs = DBUtil.executeQuery(conn, sql);
			while (rs.next()) {
		%>
		<input type="text" value="<%=rs.getInt("UserId")%>" checked="checked"
			name="UserId" style="visibility: hidden;" />
		<%
			}
			DBUtil.closeConn(conn);
		%>
		<div class="list">用户信息</div>
		<div class="body">
				<table align="center" border="1px" cellspacing="0px" width="400">
					<tr>
						<th colspan="2">更改用户密码</th>
					</tr>
					<tr>
						<td align="right">用户名：</td>
						<td align="left"><input type="text" name="username"
							id="username" /></td>
					</tr>
					<tr>
						<td align="right">旧密码：</td>
						<td align="left"><input type="password" name="userpwd"
							id="userpwd" /></td>
					</tr>
					<tr>
						<td align="right">新密码：</td>
						<td align="left"><input type="password" name="newuserpwd"
							id="newuserpwd" /></td>
					</tr>
					<tr>
						<td align="right">确认密码：</td>
						<td align="left"><input type="password" name="reuserpwd"
							id="reuserpwd" /></td>
					</tr>
					<tr>
						<td align="center" colspan="2"><input type="submit"
							value="确认修改" onclick="return checkAll()" /> <input type="reset"
							value="重置" /></td>
					</tr>
				</table>
			
		</div>
	</div>
	</form>
	<iframe src="footer.html" frameborder="no" scrolling="no" width="100%"></iframe>
</body>
</html>