package com.biz.craw;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;


@WebServlet("/mango")
public class MangoCrawServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//http://localhost:8088/mango
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		initMainPage4ListforGet(request, response);
	}
	
	protected void initMainPage4ListforGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		  MangoCraw soup = new MangoCraw();
	      String url = "https://www.mangoplate.com/top_lists/kalguksu_top30";
	      String selector="ul li.toplist_list";

	      ArrayList<MangoVO> list = soup.MangoCrawling(url, selector, 4);
	      
	      PrintWriter out = response.getWriter();
	      
	      //그냥 mango주소에 뿌려줌
	      for(MangoVO yvo: list) {
	    	  out.println("<a href="+yvo.getUrl()+">"+yvo.getTitle()+"</a><br>");
	    	  out.println(yvo.getInfo()+"<br>");
	    	  out.println(yvo.getAddress()+"<br>");
	    	  out.println("<img width='100' height='100' src='"+yvo.getPicsrc()+"'>"+"<br>");
	      }
	}
	
	//Ajax Rest : post
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		
		Gson gson = new Gson();
		int topn = 4;
		if(request.getParameter("topn") != null)
			topn = Integer.parseInt(request.getParameter("topn"));
		
		response.setContentType("application/json; charset=UTF-8"); //응답 데이터 타입:JSON
		MangoCraw soup = new MangoCraw();
		String url = "https://www.mangoplate.com/top_lists/kalguksu_top30";
		String selector="ul li.toplist_list";
		ArrayList<MangoVO> list = soup.MangoCrawling(url, selector, topn);
		String gsonStr = gson.toJson(list);	
//		System.out.println(gsonStr);

		PrintWriter out = response.getWriter();
		out.println(gsonStr);

//		request.setAttribute("LIST_KEY", list);
//		request.getRequestDispatcher("/index").forward(request, response);

	      
	      
	}



}
