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

import com.entity.commodity;
import com.util.sql;

/**
 * Servlet implementation class spcz1
 */
@WebServlet("/spcz1")
public class spcz1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public spcz1() {
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
			String	sq="select * from commodity where  number='"+username+"'or name='"+username+"'";
			ResultSet rs=sql.query(sq);
			List<commodity> splist=new ArrayList<commodity>();
				while(rs.next()){
					commodity s=new commodity();
					s.setNumber(rs.getString("number"));
					s.setName(rs.getString("name"));
					s.setPrice(rs.getDouble("price"));
					s.setPlace(rs.getString("place"));
					s.setQuantity(rs.getInt("quantity"));	
					splist.add(s);	
				}
				//sql.close();
				request.setAttribute("slist",splist);
			}
		catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		request.getRequestDispatcher("spgl.jsp").forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
