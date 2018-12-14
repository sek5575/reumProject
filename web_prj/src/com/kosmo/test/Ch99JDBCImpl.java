package com.kosmo.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

//import java.sql.*;
//C:\oraclexe\app\oracle\product\11.2.0\server\jdbc\lib  의 6번파일을 복사
//이클립스 jre 설정확인 : windows > preference > java > Installed JREs
//프로젝트 트리 > JRE System Library > ojdbc.jar 보이는지 확인
//프로젝트 트리 > Properties > Java Build Path > Lib탭 > Jre보임
public class Ch99JDBCImpl implements Ch99JDBC{
	//ODBC : Windows에서 사용되는 DB연결
	//	   : MSSql, Access
	//JDBC(Java DataBase Connectivity)
	// 	   : Oracle, Mysql, SQLite, MariaDB
	// : Driver  
	// : jar(java Archive) 클래스파일들을 압축해 놓은것 == zip파일
	// : API(메서드 기능의 묶음)
//	public static void main(String[] args) {
//		C: Connection conn = null;
//		P: PreparedStatement pstmt = null;
//		R: ResultSet rs = null;
//		C: conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "kosmo", "0000");
//		S: String sql = "select empno, ename from emp";
//		P: pstmt = conn.prepareStatement(sql);
//		E: rs = pstmt.executeQuery();
//		NE: while(rs.next())
	
