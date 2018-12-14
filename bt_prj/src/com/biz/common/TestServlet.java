package com.biz.common;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/test")

public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public TestServlet() {
        super();
        System.out.println("TestServlet() 호출");
    }


	public void init(ServletConfig config) throws ServletException {
		System.out.println("TestServlet init 호출");
		String size = config.getInitParameter("MAX_SIZE");
		String updir = config.getInitParameter("UPDIR");
		System.out.println(size +"," +updir);
		
		ServletContext ctx = config.getServletContext();
		String comm = ctx.getInitParameter("COMMON");
		System.out.println("TestServlet COMMON" + comm);

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get.....");
	}

}
