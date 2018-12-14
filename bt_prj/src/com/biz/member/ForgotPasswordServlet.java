package com.biz.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.biz.common.SendMailGoogleTest;
import com.biz.shop.ShopVO;


@WebServlet("/forgot")
public class ForgotPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SendMailGoogleTest g = new SendMailGoogleTest();
		String email = request.getParameter("email");
		String subject = "사토미는 여신이지";
		
		//랜덤 비밀번호 생성----------------------------------------
		int random_pw1 = (int)(Math.random()*10);
		int random_pw2 = (int)(Math.random()*10);
		int random_pw3 = (int)(Math.random()*10);
		int random_pw4 = (int)(Math.random()*10);
		
		String newPW = "!@"+random_pw1+random_pw2+random_pw3+random_pw4;
		System.out.println(newPW);
		
		//DB pw변경----------------------------------------
		//update member
		//set pw = newPw
		//where user_id= '' email ='email'
		
		MemberDAO dao = new MemberDAO();
		MemberVO vo = new MemberVO();
		vo.setUserEmail(email);
		vo.setUserPw(newPW);
		int res = dao.changePassword(vo);
		
		if(res > 0) {
			StringBuffer buffer = new StringBuffer();
			buffer.append("<html>\r\n");
			buffer.append("<meta charset=\"UTF-8\">\r\n" );
			buffer.append("<title>Insert title here</title>\r\n" );
			buffer.append("<body>\r\n");
			buffer.append("<table width=\"200\">\r\n");
			buffer.append("<tr><td><img src=\"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQVuHeA24bb-Rs9C-SQM32B5o47c5TGoS-eeieo30D2wYQf7fxyag\"></td></tr>\r\n");
			buffer.append("<tr><td>비밀번호 변경  --> "+newPW +"</td></tr>\r\n");
			buffer.append("</table>\r\n");
			buffer.append("\r\n");
			buffer.append("</body>\r\n");
			buffer.append("</html>");
			g.sendMail(email, subject, buffer.toString());
			response.sendRedirect("login.jsp");
		} else {
			response.sendRedirect("404.jsp");
		}
		
	}

}