	public ArrayList<EmpVO> empList(int Empnum) {
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
			
			String sql = "select empno, ename, job from emp where empno=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Empnum);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				EmpVO evo = new EmpVO();
				evo.setEmpno(rs.getInt("empno"));
				evo.setEname(rs.getString("ename"));
//				evo.setJob(rs.getString("job"));
				list.add(evo);
				
				
//				int num = rs.getInt("empno");
//				String name = rs.getString("ename");
//				System.out.println(num + "\t" + name);
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
	
	
//	public ArrayList<EmpVO> empList(String mname, double obj) {
//	}
//	
//	public ArrayList<EmpVO> empList(String mname, String obj) {
//	}
//	
	
	public ArrayList<EmpVO> empList(String mname, Object obj) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<EmpVO> list = new ArrayList<EmpVO>();
		Ch99DBManger db = new Ch99DBManger();
		
		try {
			//DriverManager d = new DriverManager();
			//d.getConnection(    );   생성자가 private로 묶여있다 new 할수 없다.
			
			conn = db.dbConn();
			
			String sql = "select * from emp where " + mname +"=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, obj);  //바인딩
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				EmpVO evo = new EmpVO();
				evo.setEmpno(rs.getInt("empno"));
				evo.setEname(rs.getString("ename"));
				list.add(evo);
//				evo.setJob(rs.getString("job"));

				
//				int num = rs.getInt("empno");
//				String name = rs.getString("ename");
//				System.out.println(num + "\t" + name);
			}
	
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
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
			
			String sql = "select empno, ename, job from emp";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				EmpVO evo = new EmpVO();
				evo.setEmpno(rs.getInt("empno"));
				evo.setEname(rs.getString("ename"));
//				evo.setJob(rs.getString("job"));
				list.add(evo);
				
//				int num = rs.getInt("empno");
//				String name = rs.getString("ename");
//				System.out.println(num + "\t" + name);
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
	
	
	
	

	
	public int empInsert(EmpVO vo) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		Ch99DBManger db = new Ch99DBManger();		
		int res = 0;
		
		try {
			conn = db.dbConn();
			String sql = "insert into emp(empno, ename, job, deptno) values(?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getEmpno());    //바인딩
			pstmt.setString(2, vo.getEname()); //바인딩
			pstmt.setString(3, vo.getJob()); //바인딩
			pstmt.setInt(4, vo.getDeptno());    //바인딩
			res = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
		return res;
	}
	

	@Override
	public int empInsert(int prmEmpno, String prmEname) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		Ch99DBManger db = new Ch99DBManger();		
		int res = 0;
		
		try {
			conn = db.dbConn();
			String sql = "insert into emp(empno, ename) values(?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,prmEmpno);    //바인딩
			pstmt.setString(2,prmEname); //바인딩
			res = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
		return res;
	}
	
	
	
	
	
	
	@Override
	public int empUpdate(int prmSal, int prmEmpno) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		Ch99DBManger db = new Ch99DBManger();
		int res = 0;
		
		try {
			conn = db.dbConn();
			String sql = "update emp set sal = ? where empno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, prmSal);
			pstmt.setInt(2, prmEmpno);
			res = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
		
		return res;
	}


	@Override
	public int empDelete(int prmEmpno) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		Ch99DBManger db = new Ch99DBManger();
		int res = 0;
		
		try {
			conn= db.dbConn();
			String sql = "delete from emp where empno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, prmEmpno);
			res = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
		
		return res;
	}


	@Override
	public int empInsertVO(EmpVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		Ch99DBManger db = new Ch99DBManger();
		int res = 0;
		
		conn= db.dbConn();
		try {
			String sql = "insert into emp(empno, ename) values (?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getEmpno());
			pstmt.setString(2, vo.getEname());
			res = pstmt.executeUpdate();
			System.out.println("insert로  "+ res + " 건 입력");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
		return res;
	}
	
	
	public void empUpdateVO(EmpVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int res = 0;
		Ch99DBManger db = new Ch99DBManger();
		
		try {
			conn = db.dbConn();
			String sql = "update emp set ename = ? where empno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getEname());
			pstmt.setInt(2, vo.getEmpno());
			res = pstmt.executeUpdate();
			System.out.println("update로  "+ res + " 건 수정");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	public void empDeleteVO(EmpVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int res = 0;
		Ch99DBManger db = new Ch99DBManger();
		
		try {
			conn = db.dbConn();
			String sql = "delete from emp where empno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getEmpno());
			res = pstmt.executeUpdate();
			System.out.println("delete로  " + res + " 건 삭제");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	public ArrayList<EmpVO> Select(String mname, Object obj){
		ArrayList<EmpVO> list = new ArrayList<EmpVO>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "kosmo", "0000");
			if(conn != null) {
				System.out.println("connect sucess");
			}else {
				System.out.println("connect faild");
			}
			String sql = "select empno, ename, job from emp where "+mname+" = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, obj);
			res = pstmt.executeQuery();
			
			while(res.next()) {
				EmpVO vo = new EmpVO();
				vo.setEmpno(res.getInt("empno"));
				vo.setEname(res.getString("ename"));
				vo.setJob(res.getString("job"));
				list.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
				try {
					if(res != null)res.close();
					if(pstmt != null)pstmt.close();
					if(conn != null)conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
		return list;
	}
	
	public void Insert(int prmEpno, String prmEname) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int res = 0;
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "kosmo", "0000");
			if(conn != null) {
				System.out.println("connect sucess");
			}else {
				System.out.println("connect faild");
			}
			
			String sql = "insert into emp(empno, ename) values(?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, prmEpno);
			pstmt.setString(2, prmEname);
			res = pstmt.executeUpdate();
			System.out.println(res + " 건 입력");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
				try {
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	
	public void Delete(EmpVO evo) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection conn = null;
		PreparedStatement pstmt = null;
		int res = 0;
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "kosmo", "0000");
			if(conn != null) {
				System.out.println("connect sucess");
			}else{
				System.out.println("connect faild");
			}
			
			String sql = "delete from emp where empno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, evo.getEmpno());
			res = pstmt.executeUpdate();
			
			System.out.println(res + " 건 삭제");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
				try {
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
	}
	
	
	public ArrayList<Vector> empListForSwing() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Vector> list = new ArrayList<Vector>();
			
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");  //forname 에서 모든  데이터베이스를 이용하기 위한 메소드를 메모리에 올려준다.
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			//DriverManager d = new DriverManager();
			//d.getConnection(    );   생성자가 private로 묶여있다 new 할수 없다.
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "kosmo", "0000"); //getConnection 이 static이기 때문에 new 안해도 된다.
			if(conn != null)
				System.out.println("conn success");
			else
				//오타, ojdbc.jar, 네트워크 회선 문제
				System.out.println("conn faild");
			
			String sql = "select empno, ename, job, deptno from emp";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Vector<Object> vo = new Vector<Object>();
				vo.addElement(rs.getInt("empno"));
				vo.addElement(rs.getString("ename"));
				vo.addElement(rs.getString("job"));
				vo.addElement(rs.getInt("deptno"));
//				evo.setJob(rs.getString("job"));
				list.add(vo);
				
//				int num = rs.getInt("empno");
//				String name = rs.getString("ename");
//				System.out.println(num + "\t" + name);
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
	
	
	
	public int empDeleteForSwing(int prmEmpno) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		Ch99DBManger db = new Ch99DBManger();
		int res = 0;
		
		try {
			conn= db.dbConn();
			String sql = "delete from emp where empno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, prmEmpno);
			res = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
		
		return res;
	}
	
	
	public int empUpdateForSwing(EmpVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		Ch99DBManger db = new Ch99DBManger();
		int res = 0;
		
		try {
			conn = db.dbConn();
			String sql = "update emp set ename = ?, job =?, deptno = ? where empno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getEname());
			pstmt.setString(2, vo.getJob());
			pstmt.setInt(3, vo.getDeptno());
			pstmt.setInt(4, vo.getEmpno());
			
			res = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
		
		return res;
	}
	
	
	
	
	
	
	

}
