<%@ page
language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"
import="java.util.ArrayList"
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
forward 결과페이지...<hr>
redirect  --> http://localhost/input_tag_result.jsp <br>
forward   --> http://localhost/input_tag (서블릿)<br>

<%
ArrayList<String> mList = (ArrayList<String>)request.getAttribute("KEY_MLIST");
for(String str : mList){
	out.println(str + "<br>");
}

ArrayList<String> cList = (ArrayList<String>)request.getAttribute("KEY_CLIST");
for(String str : cList){
	out.println(str + "<br>");
}
String name = (String)request.getAttribute("KEY_STRING");
out.println(name + "<br>");

/*for(int i=0; i<resList.size(); i++){
	String str = resList.get(i);
	out.println(str);
}*/
%>


</body>
</html>