package com.kosmo.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ch99JDBCTestPractice {

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rss = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "kosmo", "0000");
			if(conn != null)
				System.out.println("conn success");
			else
				System.out.println("conn faild");
			
			String sql = "select empno ename from emp";
			pst = conn.prepareStatement(sql);
			rss = pst.executeQuery();
			
			while(rss.next()) {
				int num = rss.getInt("empno");
				String name = rss.getString("ename");
				
				System.out.println(num + "\t" + name);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(rss != null) rss.close();
				if(pst != null) pst.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
