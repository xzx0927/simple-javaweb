<%@page import="java.util.ArrayList"%>
<%@ page language="java" import="java.util.List,com.entity.user" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.4.1/css/bootstrap.min.css ">
</head>
<body>
 <form action="yhcz" method="post">
   <input type="text" name="name" placeholder="请输入用户名">
   <input type="submit"  value="查找" class="btn btn-primary btn-sm">
  </form>
<table border="1" class="table table-striped">
<tr>
<td>用户</td>
<td>密码</td>
<td>优先级</td>
<td>地点</td>
</tr>
<c:forEach var="use" items="${userlist}">
<tr>
<td>${use.username}</td>
<td>${use.password}</td>
<td>${use.priority}</td>
<td>${use.place}</td>
<td><a href="glyhdele?id=${use.username}">删除</a></td>
<td><a href="glyhxg?id=${use.username}">编辑</a></td>
</tr>
</c:forEach>
</table>
<a href="yh.jsp">增加</a>
</body>
</html>