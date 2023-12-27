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

import com.entity.commodity;
import com.util.sql;

/**
 * Servlet implementation class glspcx
 */
@WebServlet("/glspcx")
public class glspcx extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public glspcx() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		try {
			String	sq="select * from commodity";
			ResultSet rs=sql.query(sq);
			List<commodity> splist=new ArrayList<commodity>();
				while(rs.next()){
					commodity s=new commodity();
					s.setNumber(rs.getString("number"));
					s.setName(rs.getString("name"));
					s.setPrice(rs.getDouble("price"));
					s.setPlace(rs.getString("place"));
					s.setQuantity(rs.getInt("quantity"));	
					s.setTag(rs.getInt("tag"));
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
