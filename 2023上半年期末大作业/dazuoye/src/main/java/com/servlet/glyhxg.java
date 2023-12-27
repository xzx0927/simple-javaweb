package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.user;
import com.util.sql;

/**
 * Servlet implementation class glyhxg
 */
@WebServlet("/glyhxg")
public class glyhxg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public glyhxg() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String name=request.getParameter("id");
		String sq="select * from user where username='"+name+"'";
		ResultSet rs=sql.query(sq);
		try {
			if(rs.next()){
				user s=new user();
				s.setUsername(rs.getString("username"));
				s.setPassword(rs.getString("password"));
				s.setPriority(rs.getInt("priority"));
				s.setPlace(rs.getString("place"));
				request.setAttribute("user",s);	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		request.getRequestDispatcher("yhxg.jsp").forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String name=request.getParameter("username");
		String password=request.getParameter("password");
		int priority=Integer.parseInt(request.getParameter("priority"));
		String place=request.getParameter("place");
		String sq="update user set place='"+place+"',password='"+password+"',priority='"+priority+"' where username='"+name+"'";
		sql.update(sq);
		response.sendRedirect("glyhcx"); 	
	}
}
