package com.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.user;
import com.util.sql;

/**
 * Servlet implementation class splrjs
 */
@WebServlet("/splrjs")
public class splrjs extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public splrjs() {
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
		int number=Integer.parseInt(request.getParameter("id"));
		String place=request.getParameter("place");
		String	sq="select commodity.*,profit.* from commodity,profit where commodity.number=profit.number and commodity.place='"+place+"'and commodity.number='"+number+"'";
		ResultSet rs=sql.query(sq);
		int numbers=0,quantity=0,newquantity=0;
		double oldprice=0,price=0,profit=0;
		try {
			if(rs.next()){
			numbers=rs.getInt("number");
			oldprice=rs.getDouble("oldprice");
			price=rs.getDouble("price");
			quantity=rs.getInt("quantity");
			newquantity=rs.getInt("newquantity");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		profit=(price-oldprice)*newquantity;
		String sq1="update commodity  set profit='"+profit+"'where number='"+number+"'and place='"+place+"'";
		sql.update(sq1);
		response.sendRedirect("splrcx");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}
		
}
