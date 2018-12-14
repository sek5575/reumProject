package com.biz.shop;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.biz.common.PagingUtil;
import com.google.gson.Gson;

/**
 * Servlet implementation class ShopServlet
 */
@WebServlet("/shop")
public class ShopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jsonStr = request.getParameter("MYKEY");
		Gson gson = new Gson();
		ShopVO vo = gson.fromJson(jsonStr, ShopVO.class);
		
		HashMap<String, Object> map = new HashMap();
		ShopDAO dao = new ShopDAO();
		//전체 회원 목록 ArrayList<ShopVO> list = dao.select(vo);
		
		int currentPage = 1;
		currentPage = vo.getCurrentPage();
		System.out.println("currentPage" + currentPage);
	
		//전체 게시물 수
		int totalCnt = dao.selectCount();
		
		int blockCount = 2;   //한 블럭의 게시물 수
		int blockPage = 2;    //한화면에 보여질 블럭 수
		PagingUtil page  = new PagingUtil("/shop?", currentPage, totalCnt, blockCount, blockPage);
		String pagingHtml = page.getPagingHtml();
//		request.setAttribute("PAGING", pagingHtml); 
		
		
		//전체목록
		vo.setStartSeq(page.getStartSeq());
		vo.setEndSeq(page.getEndSeq());
		ArrayList<ShopVO> list = dao.selectAll(vo);
		
		
		map.put("MAP_PAGING", pagingHtml);
		map.put("MAP_LIST", list);
		

		response.setContentType("application/json; charset=UTF-8");
		String returnStr = gson.toJson(list);
		PrintWriter out = response.getWriter();
		out.println(returnStr);
		
	}
	
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String jsonStr = request.getParameter("MYKEY");
//		Gson gson = new Gson();
//		ShopVO vo = gson.fromJson(jsonStr, ShopVO.class);
//		
//		ShopDAO dao = new ShopDAO();
//		//전체 회원 목록 ArrayList<ShopVO> list = dao.select(vo);
//		
//		// 아래는 top 4개 목록 보기
//		vo.setTopn(4);
//		ArrayList<ShopVO> list = dao.selectTopN(vo);
//
//		response.setContentType("application/json; charset=UTF-8");
//		String returnStr = gson.toJson(list);
//		PrintWriter out = response.getWriter();
//		out.println(returnStr);
//		
//	}

//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String jsonStr = request.getParameter("MYKEY");
//		Gson gson = new Gson();
//		ShopVO vo = gson.fromJson(jsonStr, ShopVO.class);
//		
//		ShopDAO dao = new ShopDAO();
//		ArrayList<ShopVO> list = dao.select();
//		request.setAttribute("SHOP_LIST", list);
//		System.out.println(list.size());
//		request.getRequestDispatcher("index.jsp").forward(request, response);
//		
//	}

	
	

}
