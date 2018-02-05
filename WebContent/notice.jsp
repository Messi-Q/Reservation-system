<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>公告</title>
<link rel="stylesheet" href="css/notice.css" />
</head>
<body>
	<iframe src="tops.html" scrolling="no" frameborder="no" width="100%"></iframe>
	<div class="notice">
		<c:forEach items="${noticeList }" var="notice">
			<h2 align="center" style="font-family: '黑体';">${notice.noticeTitle }</h2>
			<h3 align="center" style="font-family: '黑体';">${notice.noticeTime }</h3>
			<p class="p1" align="center">&nbsp;&nbsp;&nbsp;&nbsp;${notice.noticeCont }</p>
			<h4 align="center"><a href="indexs.jsp" class="a1">返回</a></h4>
		</c:forEach>
	</div>
	<iframe src="footer.html" scrolling="no" frameborder="no" width="100%"></iframe>
	</body>
</html>