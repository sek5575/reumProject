package com.biz.shop;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;

/**
 * Servlet implementation class shopinsertpracticeServlet
 */
@WebServlet("/shop_insertPrac")
public class shopinsertpracticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String saveDirectory = "C:/uploads";
		int maxPostSize = 1024 * 1024 * 10;
		String encoding = "UTF-8";
		FileRenamePolicy policy = new DefaultFileRenamePolicy();
		MultipartRequest mrequest = new MultipartRequest(request, saveDirectory, maxPostSize, encoding, policy);
		
		//DB저장작업
		String sname = mrequest.getParameter("sname");
		String placename = mrequest.getParameter("placename");
		String lat = mrequest.getParameter("lat");
		String lng = mrequest.getParameter("lng");
		String sinfo = mrequest.getParameter("sinfo");
		
		//사용자에게 보여지는 이름
		String orginPname = mrequest.getOriginalFileName("pname");
		
		File pfile = mrequest.getFile("pname");
		String filePname = pfile.getName();
		
		
		ArrayList<ShopPicVO> pvolist = new ArrayList<ShopPicVO>();
		Enumeration formNames = mrequest.getFileNames();
		while(formNames.hasMoreElements()) {
			String inputNames = (String)formNames.nextElement();
			
			if(inputNames != null) {
				ShopPicVO pvo = new ShopPicVO();
				
				String orginPnames = mrequest.getOriginalFileName(inputNames);
				String sysPnames = mrequest.getFilesystemName(inputNames);
				File pfiles = mrequest.getFile(inputNames);
				long attachFileSizes = pfiles.length();
				pvo.setPname(sysPnames);
				pvo.setPyn("y");
				pvolist.add(pvo);
				
			}
			
		}
		
		
		
		String sysPname = mrequest.getFilesystemName("pname");
		
		long attachFileSize = pfile.length();
		
		String attachFileConetentType = mrequest.getContentType("pname");
		
		String attachFileExt = "jpg";
		if(orginPname.lastIndexOf(".") != -1) {
			attachFileExt = orginPname.substring(orginPname.lastIndexOf("."));
			
		}
		if(!attachFileExt.toUpperCase().equals("JPG") &&
			!attachFileExt.toUpperCase().equals("PNG") &&
			!attachFileExt.toUpperCase().equals("GIF") &&
			!attachFileExt.toUpperCase().equals("JPEG")
				) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('이미지 첨부만 가능합니다.')</script>");
		}
		
		
		
	}

}
