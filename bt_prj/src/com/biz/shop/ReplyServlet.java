package com.biz.shop;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class ReplyServlet
 */
@WebServlet("/reply")
public class ReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//hidden : sseq :맛집seq
		String reply = request.getParameter("reply");
		String sseqStr = request.getParameter("sseq");
		int sseq = Integer.parseInt(sseqStr);
		
		String session_id = request.getSession().getAttribute("SESS_ID").toString();
		
//		String session_id = "kom";
		
		ReplyVO rvo = new ReplyVO();
		rvo.setReply(reply);
		rvo.setSseq(sseq);
		rvo.setRegid(session_id);
		
		ShopDAO dao = new ShopDAO();
		dao.replyInsert(rvo);
		
		ArrayList<ReplyVO> rlist = dao.replySelect(sseq);

		Gson gson = new Gson();
		String gsonStr = gson.toJson(rlist);
		
		response.setContentType("application/json; encoding=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(gsonStr);
		
	
	}

}
