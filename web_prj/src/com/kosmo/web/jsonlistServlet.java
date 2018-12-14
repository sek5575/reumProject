package com.kosmo.web;

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
 * Servlet implementation class jsoncalltestServlet
 */
@WebServlet("/list")
public class jsonlistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Ch99JDBCImpl t = new Ch99JDBCImpl();
		Gson gson = new Gson();
		
		String empnum = request.getParameter("empnum");	//전달된  String데이터
		System.out.println(empnum);
		
		ArrayList<EmpVO> list = t.empList(empnum);
		String gsonStr = gson.toJson(list);							//String변환
		System.out.println(gsonStr);

		PrintWriter out = response.getWriter(); 					//응답 데이터 타입:String
		out.println(gsonStr);
		
	}

}
