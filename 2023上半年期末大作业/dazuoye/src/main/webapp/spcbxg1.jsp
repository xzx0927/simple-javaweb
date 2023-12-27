<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="spcbxg" method="post">
序号：<input type="text" name="number" disabled="disabled" value="${sp.number}"><br/>
价格：<input type="text" name="price" value="${sp.oldprice}"><br/>
<input type="submit" name="提交">
</form>
</body>
</html>