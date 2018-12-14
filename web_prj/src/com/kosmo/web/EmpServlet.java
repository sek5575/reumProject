package com.kosmo.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class EmpServlet
 */
@WebServlet("/emp")
public class EmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Ch99JDBCImpl t = new Ch99JDBCImpl();
//		ArrayList<EmpVO> list = t.empList();
//		EmpServlet est = new EmpServlet();
//		request.setAttribute("KEY_LIST", list);
//		request.getRequestDispatcher("style_test.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Ch99JDBCImpl t = new Ch99JDBCImpl();
		Gson gson = new Gson();
		
		
		//---------------------------------------------
		//1-1.String으로 들어와서 String으로 보내는 경우
		//searchColumn=deptno&searchStr=10
		//"[
		//	{"empno":6666,"ename":"rrr","mgr":0,"sal":0,"comm":0,"deptno":0},
		//	{"empno":7782,"ename":"CLARK","mgr":0,"sal":0,"comm":0,"deptno":0}
		//]"
		//---------------------------------------------
		String searchColumn = request.getParameter("searchColumn");	//전달된  String데이터
		String searchStr = request.getParameter("searchStr");		//전달된  String데이터
		ArrayList<EmpVO> list = t.empListint(searchColumn, searchStr);
		String gsonStr = gson.toJson(list);							//String변환
		System.out.println(gsonStr);

		PrintWriter out = response.getWriter(); 					//응답 데이터 타입:String
		out.println(gsonStr);
		
		
		//---------------------------------------------
		//1-2.StringJson으로 들어와서 String으로 보내는 경우
		//MYKEY="{"searchColumn":"deptno", "searchStr":"10"}"
		//"[
		//	{"empno":6666,"ename":"rrr","mgr":0,"sal":0,"comm":0,"deptno":0},
		//	{"empno":7782,"ename":"CLARK","mgr":0,"sal":0,"comm":0,"deptno":0}
		//]"
		//---------------------------------------------
//		String strJson = request.getParameter("MYKEY");	//전달된  String데이터{json표기유형}
//		System.out.println(strJson);
//		
//		SearchVO svo = gson.fromJson(strJson, SearchVO.class);
//		
//		ArrayList<EmpVO> list = t.empListint(svo.getSearchColumn(), svo.getSearchStr());
//		String gsonStr = gson.toJson(list);						//String변환
//		System.out.println(gsonStr);
//		
//		PrintWriter out = response.getWriter();					//응답 데이터 타입:String
//		out.println(gsonStr);
		
		
		
		//---------------------------------------------
		//2.String으로 들어와서 Json으로 보내는 경우
		//searchColumn=deptno&searchStr=10
		//[
		//	{"empno":6666,"ename":"rrr","mgr":0,"sal":0,"comm":0,"deptno":0},
		//	{"empno":7782,"ename":"CLARK","mgr":0,"sal":0,"comm":0,"deptno":0}
		//]
		//---------------------------------------------
