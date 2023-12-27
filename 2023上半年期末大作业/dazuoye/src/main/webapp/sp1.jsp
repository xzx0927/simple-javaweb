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
<form action="spzj" method="post">
编号：<input type="text" name="number">(只能增加已有的商品编号)<br/>
商品名称：<input type="text" name="name"><br/>
价格 <input type="text" name="price"><br/>
数量：<input type="text" name="quantity"><br/>
<input type="hidden" name="place" value="<%=place%>"><br/>
<input type="submit" name="提交">
</form>
</body>
</html>