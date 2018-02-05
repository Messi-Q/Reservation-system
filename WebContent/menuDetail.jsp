<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改菜品信息</title>
<link rel="stylesheet" href="css/addmenu.css" />
</head>
<body>
<div class="main">
		<div class="top"></div>
		<div class="list">
			修改菜品信息
		</div>
		<div class="body">
		<form action="FoodServlet?opt=updById" method="post">
		<c:forEach items="${di }" var="di">
			<p>菜品编号:<input type="text" value="${di.foodId }" name="foodId" readonly="readonly"> </p>
			<p>菜品名称:<input type="text" value="${di.foodName }" name="foodName"> </p>
			<p>会员价格:<input type="text" value="${di.vipPrice }" name="vipPrice"> </p>
			<p>市场价格:<input type="text" value="${di.marketPrice }" name="marketPrice"> </p>
			<p>菜品描述:
			<textarea rows="3" cols="23" name="foodDesp">${di.foodDesp }</textarea>
			<p>菜品原料:<input type="text" value="${di.foodIng }" name="foodIng"> </p>
		</c:forEach>
		<input type="submit" value="修改">
		</form>
		</div>
		</div>

</body>
</html>