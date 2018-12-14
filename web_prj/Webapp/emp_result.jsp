<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList" import="com.kosmo.web.EmpVO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
EMP 조회페이지...<hr>

<%
ArrayList<EmpVO> mList = (ArrayList<EmpVO>)request.getAttribute("KEY_LIST");
for(int i=0; i<mList.size(); i++){
	out.println(mList.get(i).getEname());
	out.println(mList.get(i).getDeptno());
	out.println(mList.get(i).getJob());
	out.println("<br>");
}

/* for(EmpVO evo : mList){
	out.println(evo.getEmpno() + "<br>");
} */

/*for(int i=0; i<resList.size(); i++){
String str = resList.get(i);
out.println(str);
}*/
%>

</body>
</html>