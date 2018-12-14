package com.biz.shop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.biz.common.MyBatisFactory;
import com.biz.member.MemberVO;

public class ShopDAO {
	
	public ArrayList<ReplyVO> replySelect(int sseq) {
		SqlSession conn = null;
		ArrayList<ReplyVO> list = null;
		try {
			conn = MyBatisFactory.getFactory().openSession();  //MyBatisFactory.getFactory() 중앙에서 관리해주는 기능 ==> 싱글턴
			list = (ArrayList)conn.selectList("shopNameSpace.reply_select", sseq);
		} finally {
			conn.close();
		}
		return list;	
	}
	
	public int replyInsert(ReplyVO vo) {  //사진
		SqlSession conn = null;
		int res=0;
		try {
			conn = MyBatisFactory.getFactory().openSession(); 
			res = conn.insert("shopNameSpace.reply_insert", vo);
			conn.commit();
		} finally {
			conn.close();
		}
		return res;	
	}
	
	public ArrayList<ShopVO> selectTopN(ShopVO vo) {
		SqlSession conn = null;
		ArrayList<ShopVO> list = null;
		try {
			conn = MyBatisFactory.getFactory().openSession();  //MyBatisFactory.getFactory() 중앙에서 관리해주는 기능 ==> 싱글턴
			list = (ArrayList)conn.selectList("shopNameSpace.selectTopN", vo);
		} finally {
			conn.close();
		}
		return list;	
	}
	
	
	public int selectNextSseq(SqlSession PRMCONN) {
		int next_sseq = PRMCONN.selectOne("shopNameSpace.selectNextSseq");
		return next_sseq;
	}
	
	
	public int insertShopInfo(ShopVO svo, SqlSession PRMCONN) {  //글 내용부분
		int res = PRMCONN.insert("shopNameSpace.insertShopInfo", svo);
		PRMCONN.commit();
		return res;	
	}
	
	
	public int insertShopPic(ShopPicVO svo, SqlSession PRMCONN) {  //사진
		int res = PRMCONN.insert("shopNameSpace.insertShopPic", svo);
		PRMCONN.commit();
		return res;	
	}
	
	
	public ArrayList<ShopPicVO> selectShopPic(int sseq) {
		SqlSession conn = null;
		ArrayList<ShopPicVO> list = null;
		try {
			conn = MyBatisFactory.getFactory().openSession();  //MyBatisFactory.getFactory() 중앙에서 관리해주는 기능 ==> 싱글턴
			list = (ArrayList)conn.selectList("shopNameSpace.selectShopPic", sseq);
		} finally {
			conn.close();
		}
		return list;
	}

	
	public ShopVO selectShopInfo(int sseq) {
		SqlSession conn = null;
		ShopVO vo = null;
		try {
			conn = MyBatisFactory.getFactory().openSession();  //MyBatisFactory.getFactory() 중앙에서 관리해주는 기능 ==> 싱글턴
			vo = conn.selectOne("shopNameSpace.selectShopInfo", sseq);
		} finally {
			conn.close();
		}
		return vo;
	}
	
	
	//selectAll
	public ArrayList<ShopVO> selectAll(ShopVO vo) {
		SqlSession conn = null;
		ArrayList<ShopVO> list = null;
		try {
			conn = MyBatisFactory.getFactory().openSession();  //MyBatisFactory.getFactory() 중앙에서 관리해주는 기능 ==> 싱글턴
			list = (ArrayList)conn.selectList("shopNameSpace.selectAll", vo);
		} finally {
			conn.close();
		}
		return list;
	}
	
	
	public ArrayList<ShopVO> select() {
		SqlSession conn = null;
		ArrayList<ShopVO> list = null;
		try {
			conn = MyBatisFactory.getFactory().openSession();  //MyBatisFactory.getFactory() 중앙에서 관리해주는 기능 ==> 싱글턴
			list = (ArrayList)conn.selectList("shopNameSpace.selectAll");
		} finally {
			conn.close();
		}
		return list;	
	}
	
	
	public int selectCount() {
		int res = 0;
		SqlSession conn = null;
		try {
			conn = MyBatisFactory.getFactory().openSession();  //MyBatisFactory.getFactory() 중앙에서 관리해주는 기능 ==> 싱글턴
			res = conn.selectOne("shopNameSpace.selectCount");
		} finally {
			conn.close();
		}
		return res;
		
	}

}
