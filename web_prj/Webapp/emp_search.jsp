<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
#searchStr {
    background-image: url('/img/search.png');
    border-box: box-sizing;
    background-position: 14px 12px;
    background-repeat: no-repeat;
    font-size: 16px;
    padding: 14px 20px 12px 45px;
    border-bottom: 1px solid #ddd;
    border: 1px solid #ddd;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
	
    $("#String-String").click(function(){
			//var searchColumn = $("#searchColumn").val();
	    	//var searchStr = $("#searchStr").val();
	    	/* 
	    	var gubun1 = $("[name='searchColumn']").val();
	    	var str1 = $("[name='searchStr']").val();
	    	*/
	    	var sendData = $("#myform").serialize();  //seiallize()
	    	$.ajax({ 
						url:"/emp",
						type:"post",
						contentType: "application/x-www-form-urlencoded; charset=UTF-8",
						data:sendData,  //"searchColumn="+gubun+"&searchStr="+str,
						success:function(resString){
								console.log(resString);	//String
								var jsonObj = JSON.parse(resString);   //객체 배열로
								console.log(jsonObj);		//객체
								makeHtml(jsonObj);
						}
			});
    });
    
    
    $("#StringJson-String").click(function(){
	    	var searchColumn = $("#searchColumn").val();
	    	var searchStr = $("#searchStr").val();
		 	var sendData = {"searchColumn":searchColumn, "searchStr":searchStr};

				$.ajax({ 
							url:"/emp",
							type:"post",
							contentType: "application/x-www-form-urlencoded; charset=UTF-8",   
							data:"MYKEY="+JSON.stringify(sendData),  //MYKEY="{"searchColumn":searchColumn, "searchStr":searchStr}"
							success:function(resString){
									console.log(resString);	//String
									var jsonObj = JSON.parse(resString);  // String -> object
									console.log(jsonObj);		//객체
									makeHtml(jsonObj);
							}
					});
		});
    
	  $("#String-Json").click(function(){
			var sendData = $("#myform").serialize();
		  	$.ajax({ 
						url:"/emp",
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
  
  
	 $("#Json-String").click(function(){
		 	var searchColumn = $("#searchColumn").val();
	    	var searchStr = $("#searchStr").val();
		 	var sendData = {"searchColumn":searchColumn, "searchStr":searchStr};

		  	$.ajax({ 
						url:"/emp",
						type:"post",
						contentType: "application/json; charset=UTF-8", 
						data:JSON.stringify(sendData),  
						success:function(resString){
								console.log(resString);	//String
								var jsonObj = JSON.parse(resString);
								console.log(jsonObj);		//객체
								makeHtml(jsonObj);
						}
				});
	 });
	 
	 
	 $("#Json-Json").click(function(){
		 	var searchColumn = $("#searchColumn").val();
	    	var searchStr = $("#searchStr").val();
		 	var sendData = {"searchColumn":searchColumn, "searchStr":searchStr};
		  	$.ajax({ 
						url:"/emp",
						type:"post",
						contentType: "application/json; charset=UTF-8", 
						data:JSON.stringify(sendData),
						resultType:"json",
						success:function(resJson){
							console.log(resJson);	//Object
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
	  	$("#resdiv").html(htmlStr);
 	}
    
});


/* function httpAjax() {
	var f = myform;  //document.myform;
	var searchStr = f.searchStr.value;

	if(searchStr =="") {
		alert("검색어를 입력하세요");
		f.searchStr.focus();
		return false;
	} else {
		  var xhttp = new XMLHttpRequest();
		  xhttp.onreadystatechange = function() {
		    if (this.readyState == 4 && this.status == 200) {
		      document.getElementById("resdiv").innerHTML = this.responseText;
		    }
		  };
		  xhttp.open("post", "/emp", true);
		  xhttp.send();
		//f.submit();
	}
}  */

</script>
</head>
<body>
 	${sessionScope.SESS_NAME}
			<%
			Cookie[] carr = request.getCookies();
            if(carr != null){
            	for(int i=0; i<carr.length; i++){
                	Cookie c = carr[i];
                	out.println(c.getName() + ", " + c.getValue()+ "<br>");
                }
            }
            
			%>
			
<!--  <form name="myform" method="post" action="/emp"> -->
<form id="myform">
	<select name="searchColumn" id="searchColumn">
		<option value="ename">이름</option>
		<option value="deptno">부서</option>
		<option value="job">직업</option>
	</select> <br>
	<input type="text" placeholder="Search.." name="searchStr" id="searchStr"><br>
	
	<!-- 버튼류 --> 
	<input type="reset" value="리셋버튼"> 
	<input type="button" id="String-String" value="String-String">
	<input type="button" id="StringJson-String" value="StringJson-String">
	<input type="button" id="String-Json" value="String-Json">
	<input type="button" id="Json-String" value="Json-String">
	<input type="button" id="Json-Json" value="Json-Json">
	
<!-- <input type="button" value="일반검색버튼" onClick="httpAjax()"> -->
</form>


<div id="resdiv"></div>


</body>
</html>