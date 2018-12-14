package com.kosmo.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class jstlServlet
 */
@WebServlet("/jstl")
public class jstlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public jstlServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.sendRedirect("jstl_test.jsp?uid=kim");
		
		Ch99JDBCImpl t = new Ch99JDBCImpl();
		ArrayList<EmpVO> list = t.empListint("deptno", "10");
		
		request.setAttribute("KEY_FR", list.get(0));
		request.setAttribute("KEY_TOTAL", list.size());
		request.setAttribute("KEY_LIST", list);
		request.getRequestDispatcher("jstl_test.jsp").forward(request, response);
		
		
	}


}
