<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/queryOrder.css" />
<title>订单查询</title>
</head>
<body>
	<div class="main">
		<div class="top"></div>
		<div class="list">订单查询</div>
		<div class="body">
			<table border="1px" cellspacing="0px">
				<tr>
					<td class="c1">按用户ID查询</td>
					<td class="c2">
						<form action="<%=path%>/queryOrder" method="post" > <input
						type="text" name="userId" /> <input type="submit" value="查询" />
						</form>
					</td>
				</tr>
				<tr>
					<td class="c1">按菜品名称查询</td>
					<td class="c2">
						<form action="<%=path%>/queryOrder" method="post" > <input
						type="text" name="foodName" /> <input type="submit" value="查询" />
						</form>
					</td>
				</tr>
				<tr>
					<td class="c1">按销售日期查询</td>
					<td class="c2">
						<form action="<%=path%>/queryOrder" method="post" > <input
						type="date" name="orderTime" /> <input type="submit" value="查询" />
						</form>
					</td>
				</tr>
			</table>

			<table border="1" cellspacing="0">
				<caption>销售订单查询结果信息列表</caption>
				<tr>
					<th>用户ID</th>
					<th>真实姓名</th>
					<th>联系方式</th>
					<th>家庭住址</th>
					<th>商品名称</th>
					<th>订购数量</th>
					<th>单价(元)</th>
					<th>合计(元)</th>
					<th>订购时间</th>
					<th>是否派送</th>
					<!--<th>确认订单</th> -->

					<c:forEach items="${queryResult}" var="order">
						<tr>
							<td>${order.userInfo.userId}</td>
							<td>${order.userInfo.realName}</td>
							<td>${order.userInfo.userTel}</td>
							<td>${order.userInfo.userAddress}</td>
							<td>${order.foodInfo.foodName}</td>
							<td>${order.orderNum}</td>
							<td>${order.foodInfo.marketPrice}</td>
							<td>${order.orderNum*order.foodInfo.marketPrice}</td>
							<td>${order.orderTime}</td>
							<td><c:if test="${order.send==1}">
								是
								</c:if> <c:if test="${order.send==0}">
									否
								</c:if></td>
							<%-- <td><a href="<%=path %>/confirmOrder?orderId=${order.orderId}">确认</a></td> --%>
						</tr>
					</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>
