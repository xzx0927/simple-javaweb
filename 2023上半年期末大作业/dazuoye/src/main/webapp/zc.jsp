<%@ page language="java" import="java.sql.*" contentType="text/html;  charset=utf-8" 
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<style type="text/css">
html{	
	width: 100%;
	height: 100%;
	overflow: hidden;
	font-style: sans-serif;
}
body{
	text-align: center;
	width: 100%;
	height: 100%;
	font-family: 'Open Sans', sans-serif;
	margin: 0;
	background-color: #4A374A;
}
#register{
	position: absolute;
	top: 50%;
	left: 50%
	margin: -150px 0 0 -150px;
	width: 300px;
	height: 300px;
}
#register h1{
	color: #fff;
	text-shadow:0 0 10px;
	letter-spacing: 1px;
	text-align: center;   
}   
h1{
	font-size: 2em;
	margin: 0.67em 0;
}   
input{
	width: 278px;
	margin-bottom: 10px;
	outline: none;
	padding: 10px;
	font-size: 13px;
	color: #fff;
	border-top: 1px solid #312E3D;
	border-left: 1px solid #312E3D;
	border-right: 1px solid #312E3D;
	border-bottom: 1px solid #56536A;
	border-radius: 4px;
	background-color: #2D2D3F;
}
subit{
	width: 300px;
	min-height: 40px;
	background-color: #4a77d4;
	border: 1px solid #3762bc;
	color: #fff;
	padding: 9px 14px;
	font-size: 15px;
	line-height: normal;
	border-radius: 5px;
	margin: 0;
}</style>
<script type="text/javascript">
	function checkusername(){
		var ele = document.getElementsByName("username");
		var username = ele[0].value; 
		var re = new XMLHttpRequest();
		re.open("GET", "zcpd?username="+username,true);
		re.onreadystatechange = function(){
			if(re.readyState==4){
				var tipsEle = document.getElementById("tips");
				if(re.responseText=="fail"){
					tipsEle.innerHTML = "该用户名已存在！"; 
					tipsEle.style.color="red";
				}	
				else{
					tipsEle.innerHTML = "该用户名可以使用！"; 
					tipsEle.style.color="green";
				}
			}
		}
		re.send();		
	}
</script>
</head>
<body>
<p id="register">
<h1>REGISTER</h1>
	<form name=form1 action="zcfw.jsp" method="post">
		用户名:<input type="text" id="username" name="username" onblur="checkusername()">
		<span id="tips"></span><br/>
		密码:<input type="password" name="pwd1"><br/>
		确认密码:<input type="password" name="pwd2"><br/>
		所属位置：<input type="text" name="place"><br/>
		<input type="submit" value="注册">	
	</form>
</body>
</html>