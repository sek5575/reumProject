package config.mybatis;

import java.io.Reader;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.biz.member.MemberVO;

public class DBMyBaitsManager {
   public SqlSession mybatisConn() {
      String path = "config/mybatis/config-mybatis.xml";
      Reader reader;
      SqlSessionFactory factory = null;
      SqlSession conn = null;
      try {
         reader = Resources.getResourceAsReader(path);
         factory = new SqlSessionFactoryBuilder().build(reader);
         conn = factory.openSession();

      } catch(Exception e) {
         e.printStackTrace();
      }
      return conn;
   }

   public void mybatisClose(SqlSession conn) {
      System.out.println("close");
      if(conn != null) conn.close();
   }

   public static void main(String[] args) {
      DBMyBaitsManager db = new DBMyBaitsManager();
      SqlSession conn = db.mybatisConn();
      
      MemberVO vo = new MemberVO();
      vo.setUserId("sososo");
      vo.setUserPw("111");
      vo.setUserName("오알엠");

     
      MemberVO res = conn.selectOne("userNameSpace.login", vo);
      System.out.println(res.getUserName());
      
      int res1 = conn.insert("userNameSpace.member_register", vo);
      System.out.println(res1 +"건 입력");

      
      String idname = "kim";
      int qres = conn.update("userNameSpace.member_update", idname);
      System.out.println(qres + "건 변경");
      
      int dres = conn.update("userNameSpace.member_delete", idname);
      System.out.println(dres + "건 삭제");
       
      ArrayList<MemberVO> list = (ArrayList)conn.selectList("userNameSpace.member_list");
      System.out.println(list.size());
      
      String oid = "park";
      MemberVO vvo = conn.selectOne("userNameSpace.member_detail", oid);
      System.out.println(vvo.getUserName());
      
      MemberVO lvo = new MemberVO();
      lvo.setSearchGubun("user_id");
      lvo.setSearchStr("lee");
      MemberVO bvo = conn.selectOne("userNameSpace.member_list", lvo);
      System.out.println(bvo.getUserEmail());
      
//    conn.selectList(arg0, arg1);
//    conn.selectOne(arg0, arg1);
//    conn.insert(arg0, arg1);
//    conn.update(arg0, arg1);
//    conn.delete(arg0, arg1);
//      conn.commit();
//    conn.rollback();
      
  
      db.mybatisClose(conn);
      
      //DI Call Test
//      GenericXmlApplicationContext ctx
//       = new GenericXmlApplicationContext("classpath:test.xml");
//      TestDAO dao = (TestDAO)ctx.getBean("aaaa");
//      ArrayList<BoardVO> list = dao.boardList(1, 10);
//      System.out.println(list.size() + "건 출력");
   }

}