<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="glspxg" method="post">
序号：<input type="text" name="number" value="${sp.number}"><br/>
名称 <input type="text" name="name" value="${sp.name}"><br/>
价格：<input type="text" name="price" value="${sp.price}"><br/>
数量：<input type="text" name="quantity" value="${sp.quantity}"><br/>
地点：<input type="text" name="place" value="${sp.place}"><br/>
<input type="hidden" name="tag" value="${sp.tag}">
<input type="submit" name="提交">
</form>
</body>
</html>