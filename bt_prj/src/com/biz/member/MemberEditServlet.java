package com.biz.member;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.biz.common.MyFileRenamePolicy;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.FileRenamePolicy;

/**
 * Servlet implementation class MemberEditServlet
 */
@WebServlet("/edit")
public class MemberEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//DB 회원정보 조회 후 /profile.jsp 이동
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String sess_id = session.getAttribute("SESS_ID").toString();

		MemberDAO mdao = new MemberDAO();
		MemberVO mvo = mdao.select(sess_id);

		if(mvo.getUserGubun() == null || mvo.getUserGubun().equals(""))  {
			response.sendRedirect("/404.jsp");
		} else {
			request.setAttribute("KEY_MVO", mvo);
			request.getRequestDispatcher("/profile.jsp").forward(request, response);
		}

	}
	
	
	// profile.jsp에서 수정버튼 클릭 시 DB 수정 작업
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberVO mvo = new MemberVO();
		
		String sess_id = session.getAttribute("SESS_ID").toString();
		mvo.setUserId(sess_id);		
		
		String saveDirectory = "C:/uploads/profile";
		int maxPostSize = 1024 * 1024 * 10; //10M
		String encoding = "UTF-8";
		
		//--------------------------------------------
		// * c:/uploads 폴더에 파일카피 input/output Stream
		// * 중복파일 rename
		//--------------------------------------------
		FileRenamePolicy policy = new MyFileRenamePolicy();
		MultipartRequest mrequest = new MultipartRequest(request,saveDirectory,maxPostSize,encoding,policy);
		
		//--------------------------------------------
		// * users 관련 파라미터
		//--------------------------------------------
		String userName = mrequest.getParameter("user_name");
		String userPw = mrequest.getParameter("user_pw");
		String userEmail = mrequest.getParameter("user_email");
		mvo.setUserName(userName);
		mvo.setUserPw(userPw);
		mvo.setUserEmail(userEmail);
		
		//-----------------------------------------------		
		// * shop_pic : cos.jar 를 이용한 단일 파일 업로드 처리 
		//-----------------------------------------------
		String origPname = mrequest.getOriginalFileName("pname");
		String sysPname = "";
		
		//**프로필 사진을 기존데로 사용하는 경우
		if(origPname == null) {
				origPname = mrequest.getParameter("old_pname");
				sysPname = mrequest.getParameter("old_sysname");
				saveDirectory = mrequest.getParameter("old_ppath");
				mvo.setPpath(saveDirectory);
				mvo.setPname(origPname);
				mvo.setSysname(sysPname);
		//**프로필 사진을 바꾼 경우
		} else {
				//3.File 객체를 이용한 원본 파일명 
				File pfile = mrequest.getFile("pname");
				String filePname  = pfile.getName(); 	
						
				//중복 시 리네임된 파일명
				sysPname = mrequest.getFilesystemName("pname");
				
				//파일크기
				long attachFileSize = pfile.length();		
				String attachFileContentType = mrequest.getContentType("pname");
				
				//파일 확장자 처리
				String attachFileExt = "jpg";
				if(origPname.lastIndexOf(".") != -1) {
					attachFileExt = origPname.substring(origPname.lastIndexOf(".")+1);
				}
				if(!attachFileExt.toUpperCase().equals("JPG") &&
						!attachFileExt.toUpperCase().equals("PNG") &&
						!attachFileExt.toUpperCase().equals("GIF")
				) {
					response.setContentType("text/html; charset=UTF-8");
					PrintWriter out = response.getWriter();
					out.println("<script>alert('이미지 첨부만 가능')</script>");
					//response.sendRedirect("shop_form.jsp");
				}
				mvo.setPpath(saveDirectory);
				mvo.setPname(origPname);
				mvo.setSysname(sysPname);
				
		}
		
		
		//--------------------------------------------
		// 2. DB저장작업 : USERS 테이블 정보 수정(+프로필 정보)
		//--------------------------------------------
		MemberDAO dao = new MemberDAO();
		int res = dao.update(mvo);
		if(res > 0) {
			response.sendRedirect("/edit");
		} else {
			response.sendRedirect("404.jsp");
		}
	}

}
