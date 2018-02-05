<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>销售订单信息</title>
<link rel="stylesheet" href="css/sellList.css" />
</head>
<body>
	<div class="main">
		<div class="top"></div>
		<div class="list">订单信息</div>
		<div class="body">
			<table border="1px" cellspacing="0px">
				<caption>销售订单查询结果信息列表</caption>
				<tr>
					<th>用户ID</th>
					<th>真实姓名</th>
					<th>联系方式</th>
					<th>家庭住址</th>
					<th>奖品名称</th>
					<th>订购数量</th>
					<th>单价(元)</th>
					<th>合计(元)</th>
					<th>订购时间</th>
					<th>是否派送</th>
					<th>确认订单</th>
				</tr>
				<c:forEach items="${pager.currentPagedText}" var="order">
					<tr>
						<td>${order.userInfo.userId}</td>
						<td>${order.userInfo.realName}</td>
						<td>${order.userInfo.userTel}</td>
						<td>${order.userInfo.userAddress}</td>
						<td>${order.foodInfo.foodName}</td>
						<td>${order.orderNum }</td>
						<td>${order.foodInfo.marketPrice}</td>
						<td>${order.orderNum*order.foodInfo.marketPrice}</td>
						<td>${order.orderTime }</td>
						<td><c:if test="${order.send==1}">
								是
							</c:if> <c:if test="${order.send==0}">
								否
							</c:if></td>
						<td><a
							href="<%=path %>/confirmOrder?orderId=${order.orderId}">确认</a></td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="11">
							第${pager.currentPage }页 
							共${pager.totalPage}页
						<c:if test="${pager.currentPage==1}">
							<c:out value="[首页][上一页]"></c:out>
						</c:if> 
						<c:if test="${pager.currentPage != 1}">
							<!-- 变 -->
							<A HREF="sellList?&currentPage=1">[首页]</A>
							<A HREF="sellList?&currentPage=${pager.currentPage-1}">[上一页]</A>
						</c:if> 
						<c:if test="${pager.currentPage==pager.totalPage}">
							<c:out value="[下一页] [尾页]"></c:out>
						</c:if> 
						<c:if test="${pager.currentPage != pager.totalPage}">
							<A HREF="sellList?&currentPage=${pager.currentPage+1 }">[下一页]</A>
							<A HREF="sellList?&currentPage=${pager.totalPage }"> [尾页]</A>
						</c:if>
					</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>