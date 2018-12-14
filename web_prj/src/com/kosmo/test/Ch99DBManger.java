package com.kosmo.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ch99DBManger {
	public Connection dbConn() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");  //forname 에서 모든  데이터베이스를 이용하기 위한 메소드를 메모리에 올려준다.
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "kosmo", "0000");
			if(conn != null)
				System.out.println("conn success");
			else
				//오타, ojdbc.jar, 네트워크 회선 문제
				System.out.println("conn faild");
		} catch (SQLException e) {
			e.printStackTrace();
		} //getConnection 이 static이기 때문에 new 안해도 된다.
		
		return conn;
	}
	
	public void dbClose(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		try {
			if(rs != null)  rs.close();
			if(pstmt != null)  pstmt.close();
			if(conn != null)  conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void dbClose(PreparedStatement pstmt, Connection conn) {
		try {
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
