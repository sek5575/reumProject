package com.biz.shop;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShopDetailServlet
 */
@WebServlet("/shop_detail")
public class ShopDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sseqStr = request.getParameter("sseq");
		int sseq = Integer.parseInt(sseqStr);
		ShopDAO dao = new ShopDAO();
		
		//상세정보
//		ShopVO vo = dao.selectShopInfo(sseq);
//		//이미지정보
//		ArrayList<ShopPicVO> picList = dao.selectShopPic(sseq);
//		
//		request.setAttribute("Detail_VO", vo);
//		request.setAttribute("LIST_PIC", picList);
		
		
		//상세정보 샵1:이미지 n, 댓글n
		ShopVO vo = dao.selectShopInfo(sseq);
		
//		//이미지정보
//		ArrayList<ShopPicVO> pvoList = dao.selectShopPic(sseq);
//		if(pvoList.size()<=0) {
//			ShopPicVO pvo = new ShopPicVO();
//			pvo.setPname("33.jpg");
//			pvoList.add(pvo);
//		}
//		vo.setPvolist(pvoList);
				
		request.setAttribute("SVO", vo);

		
		request.getRequestDispatcher("shop_detail.jsp").forward(request, response);
		
	}



}
