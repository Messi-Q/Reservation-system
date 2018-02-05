<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.hp.util.DBUtil"%>
<%@page import="com.hp.entity.Cart"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>我的餐车</title>
<link rel="stylesheet" href="css/cart.css" />
</head>
<script type="text/javascript">
	function tijiao(){
		window.location.href="order.jsp";
	}
	function quxiao(){
		window.location.href="index.jsp";
	}
</script>
<body>
	<iframe src="tops.jsp" scrolling="no" frameborder="no" width="100%"></iframe>
	<form action="DeleteAllCartInfoServlet" method="post">
	<div>
		<table align="center" cellspacing="0">
			<tr>
				<td colspan="4">我的订餐信息列表</td>
			</tr>
			<tr>
				<td></td>
				<td width="200">菜品名称</td>
				<td width="100">单价</td>
				<td width="100">数量</td>
				<td width="100"></td>
			</tr>
			<%
				int num = (Integer) request.getAttribute("num");
				ArrayList<Cart> cartList = (ArrayList<Cart>) request.getAttribute("cartList");
				Cart cart = null;
				for (int i = 0; i < cartList.size()-1; i++) {
					cart = cartList.get(i);
			%>
			<tr>
				<td><input type="hidden" value="<%=cart.getCartId()%>" checked="" name="id"></td>
				<td><%=cart.getFoodName()%></td>
				<td><%=cart.getPrice()%></td>
				<td><%=cart.getOrderNum()%></td>
				<td><a style="color: black;text-decoration: none;" href="DeleteCartAllServlet?cartId=<%=cart.getCartId()%>">取消</a></td>
			</tr>
			<%
				}
				for (int i = 0; i < cartList.size(); i++) {
					cart = cartList.get(i);
				}
			%>
			<tr>
				<td colspan="4">小计： <font><%=cart.getTotalPrice()%> </font>元 共：
					<font><%=cart.getTotalNum()%> </font>份
				</td>
			</tr>
			<tr>
				<td colspan="4">
<!-- 					<input type="image" src="img/canche_submit.gif" onclick="tijiao()"/>  -->
					<a  href="addOrder"/><img alt="" src="img/canche_submit.gif"> </a>
					<input type="image" src="img/quxiao2.gif" onclick="quxiao()"/>
				</td>
			</tr>
		</table>
	</div>
	</form>
	<br />
	<br />
	<iframe src="footer.html" scrolling="no" frameborder="no" width="100%"></iframe>
</body>
</html>