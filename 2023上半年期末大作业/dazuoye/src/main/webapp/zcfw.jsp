<%@ page language="java" import="java.sql.*" contentType="text/html;  charset=utf-8" 
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<%
request.setCharacterEncoding("utf-8");
String username=request.getParameter("username");
String pwd1=request.getParameter("pwd1");
String pwd2=request.getParameter("pwd2");
String place=request.getParameter("place");
if(!pwd1.equals(pwd2)){
	out.print("密码重复<a href='zc.jsp'>返回</a>");
}
else{
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/dazuoye?characterEnding=utf-8","root","123456");
		Statement Stat=conn.createStatement();
		String sql="select * from user where username=?";
		PreparedStatement pstat=conn.prepareStatement(sql);
		pstat.setString(1, username);
		ResultSet rs=pstat.executeQuery();
		if(rs.next()){
			out.print("用户名已存在<a href='zc.jsp'>返回</a>");
		}
		else{
			String sq="insert into user(username,password,place) values(?,?,?)";
			pstat=conn.prepareStatement(sq);
			pstat.setString(1, username);
			pstat.setString(2, pwd1);
			pstat.setString(3,place);
			int res=pstat.executeUpdate();
			if(res==1){
				out.print("注册成功<a href='dl.jsp'>去登陆</a>");
			}
			else{
				out.print("注册失败<a href='zc.jsp'>返回</a>");
			}
		}
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
%>
</body>
</html>