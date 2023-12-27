<%@page import="java.util.ArrayList"%>
<%@ page language="java" import="java.util.List,com.entity.commodity" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.4.1/css/bootstrap.min.css ">
</head>
<body>
<form action="spcz" method="post" >
   <input type="text" name="name" placeholder="请输入商品序号或者商品名称">
   <input type="submit"  value="查找" class="btn btn-primary btn-sm">
</form>
<table border="1" class="table table-striped">
<tr>
<td>商品序号</td>
<td>商品名称</td>
<td>商品价格</td>
<td>商品数量</td>
</tr>
<c:forEach var="sp" items="${slist}">
<tr>
<td>${sp.number}</td>
<td>${sp.name}</td>
<td>${sp.price}</td>
<td>${sp.quantity}</td>
<td>${sp.tag}</td>
<td><a href="spdele?id=${sp.tag}">删除</a></td>
<td><a href="spxg2?id=${sp.tag}">编辑</a></td>
</tr>
</c:forEach>
</table>
<a href="sp1.jsp">增加</a>
</body>
</html>