//		String searchColumn = request.getParameter("searchColumn");	//전달된  String데이터
//		String searchStr = request.getParameter("searchStr");
//		ArrayList<EmpVO> list = t.empListint(searchColumn, searchStr);
//		String gsonStr = gson.toJson(list);							//String변환
//		System.out.println(gsonStr);
//		
//		response.setContentType("application/json; encoding=UTF-8"); //응답 데이터 타입:JSON
//		PrintWriter out = response.getWriter();
//		out.println(gsonStr);
		
		
		
		/*//---------------------------------------------
		//3.Json으로 들어와서 String으로 보내는 경우
		//{"searchColumn":"deptno", "searchStr":"10"}
		//"[
		//	{"empno":6666,"ename":"rrr","mgr":0,"sal":0,"comm":0,"deptno":0},
		//	{"empno":7782,"ename":"CLARK","mgr":0,"sal":0,"comm":0,"deptno":0}
		//]"
		//---------------------------------------------
		String jsonStr = request.getReader().lines().collect(Collectors.joining());	//전달된  Json데이터
		System.out.println(jsonStr);
		SearchVO svo = gson.fromJson(jsonStr, SearchVO.class);  //vo로
		
		ArrayList<EmpVO> list = t.empListint(svo.getSearchColumn(), svo.getSearchStr());
		String gsonStr = gson.toJson(list);						//String변환
		System.out.println(gsonStr);
		
		PrintWriter out = response.getWriter();					//응답 데이터 타입:String
		out.println(gsonStr);
		*/
		
		/*
		//---------------------------------------------
		//4.Json으로 들어와서 Json으로 보내는 경우
		//{"searchColumn":"deptno", "searchStr":"10"}
		//[
		//	{"empno":6666,"ename":"rrr","mgr":0,"sal":0,"comm":0,"deptno":0},
		//	{"empno":7782,"ename":"CLARK","mgr":0,"sal":0,"comm":0,"deptno":0}
		//]
		//---------------------------------------------
		String jsonStr = request.getReader().lines().collect(Collectors.joining());	//전달된  Json데이터
		System.out.println(jsonStr);
		SearchVO svo = gson.fromJson(jsonStr, SearchVO.class);
		
		ArrayList<EmpVO> list = t.empListint(svo.getSearchColumn(), svo.getSearchStr());
		String gsonStr = gson.toJson(list);							//String변환
		System.out.println(gsonStr);
		
		response.setContentType("application/json; encoding=UTF-8"); //응답 데이터 타입:JSON
		PrintWriter out = response.getWriter();
		out.println(gsonStr);
		*/
	}
	

	
	
	//****************************servlet에는 코딩을 하면 안된다. 아래코드는 dbcompl에서 간져온걸로***************************************
	public ArrayList<EmpVO> empList(String select, String empsl) {
		ArrayList<EmpVO> list = new ArrayList<EmpVO>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");  //forname 에서 모든  데이터베이스를 이용하기 위한 메소드를 메모리에 올려준다.
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			//DriverManager d = new DriverManager();
			//d.getConnection(    );   생성자가 private로 묶여있다 new 할수 없다.
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "kosmo", "0000"); //getConnection 이 static이기 때문에 new 안해도 된다.
			if(conn != null)
				System.out.println("conn success");
			else
				//오타, ojdbc.jar, 네트워크 회선 문제
				System.out.println("conn faild");
			System.out.println(select+ " = "+ empsl);
			//String sql = "select * from emp where " + select + "=?";
			//String sql = "select * from emp where " + select + " LIKE '%' || ? || '%'";
			String sql = "select * from emp where " + select + " LIKE ?";
			//System.out.println(sql);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + empsl + "%");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				EmpVO evo = new EmpVO();
				evo.setEmpno(rs.getInt("empno"));
				evo.setJob(rs.getString("job"));
				evo.setDeptno(rs.getInt("deptno"));
				evo.setEname(rs.getString("ename"));
				evo.setHiredate(rs.getString("hiredate"));
				list.add(evo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	public ArrayList<EmpVO> empList() {
		ArrayList<EmpVO> list = new ArrayList<EmpVO>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");  //forname 에서 모든  데이터베이스를 이용하기 위한 메소드를 메모리에 올려준다.
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			//DriverManager d = new DriverManager();
			//d.getConnection(    );   생성자가 private로 묶여있다 new 할수 없다.
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "kosmo", "0000"); //getConnection 이 static이기 때문에 new 안해도 된다.
			if(conn != null)
				System.out.println("conn success");
			else
				//오타, ojdbc.jar, 네트워크 회선 문제
				System.out.println("conn faild");
			String sql = "select empno, ename, to_char(hiredate, 'YYYY-MM-DD') hiredate from emp";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				EmpVO evo = new EmpVO();
				evo.setEmpno(rs.getInt("empno"));
				evo.setEname(rs.getString("ename"));
				evo.setHiredate(rs.getString("hiredate"));
				list.add(evo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
}

	