<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
request.setCharacterEncoding("utf-8");
String place=(String) session.getAttribute("place");
%>
<form action="spxg2" method="post">
<input type="hidden" name="number" value="${sp.number}">
名称 <input type="text" name="name" value="${sp.name}"><br/>
价格：<input type="text" name="price" value="${sp.price}"><br/>
数量：<input type="text" name="quantity" value="${sp.quantity}"><br/>
<input type="hidden" name="place" value="<%=place%>">
<input type="hidden" name="tag" value="${sp.tag}">
<input type="submit" name="提交">
</form>
</body>
</html>