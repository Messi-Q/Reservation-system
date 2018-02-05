<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.hp.entity.Cart"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>阿婆私房菜</title>
<link rel="stylesheet" href="css/index.css" />
<script type="text/javascript" >
function islogin(){
	if("${userId}"){
		return true;
	}else{
		alert("您当前未登录，请先登录");
	    window.location.href="userlogin.jsp"
	    return false;
	}
}
</script>
</head>
<body>
	<iframe src="tops.jsp" scrolling="no" frameborder="no" style="display: block;" width="100%"></iframe>
	<div class="container">
		<!--页面头部-->
		<!--页面主体-->
		<div id="main">
			<div class="main-left">
				<!--菜品列表-->
				<div class="item-list">
					<!--菜品-->
					<c:forEach items="${pager.currentPagedText}" var="dis">
						<div class="item">
							<div class="item-pic">
								<img src="img/${dis.imageUrl }" />
							</div>
							<div class="item-details">
								<ul>
									<li>菜名：<b>${dis.foodName }</b></li>
									<li>市场价格：${dis.marketPrice }</li>
									<li>会员价格：<span class="text-danger">${dis.vipPrice }</span></li>
									<li>原料：${dis.foodIng }</li>
									<li class="item-type">菜品类型：${dis.typeName }</li>
								</ul>
								<a href="AddCartServlet?foodid=${dis.foodId }&ordernum=1"
									class="addbtn" id="a1" onclick="return islogin()"></a>
							</div>
						</div>
					</c:forEach>
					<div style="margin-left: 200px">
						第${pager.currentPage }页 共${pager.totalPage}页
					<c:if test="${pager.currentPage==1}">
						<c:out value="首页 上一页"></c:out>
					</c:if>
					<c:if test="${pager.currentPage != 1}">
						<!-- 变 -->
						<A HREF="IndexServlet?&currentPage=1">首页</A>
						<A HREF="IndexServlet?&currentPage=${pager.currentPage-1}">上一页</A>
					</c:if>
					<c:if test="${pager.currentPage==pager.totalPage}">
						<c:out value="下一页 尾页"></c:out>
					</c:if>
					<c:if test="${pager.currentPage != pager.totalPage}">
						<A HREF="IndexServlet?&currentPage=${pager.currentPage+1 }">下一页</A>
						<A HREF="IndexServlet?&currentPage=${pager.totalPage }"> 尾页</A>
					</c:if>
					</div>
				</div>
			</div>
			<div class="main-right">
				<!--餐厅公告-->
				<div class="notice module">
					<div class="module-header">餐厅公告</div>
					<div class="module-more">
						<a href="#">更多>></a>
					</div>
					<div class="clear-fix"></div>
					<ul>
						<c:forEach items="${noticeList }" var="notice">
							<li><a
								href="NoticeServlet?opt=doSelectOne&noticeId=${notice.noticeId }">${notice.noticeTitle }</a>
								<br> <span class="text-info">${notice.noticeTime }</span></li>
						</c:forEach>
					</ul>
				</div>

				<!--购物车-->
				<div class="cart module">

					<div class="module-header">我的餐车</div>
					<div class="module-more">
						<a href="ShowMoreCartInfoServlet" onclick="return islogin()">更多>></a>
					</div>
					<div class="clear-fix"></div>
					<table align="center" cellspacing="0">
						<tr>
							<th>菜单名称</th>
							<th>单价</th>
							<th>数量</th>
						</tr>
						<%
							/* int num = (Integer) request.getAttribute("num"); */
							ArrayList<Cart> cartList = (ArrayList<Cart>) request.getAttribute("cartList");
							Cart cart = null;
							if (cartList != null) {
								for (int i = 0; i < cartList.size() - 1; i++) {
									cart = cartList.get(i);
						%>

						<tr>
							<td><%=cart.getFoodName()%></td>
							<td><%=cart.getPrice()%></td>
							<td><%=cart.getOrderNum()%></td>
							<td><a style="color: black; text-decoration: none;"
								href="DeleteCartServlet?cartId=<%=cart.getCartId()%>">取消</a></td>
						</tr>
						<%
							}
								for (int i = 0; i < cartList.size(); i++) {
									cart = cartList.get(i);
								}
						%>
						<tr align="center">
							<td colspan="4">小计： <span class="text-danger"><%=cart.getTotalPrice()%></span>元
								<span class="text-danger"><%=cart.getTotalNum()%></span>份
							</td>
						</tr>
						<%
							}
						%>
						<tr>
							<td colspan="4"><a href="addOrder"> <input type="image"
									src="img/canche_submit.gif" onclick="tijiao()" />
							</a> <a href="cancelAll"><input type="image"
									src="img/quxiao2.gif" onclick="quxiao()" /></a></td>
						</tr>
					</table>
				</div>
				<!--热销 -->
				<div class="topsales module">
					<div class="module-header">销售排行榜</div>
					<div class="module-more">
						<a href="">更多>></a>
					</div>
					<div class="clear-fix"></div>
					<ul>
						<c:forEach items="${top5 }" var="top">
							<li>${top.foodName }<span class="text-info">&nbsp;&nbsp;已销售${top.nums}份</span></li>
						</c:forEach>

					</ul>

				</div>
			</div>
		</div>
		<div class="clear-fix"></div>
		<!--页面尾部-->
	</div>
	<br />
	<iframe src="footer.html" frameborder="no" scrolling="no" style="display: block;" width="100%"></iframe>
</body>
</html>