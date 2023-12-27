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
import com.entity.profit;
import com.util.sql;

/**
 * Servlet implementation class spcbxg
 */
@WebServlet("/spcbxg")
public class spcbxg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public spcbxg() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String number=request.getParameter("id");
		String sq="select * from profit where number='"+number+"'";
		ResultSet rs=sql.query(sq);
		try {
			if(rs.next()){
				profit s=new profit();
				s.setNumber(rs.getInt("number"));
				s.setOldprice(rs.getDouble("oldprice"));
				request.setAttribute("sp",s);	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		request.getRequestDispatcher("spcbxg1.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		int number=Integer.parseInt(request.getParameter("number"));
		double oldquantity=Double.parseDouble(request.getParameter("oldquantity"));
		String sq="update profit set oldquantity='"+oldquantity+"'where number='"+number+"'";
		sql.update(sq);
		//place=new String(place.getBytes("utf-8"),"iso-8859-1");//转码
		response.sendRedirect("spcx");
	}

}
