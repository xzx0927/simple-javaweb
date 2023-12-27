package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.util.sql;

/**
 * Servlet implementation class dlfw
 */
@WebServlet("/dlfw")
public class dlfw extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dlfw() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		request.setCharacterEncoding("utf-8");
		String username=request.getParameter("username");
		String pwd=request.getParameter("pwd");
		PrintWriter out=response.getWriter();
			String sq1="select * from user where username='"+username+"' and password='"+pwd+"'";
			String sq2="select * from user where username='"+username+"'";
			ResultSet rs=sql.query(sq1);
			ResultSet rss=sql.query(sq2);
			String place=null,name=null;
			try {
				if(rs.next()){
					while(rss.next())
						{
						HttpSession session=request.getSession();
						place=rs.getString("place");
						name=rs.getString("username");
						session.setAttribute("place",place);
						session.setAttribute("name",username);
						if(rss.getString("priority").equals("3")){
							out.print("欢迎最高管理员登录");
							response.sendRedirect("glym");
						}
						else if(rss.getString("priority").equals("2")){
							out.print("欢迎管理员登录");
							response.sendRedirect("glym1");
						}
						else if(rss.getString("priority").equals("1")){
							out.print("欢迎用户登录");
							response.sendRedirect("yhym");
						}
					}out.print("登陆成功");
				}
				else
					{
					out.print("登陆失败，用户名或密码错误<a href='dl.jsp'>返回</a>");
					}
			} catch (SQLException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


