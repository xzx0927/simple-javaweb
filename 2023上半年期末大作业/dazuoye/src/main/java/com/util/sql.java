package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import java.sql.SQLException;

public class sql {
	private static Statement pstat;
	private static ResultSet rs;
	private static Connection conn;

	private static void getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dazuoye?characterEncoding=utf-8", "root", "123456");
			pstat = conn.createStatement();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static int update(String sql) {
		// 字符串的拼接
		try {
			getConnection();
			int rs = pstat.executeUpdate(sql);
			close();
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	public static ResultSet query(String sql) {
		// 字符串的拼接
		try {
			getConnection();
			ResultSet rs = pstat.executeQuery(sql);			
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static void close() {		
		try {
			if(rs!=null) {
				rs.close();
			}
			if(pstat!=null) {
				pstat.close();
			}
			if(conn!=null) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

}
