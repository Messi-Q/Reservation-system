<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加菜品</title>
 <link rel="stylesheet" href="css/addmenu.css" />
</head>
<body>
	<div class="main">
		<div class="top"></div>
		<div class="list">添加菜品</div>
		<div class="body">
		<form action="FoodServlet?opt=add" method="post">
			<table border="1px" cellspacing="0px">
				<tr>
					<td class="c1">菜品名称:</td>
					<td class="c2"><input type="text" class="input1" name="foodName" /></td>
				</tr>
				<tr>
					<td class="c1">原料:</td>
					<td class="c2"><input type="text" class="input1" name="FoodIng" /></td>
				</tr>
				<tr>
					<td class="c1">市场价格:</td>
					<td class="c2"><input type="text" class="input1"  name="marketPrice"/></td>

				</tr>
				<tr>
					<td class="c1">会员价格:</td>
					<td class="c2"><input type="text" class="input1" name="vipPrice"/></td>

				</tr>
				<tr>
					<td class="c1">说明:</td>
					<td class="c2"><textarea class="textarea" name="FoodDesp"></textarea></td>
				</tr>
				<tr>
					<td class="c1">菜品类型:</td>
					<td class="c2">
						<select name="typeID">
						<c:forEach items="${st }" var="foods">
							<option value="${foods.typeId}">${foods.typeName}</option>
						</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td class="c1">上传图片:</td>
					<td class="c2"><input type="file" name="ImageUrl" /></td>

				</tr>
				<tr>
					<td colspan="2" class="c4"><input type="submit" value="添加" /></td>
				</tr>
			</table>
		</form>
		</div>
	</div>
</body>
</html>