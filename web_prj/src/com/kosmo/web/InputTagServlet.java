package com.kosmo.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InputTagServlet
 */
@WebServlet("/input_tag")  //보여지는 주소이면서 jsp에서 보내는 값들을 받는 주소이다.

public class InputTagServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InputTagServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setContentType("text/html; charset=UTF-8");   //1바이트 -> 2바이트로
//		String uid = request.getParameter("uid");   //서버로부터 값을 꺼내는 것은 getparameter
//		String upw = request.getParameter("upw");
//		System.out.println(uid + ", " + upw);
//		response.getWriter().append("전송값:"+uid).append(request.getContextPath());
//		
////		response.sendRedirect("input_tag_result.jsp?aaa="+uid+"&bbb="+upw);  // 저 주소로 이동해라
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    //container에서 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
//		doGet(request, response);
		response.setContentType("text/html; charset=UTF-8");   //1바이트 -> 2바이트로
		String uid = request.getParameter("uid");   //서버로부터 값을 꺼내는 것은 getparameter
		String upw = request.getParameter("upw");
		String[] habit = request.getParameterValues("habit");  // get방식으로 여러값이 올 수 없다.
		if(habit != null) {
			for(int i=0; i<habit.length; i++) {
				System.out.print(habit[i]+ ", ");
			}	
		}
		
		String gen = request.getParameter("gen");
		String tel = request.getParameter("tel");
		String content = request.getParameter("content");
		String ufile = request.getParameter("ufile");
		int bseq = Integer.parseInt(request.getParameter("bseq"));   //parseint 해줘야한다.
		
		
//		MultipartRequest multi = null;
		System.out.println(bseq);
		System.out.println(uid + ", " + upw);
		System.out.println(ufile);  //path + aa.jpg
		response.getWriter().append("id:"+uid+" , " + "password:"+upw+" , "+"habbit:"+habit+" , "+"gender:"+gen
									+ " , 통신사:" +tel+" , 문장:"+content+ufile+bseq).append(request.getContextPath());
		if(habit != null) {
			for(int i=0; i<habit.length;i++) {
				response.getWriter().append("취미:" + habit[i]).append(request.getContextPath());
			}
		}
		
		PrintWriter out = response.getWriter();
		out.write("<font color='red'>dddd</font>");
		response.getWriter().append(uid).append(request.getContextPath());
		ArrayList<String> mlist = new ArrayList<String>();
		mlist.add("아무개");
		mlist.add("홍길동");
		
		ArrayList<String> clist = new ArrayList<String>();
		clist.add("에어컨");
		clist.add("냉장고");
		
		request.setAttribute("KEY_STRING", "나이름"); 
		request.setAttribute("KEY_CLIST", clist); 
		request.setAttribute("KEY_MLIST", mlist);  //기존의 request값에  setAttribute를 통해서 mlist도 같이 보내준다.
		request.getRequestDispatcher("/input_tag_result2.jsp").forward(request, response);  // 제어권은 서블릿이 가지고 있다. 결과값 페이지에서 서블릿 제어권을 유지한다. 
//		forward은  데이터베이스의 insert 라인을 넣으면 안된다. 새로고침하면 계속 데이터가 갱신되서 들어가게 된다.
		
//		"input_tag_result.jsp?aaa="+uid+"&bbb="+upw&list=mlist  //redirect를 했을때에 보인는 값들
//		response.sendRedirect("/input_tag_result.jsp?aaa="+uid+"&bbb="+upw+"&ccc="+mlist);  // 저 주소로 이동열어라 (페이지 전환을 한다)
	}

}
