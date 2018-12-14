<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>

$(document).ready(function(){
    //$("#Btn").click(function(){
    //   todo
    //});
});
</script>
</head>
<body>
관리자 페이지
<hr>
${sessionScope.SESS_NAME} <!--  session.setAttribute("SESS_NAME",...) -->
${requestScope.REQ_PNT}	  <!--   request.setAttribute("REQ_PNT",...) -->
${param.msg}				<!-- ?msg=val -->
<hr>
<%
//String msg = request.getParameter("msg");
//out.println(msg);
//String nm = session.getAttribute("SESS_NAME").toString();
//String gbn = session.getAttribute("SESS_GUBUN").toString();
//String pnt = request.getAttribute("REQ_PNT").toString();
//out.println(nm + ","+ gbn);
 %>
</body>
</html>