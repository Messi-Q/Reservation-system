<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>公告管理</title>
<link rel="stylesheet" href="css/noticeManage.css" />
<script type="text/javascript">
function delcfm() {
	if (!confirm("确认要删除？")) {
	window.event.returnValue = false;
	}
	}
</script>
</head>
<body>
		<div class="main">
		<div class="top"></div>
		<div class="list">
			公告管理
		</div>
		<div class="body">
			
				<table border="1px" cellspacing="0px">
				<caption>公告信息列表</caption>
					<tr>
						<th>公告id</th>
						<th>公告标题</th>
						<th>公告时间</th>
						<th>内容</th>				
						<th>删除</th>
						<th>修改</th>
					</tr>
					
					<c:forEach items="${noticeList }" var="notice">
					<tr>				
						<td>${notice.noticeId }</td>
						<td>${notice.noticeTitle }</td>
						<td>${notice.noticeTime }</td>
						<td>${notice.noticeCont }</td>				
						<td><a href="NoticeServlet?opt=toUpdate&noticeId=${notice.noticeId }">修改</a></td>
						<td><a href="NoticeServlet?opt=delete&noticeId=${notice.noticeId }" onClick="delcfm()">删除</a></td>
					</tr>
					</c:forEach>		
					<tr>
						<td colspan="11">第1页&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">[首页]</a><a href="#">[尾页]</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">[上一页]</a><a href="#">[下一页]</a></td>
		 			</tr>
				</table>

		</div>
		</div>
</body>
</html>
