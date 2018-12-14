package com.biz.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.biz.common.MyBatisFactory;
import com.biz.shop.ShopPicVO;
import com.biz.shop.ShopVO;

public class MemberDAO {
	
	public int changePassword(MemberVO vo) {
		SqlSession conn = null;
		int res = 0;
		try {
			conn = MyBatisFactory.getFactory().openSession();  //MyBatisFactory.getFactory() 중앙에서 관리해주는 기능 ==> 싱글턴
			res = conn.update("userNameSpace.changePassword", vo);
			conn.commit();
		} finally {
			conn.close();
		}
		return res;
	}
	
	/**
	 * 회원 가입
	 * @param mvo
	 * @return
	 */
	public int delete(String id) {
		SqlSession conn = null;
		int res = 0;
		try {
			conn = MyBatisFactory.getFactory().openSession();  //MyBatisFactory.getFactory() 중앙에서 관리해주는 기능 ==> 싱글턴
			res = conn.update("userNameSpace.member_delete", id);
			conn.commit();
		}finally {
			conn.close();
		}
		return res;
	}
	
	
	
	public int insert(MemberVO mvo) {
		SqlSession conn = null;
		int res = 0;
		try {
			//singleton : instance의 중앙관리
			//factory instance : private static
			//public getFactory()를 통해 가져감
			conn = MyBatisFactory.getFactory().openSession();  //MyBatisFactory.getFactory() 중앙에서 관리해주는 기능 ==> 싱글턴
			res = conn.insert("userNameSpace.member_register", mvo);
			conn.commit();
		} finally {
			conn.close();
		}
		return res;
	}
	
	
	/**
	 * 회원정보 수정
	 * @param mvo
	 * @return
	 */
	public int update(MemberVO mvo) {
		SqlSession conn = null;
		int res = 0;
		try {
			conn = MyBatisFactory.getFactory().openSession();  //MyBatisFactory.getFactory() 중앙에서 관리해주는 기능 ==> 싱글턴
			res = conn.update("userNameSpace.member_update", mvo);
			conn.commit();
		} finally {
			conn.close();
		}
		return res;
	}
	
	
	
	/**
	 * 회원 정보 수정을 위한 모든 정보 가져오기
	 * @param userId
	 * @return
	 */
	public MemberVO select(String userId) {
		SqlSession conn = null;
		MemberVO vo = null;
		try {
			conn = MyBatisFactory.getFactory().openSession();  //MyBatisFactory.getFactory() 중앙에서 관리해주는 기능 ==> 싱글턴
			vo = conn.selectOne("userNameSpace.member_detail", userId);
			conn.commit();
		} finally {
			conn.close();
		}
		return vo;
	}
	
	/**
	 * 로그인 정보 가져오기
	 * @param mvo
	 * @return
	 */
	public MemberVO select(MemberVO mvo) {
		SqlSession conn = null;
		MemberVO vo = null;
		try {
			conn = MyBatisFactory.getFactory().openSession();  //MyBatisFactory.getFactory() 중앙에서 관리해주는 기능 ==> 싱글턴
			vo = conn.selectOne("userNameSpace.login", mvo);
			conn.commit();
		} finally {
			conn.close();
		}
		return vo;
	}
}
