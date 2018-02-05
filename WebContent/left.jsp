<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/left.css" />
</head>
<body>
<div class="main">
			<div class="menu">
				<div class="menu_head">
					类别信息
				</div>
				<div class="menu_body">
					<img src="img/menu_topline.gif"/>
					<a href="FoodTypeServlet?opt=queryAlls" target="right">添加新菜单</a>
					<a href="FoodServlet?opt=findAll" target="right">菜单信息列表</a>
				</div>
			</div>
			<div class="menu">
				<div class="menu_head">
					菜单类别管理
				</div>
				<div class="menu_body">
					<img src="img/menu_topline.gif"/>
					<a href="addtype.jsp" target="right">添加新类别</a>
					<a href="FoodTypeServlet?opt=queryAll" target="right">类别信息列表</a>
				</div>
			</div>
			<div class="menu">
				<div class="menu_head">
					公告信息管理
				</div>
				<div class="menu_body">
					<img src="img/menu_topline.gif"/>
					<a href="addNotice.jsp" target="right">添加新公告</a>
					<a href="NoticeServlet?opt=select" target="right">通知信息列表</a>
				</div>
			</div>
			<div class="menu">
				<div class="menu_head">
					销售订单管理
				</div>
				<div class="menu_body">
					<img src="img/menu_topline.gif"/>
					<a href="sellList" target="right">销售订单信息列表</a>
					<a href="queryOrder" target="right">销售订单查询</a>
					<a href="totalSell" target="right">本日销售统计</a>
				</div>
			</div>
			<div class="menu">
				<div class="menu_head">
					大数据展示
				</div>
				<div class="menu_body">
					<img src="img/menu_topline.gif"/>
					<a href="ShowFile?method=showAll&nowPage=1&path=/user" target="right">查看文件</a>
					<a href="MapView?method=mapReduce" class="a2" target="_parent">统计热度</a>
				</div>
			</div>
			<div class="menu">
				<div class="menu_head">
					<a href="userManage.jsp?adminName=<%=request.getParameter("adminName")%>&adminId=<%=request.getParameter("adminId")%>" target="right">系统用户管理</a>
				</div>
			</div>
			</div>
			<div class="menu">
				<div class="menu_head">
					<a href="login.jsp" target="_parent">注销退出</a>
				</div>
			</div>
		
</body>
</html>