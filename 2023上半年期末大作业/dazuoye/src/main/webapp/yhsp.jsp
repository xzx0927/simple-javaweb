<%@page import="java.util.ArrayList"%>
<%@ page language="java" import="java.util.List,com.entity.commodity" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<tr>
<td>商品序号</td>
<td>商品名称</td>
<td>商品价格</td>
<td>商品地点</td>
<td>商品数量</td>
</tr>
<c:forEach var="sp" items="${slist}">
<tr>
<td>${sp.number}</td>
<td>${sp.name}</td>
<td>${sp.price}</td>
<td>${sp.place}</td>
<td>${sp.quantity}</td>
<td><a href="spgm?id=${sp.number}">购买</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>