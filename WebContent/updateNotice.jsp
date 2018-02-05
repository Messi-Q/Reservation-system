<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改公告</title>
<link rel="stylesheet" href="css/addNotice.css" />
</head>
<body>	
	<div class="main">
			<div class="top"></div>
			<div class="list">
				修改公告
			</div>
			<div class="body">
				<form action="NoticeServlet?opt=doUpdate " method="post">
				
					<table border="1" cellspacing="0" cellpadding="0">
					<c:forEach items="${noticeList }" var="notice">
						<tr>
							<td class="td1">公告编号：<input type="text" class="text" name="noticeId" value="${notice.noticeId }" readonly="readonly"/></td>
						</tr>
						<tr>
							<td class="td1">公告标题：<input type="text" class="text" name="noticeTitle" value="${notice.noticeTitle }"/></td>
						</tr>
						<tr>
							<td class="td1">公告时间：<input type="text" class="text" name="noticeTime" value="${notice.noticeTime }"/></td>
						</tr>
						<tr>
							<td class="td2">公告内容:<textarea id="textarea1" name="noticeCont">${notice.noticeCont }</textarea></td>
						</tr>
						<tr class="tr3">
							<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="submit" name="" value="保存修改" /> </td>
						</tr>
					</c:forEach>
					</table>
				</form>
			</div>
		</div>
</body>
</html>