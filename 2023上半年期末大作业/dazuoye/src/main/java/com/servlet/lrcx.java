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
import javax.servlet.http.HttpSession;

import com.entity.all;
import com.util.sql;

/**
 * Servlet implementation class lrcx
 */
@WebServlet("/lrcx")
public class lrcx extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public lrcx() {
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
		HttpSession session=request.getSession();
		String place=(String) session.getAttribute("place");
		try {
			String	sq="select commodity.*,profit.* from commodity,profit where commodity.number=profit.number and commodity.place='"+place+"'";
			ResultSet rs=sql.query(sq);
			List<all> splist=new ArrayList<all>();
				while(rs.next()){
					all a=new all();
					a.setNumber(rs.getString("number"));
					a.setName(rs.getString("name"));
					a.setPrice(rs.getInt("price"));
					a.setPlace(rs.getString("place"));
					a.setQuantity(rs.getInt("quantity"));	
					a.setOldprice(rs.getDouble("oldprice"));
					a.setProfit(rs.getDouble("profit"));
					splist.add(a);	
				}
				//sql.close();
				request.setAttribute("slist",splist);
			}
		catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		request.getRequestDispatcher("lr.jsp").forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
