<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>菜单类别</title>
<link rel="stylesheet" href="css/addmenu.css" />
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
			类别信息列表
		</div>
		<div class="body">
			<table border="1" cellspacing="0px">
			<caption>类别信息列表</caption>
			<tr>
				<th>类别ID</th>
				<th>类别名称</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${fist}" var="type">
				<tr>
					<td>${type.typeId }</td>
					<td>${type.typeName  }</td>
					<td><a href="FoodTypeServlet?opt=findId&id=${type.typeId }">修改</a>&nbsp;&nbsp;<a href="FoodTypeServlet?opt=del&id=${type.typeId }" onClick="delcfm()">删除</a></td>
				</tr>
			</c:forEach>
		</table>
		</div>
		</div>
</body>
</html>