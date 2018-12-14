package com.kosmo.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/abc")
public class HelloServlet extends HttpServlet {    //servlet이란 주소를 갖는 자바파일
	private static final long serialVersionUID = 1L;  //순서를 주기위한 번호표
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
		//request는 input      response는 output 과정
		response.setContentType("text/html; charset=UTF-8");   //1바이트 -> 2바이트로
		System.out.println("request call...");
		String uid = request.getParameter("code");   //서버로부터 값을 꺼내는 것은 getparameter
		String upw = request.getParameter("upw");
		System.out.println("id: " + uid + "   pass: " + upw);
		response.getWriter().append("전송값:"+uid).append(request.getContextPath());
		
	}  //http 프로토콜은 get이나 post방식으로      get은 프로토콜에 header에 실리고 post방식은 body에 실리기 되어서    get은 길이제한이 있다.  
	   //get은 아이디나 비밀번호가 보이게되고 post는 ?뒤에는 안보이게 된다.
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		response.setContentType("text/html; charset=UTF-8");
		System.out.println("post call...");
		String uid = request.getParameter("uid");
		String upw = request.getParameter("upw");
		System.out.println("id: " + uid + "   pass: " + upw);
		response.getWriter().append("전송값:"+uid).append(request.getContextPath());
	}
	
}	