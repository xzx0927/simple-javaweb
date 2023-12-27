package com.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.user;
import com.util.sql;

/**
 * Servlet implementation class yhcz
 */
@WebServlet("/yhcz")
public class yhcz extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public yhcz() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String username=request.getParameter("name");
		try {
			String sq="select * from user where priority!='"+3+"'and username='"+username+"'";
			ResultSet rs=sql.query(sq);
			List<user> userlist=new ArrayList<user>();
				while(rs.next()){
					user s=new user();
					s.setUsername(rs.getString("username"));
					s.setPassword(rs.getString("password"));
					s.setPriority(rs.getInt("priority"));
					s.setPlace(rs.getString("place"));
					userlist.add(s);	
				}
				//sql.close();
				request.setAttribute("userlist",userlist);
			}
		catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		request.getRequestDispatcher("yhgl.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
