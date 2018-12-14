package com.biz.chart;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ChartServlet
 */
@WebServlet("/chart")
public class ChartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		int[] arr = {14, 15, 84, 52, 14, 86, 35};
		
		ArrayList<ChartVO> clist = new ArrayList<ChartVO>();
		
		
		String[] colors = {"#574B90", "#28a745","#ffc107","#dc3545","#343a40","#574B90","#28a745","#ffc107","#dc3545","#343a40"};
				
		
		for(int i=0; i<5; i++) {
			ChartVO vo = new ChartVO();
			vo.setLabel("가전"+i);
			vo.setIntVal(45400*i);
			vo.setColors(colors[i]);
			clist.add(vo);
			
		}
		request.setAttribute("KEY_DATA4",clist); 
			
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(44);
		arr.add(52);
		arr.add(55);
		arr.add(23);
		arr.add(15);
		arr.add(93);
		arr.add(72);
		

		request.setAttribute("KEY_DATA",arr);
		request.getRequestDispatcher("chart_list.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
