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
#login{
	position: absolute;
	top: 50%;
	left: 50%
	margin: -150px 0 0 -150px;
	width: 300px;
	height: 300px;
}
#login h1{
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
	function checkyzm(){
		var code = document.getElementsByName("vcode")[0].value;
		var re = new XMLHttpRequest();
		re.open("POST", "yzm?code="+code,true);
		re.onreadystatechange = function(){
			if(re.readyState==4){
				var tipsEle = document.getElementById("tips");
				if(re.responseText=="fail"){
					tipsEle.innerHTML = "验证码不正确"; 
					tipsEle.style.color="red";
				}	
				else{
					tipsEle.innerHTML = "验证码正确"; 
					tipsEle.style.color="green";
				}
			}
		}
		re.send();	
	}
	
	function changeVCode(img){
		img.src = "yzm?xxxx="+ Math.random();
	}
</script>
</head>
<body>
<p id="login">
<h1>log in</h1>
<form action="dlfw.jsp" name="form1">
用户名<input type="text" name="username"><br/>
密码<input type="password" name="pwd"><br/>
验证码<input type="text" name="vcode" onblur="checkyzm()">
<br>
<img alt="" src="yzm" onclick="changeVCode(this)"><br/>
<div id="tips"></div>
<input type="submit" name="登录">
</form>
</body>
</html>