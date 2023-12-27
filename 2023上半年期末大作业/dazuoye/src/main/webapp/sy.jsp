<%@page import="java.util.ArrayList"%>
<%@ page language="java" import="java.util.List,com.util.sql,com.entity.commodity,java.sql.*" contentType="text/html; charset=UTF-8"
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
<%
request.setCharacterEncoding("utf-8");
		try {
			String	sq="select * from commodity";
			ResultSet rs=sql.query(sq);
			List<commodity> splist=new ArrayList<commodity>();
				while(rs.next()){
					commodity s=new commodity();
					s.setNumber(rs.getString("number"));
					s.setName(rs.getString("name"));
					s.setPrice(rs.getInt("price"));
					s.setPlace(rs.getString("place"));
					s.setQuantity(rs.getInt("quantity"));	
					splist.add(s);	
				}
				//sql.close();
				request.setAttribute("slist",splist);
			}
		catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			%>
<table border="1" class="table table-striped">
<tr>
<td>商品序号</td>
<td>商品名称</td>
<td>商品价格</td>
<td>地点</td>
<td>商品数量</td>
</tr>
<c:forEach var="sp" items="${slist}">
<tr>
<td>${sp.number}</td>
<td>${sp.name}</td>
<td>${sp.price}</td>
<td>${sp.place}</td>
<td>${sp.quantity}</td>
</tr>
</c:forEach>
</table>
</body>
</html>