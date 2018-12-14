<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
결과페이지...<hr>
http://localhost/input_tag_result.jsp?aaa=qqq&bbb=wwww <br>

<%
String uid = request.getParameter("aaa"); 
String upw = request.getParameter("bbb");
String mlist = request.getParameter("mlist");  //HTTP ERROR 400 잘못된 타입에러  401/403 인증에러
//out.println(uid);
//out.println(upw);
%>
<%=uid%>,<%=upw%>
</body>
</html>