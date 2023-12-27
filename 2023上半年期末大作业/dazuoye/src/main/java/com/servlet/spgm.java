package com.servlet;

import java.io.IOException;
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
 * Servlet implementation class spgm
 */
@WebServlet("/spgm")
public class spgm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public spgm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf-8");
		String number=request.getParameter("id");
		HttpSession session=request.getSession();
		String place=(String) session.getAttribute("place");
		String sq="select * from commodity where number='"+number+"'and place='"+place+"'";
		ResultSet rs=sql.query(sq);
		int sl=0,s2=0;
		try {
			if(rs.next()){
			sl=rs.getInt("quantity");
			s2=rs.getInt("newquantity");
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sl=sl-1;
		s2=s2+1;
		String sq1="update commodity set quantity='"+sl+"',newquantity='"+s2+"'where number='"+number+"'and place='"+place+"'";
		sql.update(sq1);
		place=new String(place.getBytes("utf-8"),"iso-8859-1");//转码
		response.sendRedirect("yhfw?place="+place+"");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
