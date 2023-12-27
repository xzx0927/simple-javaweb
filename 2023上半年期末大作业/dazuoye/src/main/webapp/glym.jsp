<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
}

html, body {
	width: 100%;
	height: 100%;
}

.container {
	width: 100%;
	height: 100%;
	display: flex;
}

.aside {
	width: 300px;
	height: 100%;
	background: #304156;
}

.main {
	width: 100%;
	height: 100%;
	flex:1;
	background: #e2e2e2;
}

.header {
	width: 100%;
	height: 35px;
	line-height: 35px;
	border: 1px solid #EBEEF5;
	padding: 10px;
}

.content {
	width: 98%;
	height: 100%;
	background-color: white;
	border-radius: 5px;
	margin: 0 auto;
}
.menus {
	list-style: none;
	text-align: center;
}

.menu_item {
	height: 45px;
	line-height: 45px;
	padding: 5px 0;
}

.menu_item a {
	text-decoration: none;
	color: white;
	font-size: 20px;
}

.home {
	background-color: #1f2d3d;
}
 </style>
<script type="text/javascript">
	function goto(dest) {
		var ele = document.getElementById("rightArea");
		ele.src=dest;
	}
</script>
</head>
<body >
<%
request.setCharacterEncoding("utf-8");
String username=(String) session.getAttribute("name");
%>
<div class="container" >
		<div class="aside">
			<div style="text-align: center; margin: 10px 0;">
				<img alt="" src="static/img/R-C.png" width=100px height=100px>
				<h1 style="color: white;">管理系统</h1>
			</div>
			<div>
				<ul class="menus">
					<li class="menu_item home"><a href="">首页</a></li>
					<li class="menu_item"><a href="javascript:goto('glyhcx')">用户管理</a></li>
					<li class="menu_item"><a href="javascript:goto('splrcx')">商品利润</a></li>
					<li class="menu_item"><a href="javascript:goto('glspcx')">商品管理</a></li>
				</ul>
			</div>
		</div>
		<div class="main">
			<div class="header">欢迎最高管理员<%out.print(username); %><a href="dl.jsp">退出</a>
			</div>
			<div class="content">
				<iframe style="width: 100%;height: 100%;" id="rightArea" src="sy.jsp" frameborder="no"></iframe>
			</div>
		</div>
	</div>
</body>
</html>