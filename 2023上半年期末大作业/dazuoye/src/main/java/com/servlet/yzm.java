package com.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class yzm
 */
@WebServlet("/yzm")
public class yzm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public yzm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 在内存中创建一张图片
		BufferedImage image = new BufferedImage(120, 35, BufferedImage.TYPE_INT_RGB);
		// 得到图片
		Graphics g = image.getGraphics();
		g.setColor(new Color(200,200,200));
		g.fillRect(0,0,120,35);
		Random rd  = new Random();
		int randNum = rd.nextInt(8999)+1000;
		String randStr = String.valueOf(randNum);
		HttpSession session = request.getSession();
		session.setAttribute("randStr",randStr);
		g.setColor(Color.black);
		g.setFont(new Font("隶书",Font.PLAIN,32));
		g.drawString(randStr,10,30);
		for(int i = 0; i < 100; i++)
		{
			int x = rd.nextInt(120);
			int y = rd.nextInt(35);
			g.drawOval(x,y, 1,1);
		}
		
		ImageIO.write(image,"JPEG",response.getOutputStream());		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String code = request.getParameter("code");
		HttpSession session = request.getSession();
		String ori_code = (String)session.getAttribute("randStr");
		if(code.equals(ori_code)) {
			out.print("success");
		}
		else {
			out.print("fail");
		}		
	}

}

