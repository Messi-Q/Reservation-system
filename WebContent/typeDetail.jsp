<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改菜品类别</title>
<link rel="stylesheet" href="css/addmenu.css" />
</head>
<body>
<div class="main">
		<div class="top"></div>
		<div class="list">
			改菜品类别
		</div>
		<div class="body">
		<form action="FoodTypeServlet?opt=updById" method="post">
		<c:forEach items="${is }" var="is">
			<p>类别编号:<input type="text" value="${is.typeId }" name="typeId" readonly="readonly"> </p>
			<p>类别名称:<input type="text" value="${is.typeName }" name="typeName"> </p>
		</c:forEach>
		<input type="submit" value="修改">
		</form>
		</div>
		</div>
</body>
</html>