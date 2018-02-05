<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>标题</title>
	<link rel="stylesheet" href="css/top1.css" />
 <!-- 	<script type="text/javascript">
		function exit() {
			if(confirm("您确定要退出系统吗？")){
				return false;
			}
		}
	</script>  -->
	<script type="text/javascript"> 
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
	<div class="top">
			<div class="top1">
				<div class="top2">
					<a href="userlogin.jsp" class="a1" target="_parent">会员登录</a>|
					<a href="register.jsp" class="a1" target="_parent">会员注册</a>|
					<a href="QuitServlet" class="a1" target="_parent" onclick="exit()">注销退出</a>|
					<a href="deliever.html" class="a1" target="_parent">配送说明</a>|
					<a href="about.html" class="a1" target="_parent">关于我们</a>
				</div>
			</div><br />
			<div class="top3">
				<br /><br />
				<span class="span">亲爱的<font>${name }</font>您好，欢迎光临！</span>
				
				<div class="nav">
					<a href="IndexServlet" class="a2" target="_parent">首页</a>
					<a href="ShowMoreCartInfoServlet" class="a2" target="_parent"  onclick="return islogin()">我的餐车</a>
					<a href="order.jsp" class="a2" target="_parent" onclick="return islogin()" >我的订单</a>
					<a href="userUpdate.jsp" class="a2" target="_parent" >用户中心</a>
					<a href="deliever.html" class="a2" target="_parent">配送说明</a>
					<a href="about.html" class="a2" target="_parent">关于我们</a>
					<a href="MapView?method=showMap" class="a2" target="_parent">菜品热度</a>
					<a href="QuitServlet" class="a2" target="_parent" onclick="exit()">注销退出</a>
				</div>
			</div>
			<hr />
		</div>
</body>
</html>