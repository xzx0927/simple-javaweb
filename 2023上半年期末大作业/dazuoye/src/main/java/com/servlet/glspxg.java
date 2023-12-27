package com.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.commodity;
import com.util.sql;

/**
 * Servlet implementation class glspxg
 */
@WebServlet("/glspxg")
public class glspxg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public glspxg() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String tag=request.getParameter("id");
		String sq="select * from commodity where tag='"+tag+"'";
		ResultSet rs=sql.query(sq);
		try {
			if(rs.next()){
				commodity s=new commodity();
				s.setNumber(rs.getString("number"));
				s.setName(rs.getString("name"));
				s.setPrice(rs.getDouble("price"));
				s.setQuantity(rs.getInt("quantity"));
				s.setPlace(rs.getString("place"));
				s.setTag(rs.getInt("tag"));
				request.setAttribute("sp",s);	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		request.getRequestDispatcher("spxg.jsp").forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String number=request.getParameter("number");
		String name=request.getParameter("name");
		double price=Double.parseDouble(request.getParameter("price"));
		int quantity=Integer.parseInt(request.getParameter("quantity"));
		String place=request.getParameter("place");
		int tag=Integer.parseInt(request.getParameter("tag"));
		String sq="update commodity set number='"+number+"',name='"+name+"',price='"+price+"',quantity='"+quantity+"',place='"+place+"'where tag='"+tag+"'";
		sql.update(sq);
		response.sendRedirect("glspcx"); 	
	}

}
