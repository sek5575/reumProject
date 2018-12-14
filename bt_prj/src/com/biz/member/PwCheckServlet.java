package com.biz.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/pwcheck")
public class PwCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//비밀번호 체크 -------------------------------
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();

		String sess_id = session.getAttribute("SESS_ID").toString();
		String userPw = request.getParameter("userpw");
		MemberVO mvo = new MemberVO();
		mvo.setUserId(sess_id);
		mvo.setUserPw(userPw);

		MemberDAO mdao = new MemberDAO();
		mvo = mdao.select(mvo);

		String mode = request.getParameter("mode");  //0

		//회원 인지 아닌지 확인
		if(mvo.getUserGubun() == null || mvo.getUserGubun().equals(""))  {
			response.sendRedirect("pwcheck.jsp");
		}
		
		//회원 수정 처리
		else if(mvo.getUserGubun().equals("u") && mode.equals("")){
			response.sendRedirect("/edit");
		}
		//회원탈퇴 처리
		else if(mode.equals("del")) {
			response.sendRedirect("/del");
			//회원정보 수정 처리
		}else {
			response.sendRedirect("/edit");
		}

	}

}
