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
	
    $("#listbtn").click(function(){
    	//var empnum = $("#empnum").val();
    	var sendData = $("#myform").serialize();  //seiallize()
    	console.log(sendData);
    	$.ajax({ 
					url:"/list",
					type:"post",
					data:sendData,  //"searchColumn="+gubun+"&searchStr="+str,  보내주고
					success:function(resString){    //받고
							console.log(resString);	 //String
							var jsonObj = JSON.parse(resString);   //객체 배열로
							console.log(jsonObj);		//객체
							makeHtml(jsonObj);
					}
    	
   	 	});
    });
    
    //---------------------------------------------------------------------
    $("#viewbtn").click(function(){
    	var sendData = $("#myform").serialize();
	  	$.ajax({ 
					url:"/list",
					type:"post",
					contentType: "application/x-www-form-urlencoded; charset=UTF-8",
					data:sendData,  //"searchColumn="+gubun+"&searchStr="+str,
					resultType:"json",
					success:function(resJson){
							console.log(resJson);	//String
							makeHtml(resJson);
					}
			});
    });
    
    
    function makeHtml(obj) {
			var htmlStr = "<ul>";
  	$.map(obj, function(vv, idx){
  		htmlStr += "<li>" + vv.empno + " " + vv.ename+ "</li>";
  	});
  	htmlStr += "</ul>";
  	$("#res").html(htmlStr);
	}
    
	
    
});
</script>
</head>
<body>
<form id="myform" >
<input type="text" id="empnum" name="empnum">
<input type="button" id="listbtn" value="list">
<input type="button" id="viewbtn" value="view">

(listbtn)  -->  /list   회원정보
(viewbtn)  -->  /view   회원정보 한명(empnumber)  --> 파라미터 하드코딩

servlet 2개나 1개로...
</form>
<div id="res"></div>
</body>
</html>