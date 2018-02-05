<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加公告</title>
<link rel="stylesheet" href="css/addNotice.css" />
</head>
<body>	
	<div class="main">
			<div class="top"></div>
			<div class="list">
				添加公告
			</div>
			<div class="body">
				<form action="NoticeServlet?opt=add" method="post">
					<table border="1" cellspacing="0" cellpadding="0">
						<tr>
							<td class="td1">公告标题：<input type="text" class="text" name="noticeTitle"/></td>
						</tr>
	
						<tr>
							<td><span class="span1">公告内容：</span><textarea id="textarea1" name="noticeCont"></textarea></td>
						</tr>
						<tr class="tr3">
							<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="submit" name="" value="添加" /> </td>
						</tr>
					</table>
				</form>
			</div>
		</div>
</body>
</html>