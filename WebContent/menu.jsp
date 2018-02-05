<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>菜单信息</title>
<link rel="stylesheet" href="css/menu.css" />
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
		<div class="list">菜单信息</div>
		<div class="body">
			<table border="1px" cellspacing="0px">
				<caption>菜单信息列表</caption>
				<tr>
					<th>菜单名称</th>
					<th>展示图片</th>
					<th>原料</th>
					<th>类型</th>
					<th>说明</th>
					<th>市场价格</th>
					<th>市场价销售数据</th>
					<th>会员单价</th>
					<th>会员价销售数量</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${pager.currentPagedText }" var="ds">
					<tr>
						<td>${ds.foodName }</td>
						<td><img src="img/${ds.imageUrl }" /></td>
						<td>${ds.foodIng }</td>
						<td>${ds.typeName }</td>
						<td>${ds.foodDesp }</td>
						<td>${ds.marketPrice }</td>
						<td>0</td>
						<td>${ds. vipPrice}</td>
						<td>0</td>
						<td><a href="FoodServlet?opt=find&id=${ds.foodId}">修改</a>&nbsp;
							<a href="#" onClick="delcfm()">删除</a></td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="11">
						第${pager.currentPage }页
 						共${pager.totalPage}页
						<c:if test="${pager.currentPage==1}">
							<c:out value="[首页] [上一页]"></c:out>
						</c:if> 
						<c:if test="${pager.currentPage != 1}">
							<!-- 变 -->
							<A HREF="FoodServlet?opt=findAll&currentPage=1">[首页]</A>
							<A HREF="FoodServlet?opt=findAll&currentPage=${pager.currentPage-1}">[上一页]</A>
						</c:if> 
						<c:if test="${pager.currentPage==pager.totalPage}">
							<c:out value="[下一页] [尾页]"></c:out>
						</c:if> 
						<c:if test="${pager.currentPage != pager.totalPage}">
							<A HREF="FoodServlet?opt=findAll&currentPage=${pager.currentPage+1 }">[下一页]</A>
							<A HREF="FoodServlet?opt=findAll&currentPage=${pager.totalPage }">[尾页]</A>
						</c:if>
					</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>