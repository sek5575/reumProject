//package com.biz.member;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//
//import com.biz.common.DBManager;
//import com.biz.shop.ShopPicVO;
//import com.biz.shop.ShopVO;
//
//public class MemberDAO_cpcp {
//	/**
//	 * 회원 가입
//	 * @param mvo
//	 * @return
//	 */
//	public int delete(String id) {
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		int res = 0; 
//		DBManager db = new DBManager();
//		try {
//			conn = db.dbConn();
//			StringBuffer sqlBuffer = new StringBuffer();
//			sqlBuffer.append("update users ");
//			sqlBuffer.append("set user_del='y' ");
//			sqlBuffer.append("where user_id=? and USER_DEL='n' ");
//			System.out.println(sqlBuffer.toString());
//			
//			pstmt = conn.prepareStatement(sqlBuffer.toString());
//			pstmt.setString(1, id);
//			res = pstmt.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			db.dbClose(pstmt, conn);
//		}
//		return res;
//	}
//	
//	
//	
//	public int insert(MemberVO mvo) {
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		int res = 0;
//		DBManager db = new DBManager();
//		try {
//			conn = db.dbConn();
//			StringBuffer sqlBuffer = new StringBuffer();
//			sqlBuffer.append("insert into users(user_seq,user_id,user_name,user_pw,user_email,user_gubun ");
//			sqlBuffer.append(",regdate,user_del,ppath,pname,sysname,join_path) ");
//			sqlBuffer.append("values(users_seq.nextval,?,?,?,?,'u',sysdate,'n',?,?,?,?)" );
//			System.out.println(sqlBuffer.toString());
//
//			pstmt = conn.prepareStatement(sqlBuffer.toString());
//			pstmt.setString(1, mvo.getUserId());
//			pstmt.setString(2, mvo.getUserName());
//			pstmt.setString(3, mvo.getUserPw());
//			pstmt.setString(4, mvo.getUserEmail());
//			pstmt.setString(5, mvo.getPpath());
//			pstmt.setString(6, mvo.getPname());
//			pstmt.setString(7, mvo.getSysname());
//			//pstmt.setString(8, mvo.getJoinPath());
//			res = pstmt.executeUpdate();
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			db.dbClose(pstmt, conn);
//		}
//		return res;
//	}
//	
//	/**
//	 * 회원정보 수정
//	 * @param mvo
//	 * @return
//	 */
//	public int update(MemberVO mvo) {
//		//user_name, user_pw, user_email, ppath, pname, sysname
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		int res = 0;
//		ShopVO svo = new ShopVO(); 
//		DBManager db = new DBManager();
//		try {
//			conn = db.dbConn();
//			StringBuffer sqlBuffer = new StringBuffer();
//			sqlBuffer.append("update users ");
//			sqlBuffer.append("set user_name=?, user_pw=?, user_email=?, ppath=?, pname=?, sysname=? ");
//			sqlBuffer.append("where user_id=? and USER_DEL='n' ");
//			System.out.println(sqlBuffer.toString());
//			
//			pstmt = conn.prepareStatement(sqlBuffer.toString());
//			pstmt.setString(1, mvo.getUserName());
//			pstmt.setString(2, mvo.getUserPw());
//			pstmt.setString(3, mvo.getUserEmail());
//			pstmt.setString(4, mvo.getPpath());
//			pstmt.setString(5, mvo.getPname());
//			pstmt.setString(6, mvo.getSysname());
//			pstmt.setString(7, mvo.getUserId());
//			res = pstmt.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			db.dbClose(pstmt, conn);
//		}
//		return res;
//	}
//	
//	/**
//	 * 회원 정보 수정을 위한 모든 정보 가져오기
//	 * @param userId
//	 * @return
//	 */
//	public MemberVO select(String userId) {
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		ShopVO svo = new ShopVO(); 
//		DBManager db = new DBManager();
//		MemberVO mvo = new MemberVO();
//		try {
//			conn = db.dbConn();
//			StringBuffer sqlBuffer = new StringBuffer();
//			//sqlBuffer.append("select user_name as userName, user_gubun as userGubun");
//			//decode(user_gubun,'u','사용자','a','관리자') as user_gubun
//			sqlBuffer.append("select user_id,user_name,user_email,user_gubun, ppath,pname, sysname ");
//			sqlBuffer.append("from users ");
//			sqlBuffer.append("where user_id=? and USER_DEL='n' ");
//			System.out.println(sqlBuffer.toString());
//
//			pstmt = conn.prepareStatement(sqlBuffer.toString());
//			pstmt.setString(1, userId);
//			rs = pstmt.executeQuery();
//			if(rs.next()) {
//				mvo.setUserId(rs.getString("user_id"));
//				mvo.setUserName(rs.getString("user_name"));
//				mvo.setUserEmail(rs.getString("user_email"));
//				mvo.setUserGubun(rs.getString("user_gubun"));
//				mvo.setPpath(rs.getString("ppath"));
//				mvo.setPname(rs.getString("pname"));
//				mvo.setSysname(rs.getString("sysname"));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			db.dbClose(rs, pstmt, conn);
//		}
//		return mvo;
//	}
//	
//	/**
//	 * 로그인 정보 가져오기
//	 * @param mvo
//	 * @return
//	 */
//	public MemberVO select(MemberVO mvo) {
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		ShopVO svo = new ShopVO(); 
//		DBManager db = new DBManager();
//
//		try {
//			conn = db.dbConn();
//			StringBuffer sqlBuffer = new StringBuffer();
//			//sqlBuffer.append("select user_name as userName, user_gubun as userGubun");
//			//decode(user_gubun,'u','사용자','a','관리자') as user_gubun
//			sqlBuffer.append("select user_name , user_gubun ");
//			sqlBuffer.append("from users ");
//			sqlBuffer.append("where user_id=? and user_pw=? and USER_DEL='n' ");
//
//			System.out.println(sqlBuffer.toString());
//
//			pstmt = conn.prepareStatement(sqlBuffer.toString());
//			pstmt.setString(1, mvo.getUserId());
//			pstmt.setString(2, mvo.getUserPw());
//			rs = pstmt.executeQuery();
//			while(rs.next()) {
//				mvo.setUserName(rs.getString("user_name"));
//				mvo.setUserGubun(rs.getString("user_gubun"));
////				mvo.setUserName(rs.getString("userName"));
////				mvo.setUserGubun(rs.getString("userGubun"));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			db.dbClose(rs, pstmt, conn);
//		}
//		return mvo;
//	}
//}
