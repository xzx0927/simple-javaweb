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
String pwd=request.getParameter("pwd");
try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/dazuoye?characterEnding=utf-8","root","123456");
	Statement Stat=conn.createStatement();
	String sql="select * from user where username=? and password=?";
	String sq="select * from user where username='"+username+"'";
	PreparedStatement pstat=conn.prepareStatement(sql);
	PreparedStatement pstats=conn.prepareStatement(sq);
	pstat.setString(1, username);
	pstat.setString(2, pwd);
	ResultSet rs=pstat.executeQuery();
	ResultSet rss=pstats.executeQuery();
	String place=null,name=null;
	if(rs.next()){
		while(rss.next())
			{
			place=rs.getString("place");
			name=rs.getString("username");
			session.setAttribute("place",place);
			session.setAttribute("name",username);
			if(rss.getString("priority").equals("3")){
				out.print("欢迎最高管理员登录<a href='glym.jsp?username="+username+"'>进入</a>");
			}
			else if(rss.getString("priority").equals("2")){
				out.print("欢迎管理员登录<a href='glym1.jsp?username="+username+"'>进入</a>");
			}
			else if(rss.getString("priority").equals("1")){
				out.print("欢迎用户登录<a href='yhym.jsp?username="+username+"'>进入</a>");
			}
		}out.print("登陆成功");
	}
	else
		{
		out.print("登陆失败，用户名或密码错误<a href='dl.jsp'>返回</a>");
		}
}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
%>

</body>
</html>