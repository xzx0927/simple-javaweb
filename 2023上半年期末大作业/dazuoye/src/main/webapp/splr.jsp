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
<table border="1" class="table table-striped">
<tr>
<td>商品序号</td>
<td>商品名称</td>
<td>商品进价</td>
<td>商品价格</td>
<td>地点</td>
<td>商品数量</td>
<td>利润</td>
</tr>
<c:forEach var="sp" items="${slist}">
<tr>
<td>${sp.number}</td>
<td>${sp.name}</td>
<td>${sp.oldprice}</td>
<td>${sp.price}</td>
<td>${sp.place}</td>
<td>${sp.quantity}</td>
<td>${sp.profit}</td>
<td><a href="spcbxg?id=${sp.number}">修改</a></td>
<td><a href="splrjs?id=${sp.number}&place=${place}">计算</a></td>
</tr>
</c:forEach>
</table>
<a href="splrzj.jsp">增加</a>

</body>
</html>