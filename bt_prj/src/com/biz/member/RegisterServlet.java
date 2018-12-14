package com.biz.member;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.biz.shop.ShopDAO;
import com.biz.shop.ShopVO;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String saveDirectory = "C:/uploads/profile";
		int maxPostSize = 1024 * 1024 * 10; //10M
		String encoding = "UTF-8";
		FileRenamePolicy policy = new DefaultFileRenamePolicy();
		MemberDAO dao = new MemberDAO();	

		MultipartRequest mrequest = new MultipartRequest(request,saveDirectory,maxPostSize,encoding,policy);
		
		String user_id = mrequest.getParameter("user_id");
		String user_name = mrequest.getParameter("user_name");
		String user_email = mrequest.getParameter("user_email");
		String user_pw = mrequest.getParameter("user_pw");
		
	
		MemberVO mvo = new MemberVO();
		
		mvo.setUserId(user_id);
		mvo.setUserName(user_name);
		mvo.setUserEmail(user_email);
		mvo.setUserPw(user_pw);
		mvo.setPpath(saveDirectory);

		//-----------------------------------------------		
		// * shop_pic : cos.jar 를 이용한 단일 파일 업로드 처리 
		//-----------------------------------------------
		String origPname = mrequest.getOriginalFileName("pname");
		mvo.setPname(origPname);	
				
		//중복 시 리네임된 파일명
		String sysPname = mrequest.getFilesystemName("pname");
		mvo.setSysname(sysPname);
		
		//파일크기
		//long attachFileSize = pfile.length();		
		
		//contentType
		//String attachFileContentType = mrequest.getContentType("pname");
		
		//파일 확장자 처리
		String attachFileExt = "jpg";
		if(origPname.lastIndexOf(".") != -1) {
			attachFileExt = origPname.substring(origPname.lastIndexOf(".")+1);
		}
		if(!attachFileExt.toUpperCase().equals("JPG") &&
				!attachFileExt.toUpperCase().equals("JPEG") &&
				!attachFileExt.toUpperCase().equals("PNG") &&
				!attachFileExt.toUpperCase().equals("GIF")
		) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('이미지 첨부만 가능')</script>");
			//response.sendRedirect("shop_form.jsp");
		}
		
		int res = dao.insert(mvo);
		
		
		if(res > 0) {
			response.sendRedirect("index.jsp");
			System.out.println("-----회원가입 성공-----");
		} else {
			response.sendRedirect("404.jsp");
			System.out.println("-----회원가입 실패-----");
		}

		
//		response.sendRedirect("login.jsp");

		
		
	}

}
