<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>日销售统计</title>
	<link rel="stylesheet" href="css/totalSell.css" />
		</head>
	<body>
		<div class="main">
		<div class="top"></div>
		<div class="list">
			日销售统计
		</div>
		<div class="body">
			<table border="1px" cellspacing="0px">
			<tr>
				<th colspan="4">本日销售额统计</th>
			</tr>
			<tr>
				<th>商品名称</th>
				<th>订购数量</th>
				<th>单价</th>
				<th>合计</th>
			</tr>
			<c:forEach items="${totalSell}"  var="food">
				<tr>
					<td>${food.foodName}</td>
					<td>${food.nums}</td>
					<td>${food.price}</td>
					<td>${food.count}</td>
				</tr>
			</c:forEach>
			
			<tr>
				<th colspan="4">本日销售总额：${countAll}元</th>
			</tr>
		</table>
		</div>
		</div>
	</body>
</html>