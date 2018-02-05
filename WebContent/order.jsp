<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>我的订单</title>
	<link rel="stylesheet" href="css/order.css" />
</head>
	<body>
		<iframe src="tops.jsp" scrolling="no" frameborder="no" width="100%"></iframe>
		<div>
			<table align="center" cellspacing="0">
				<tr>
					<td width="200" class="font1">按菜品名称查询</td>
					<td colspan="2"><input type="text" />
					<input type="submit" value="查询"/></td>
				</tr>
				<tr>
					<td class="font1">按销售日期查询</td>
					<td colspan="2"><input type="text" />
					<input type="submit" value="查询"/></td>
				</tr>
				<tr align="center">
					<td colspan="3" class="font2">
						<a href="#">我的所有订单</a>  <a href="#">未派送订单</a>  <a href="#">已派送订单</a></td>
				</tr>
			</table>
		</div>
		
		<div>
			<table align="center" style="margin-top: 20px;" cellspacing="0">
				<tr class="font1">
					<td colspan="9">订单查询结果信息列表</td>
				</tr>
				<tr class="font1">
					<td width="100">菜单名称</td>
					<td width="100">真实姓名</td>
					<td width="140">订购电话</td>
					<td>派送地址</td>
					<td>订购数量</td>
					<td>单价(元)</td>
					<td>合计(元)</td>
					<td width="180">订购时间</td>
					<td>是否派送</td>
				</tr>
				<tr>
					<td>粉蒸肉</td>
					<td>？？</td>
					<td>18062556380</td>
					<td>？人</td>
					<td>1</td>
					<td>23.0</td>
					<td>23.0</td>
					<td>2017-04-24 16:40:14</td>
					<td>否</td>
				</tr>
				<tr>
					<td>咸肉菜饭</td>
					<td>？？</td>
					<td>18062556380</td>
					<td>？人</td>
					<td>1</td>
					<td>12.0</td>
					<td>12.0</td>
					<td>2017-04-24 16:40:14</td>
					<td>否</td>
				</tr>
				<tr>
					<td>五香驴肉</td>
					<td>？？</td>
					<td>18062556380</td>
					<td>？人</td>
					<td>1</td>
					<td>21.0</td>
					<td>21.0</td>
					<td>2017-04-24 16:40:14</td>
					<td>否</td>
				</tr>
				<tr>
					<td>黄瓜拉皮</td>
					<td>？？</td>
					<td>18062556380</td>
					<td>？人</td>
					<td>1</td>
					<td>6.0</td>
					<td>6.0</td>
					<td>2017-04-24 16:40:14</td>
					<td>否</td>
				</tr>
				<tr>
					<td>水煮鱼</td>
					<td>？？</td>
					<td>18062556380</td>
					<td>？人</td>
					<td>1</td>
					<td>32.0</td>
					<td>32.0</td>
					<td>2017-04-24 16:40:14</td>
					<td>否</td>
				</tr>
				
			</table>
		</div><br /><br />
		<iframe src="footer.html" scrolling="no" frameborder="no" width="100%"></iframe>
	</body>

</html>