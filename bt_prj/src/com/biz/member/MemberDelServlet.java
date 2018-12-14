package com.biz.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MemberDelServlet
 */
@WebServlet("/del")
public class MemberDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("SESS_ID") == null) {
			response.sendRedirect("profile.jsp");
		} else {
			String sess_id = session.getAttribute("SESS_ID").toString();
			//String userPw = request.getParameter("userpw");
			
			MemberDAO dao = new MemberDAO();
			int res = dao.delete(sess_id);
			System.out.println(res + "건 회원 삭제!!");
			session.invalidate();
			session.setMaxInactiveInterval(0);
			response.sendRedirect("index.jsp");
		}
		
	
		
		
	}

//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
