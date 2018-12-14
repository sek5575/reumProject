<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"
    	prefix="c"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%-- <script>
<%
String uid = request.getParameter("uid");
String upw = request.getParameter("upw");
String gen = request.getParameter("gen");
String tel = request.getParameter("tel");
String content = request.getParameter("content");
String ufile = request.getParameter("ufile");
String[] habit = request.getParameterValues("hprm");
//String habit = request.getParameter("habit");
%> 
</script> --%>

<script>
$(document).ready(function(){
	
	var habitarr = new Array();
	
	<c:forEach var="str" items="${paramValues.habit}">   //자바jsp에서 가져온 배열을 jquery담는다.    //paramValues.habit  -> String배열
		habitarr.push("${str}");
		console.log("${str}");
	</c:forEach>
	
	
	$.each(habitarr, function(i, v){   //habitarr -> object 배열
		$("[name='habit'][value='"+v+"']").attr("checked", "checked");
	})
	
	/* $.each(${habit}, function(i, v){
		$("[name='habit'][value='"+v+"']").attr("checked", "checked");
	}) */

	

});
</script>
</head>

<body>
<form name="myform">  <!--onSubmit="return btnClick2()" 한번에 submit과 image를 보낸다 -->

<input type="text" id="uid" class="uid" name="uid" value=${param.uid}><br>
<input type="password" id="upw" name="upw" value=${param.upw}><br>                                                                                                                                                                                                                                                                                                                                                                                                                                                                         

<input type="checkbox" name="habit" value="book">독서
<input type="checkbox" name="habit" value="mnt">등산
<input type="checkbox" name="habit" value="fish">낚시
<br>


<input type="radio"  name="gen" class="gen" >남성
<input type="radio" name="gen" class="gen">여성

<%-- <input type="radio"  name="gen" class="gen" <% if(gen.equals("m")){%> checked <%} %>>남성
<input type="radio" name="gen" class="gen" <% if(gen.equals("f")){%> checked <%} %>>여성  --%>
<br>


<input type="hidden" id="bseq" name="bseq" value="1"><br>
<input type="file" id="ufile" name="ufile" value="첨부파일선택"><br>

<!-- / -->
<select id="tel" name="tel">
	<option value="011">SKT</option>
	<option value="019">LGT</option>
	<option value="016">KT</option>
	<%-- <option value="011" <% if(tel.equals("011")){%> selected <%} %>>SKT</option>
	<option value="019" <% if(tel.equals("019")){%> selected <%} %>>LGT</option>
	<option value="016" <% if(tel.equals("016")){%> selected <%} %>>KT</option> --%>
</select> <br>

<textarea cols="40" rows="10"  id="content" name="content" >></textarea><br>
<%-- <textarea cols="40" rows="10"  id="content" name="content" ><%=content%></textarea><br> --%>

<!-- 버튼류 -->
<input type="button" id="checkBtn" value="일반버튼"><br>	
</form>

</body>
</html>