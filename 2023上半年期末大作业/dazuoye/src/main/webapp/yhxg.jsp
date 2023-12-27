<%@ page language="java" import="java.util.List,com.entity.user" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<form action="glyhxg" method="post">
用户名：<input type="text" name="username" value="${user.username}"><br/>
密码 <input type="text" name="password" value="${user.password}"><br/>
优先级：<input type="text" name="priority" value="${user.priority}" placeholder="请输入1,2或3"><br/>
地点：<input type="text" name="place" value="${user.place}"><br/>
<input type="submit" name="提交">
</form>
</body>
</html>