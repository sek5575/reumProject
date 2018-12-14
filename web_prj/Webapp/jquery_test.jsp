<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script
  src="https://code.jquery.com/jquery-3.3.1.js">
</script>
<script>
// $()._____.(function(){} );
/* $("#runBtn").click(function(){
	
});
$(".yb").click();
 */	
 
$(document).ready(function(){   //document는 여기 jsp파일을 말한다.  jquery의 시작과 끝을 여기서 시작한다.
	//alert("d");	
	/* $("#runBtn").click(function() {
		alert("런버튼클릭");
		scriptFunc();
	}); */
	
	//동적으로 생성된 버튼이라서 이벤트 감지 못함, on으로 사용해야함.
 	/* $(".yb").click(function(){
	    //$(this).hide();
	    var str = "";
	    str += "<input type='button' class='yb' value='a'>";
	    str += "<input type='button' class='yb' value='b'>";
	    str += "<input type='button' class='yb' value='c'>";
	    
	    $("#btndiv").html(str);
	}); */

	$(".ybs").on("click", function(){
	    //$(this).hide();
	    alert("ddd");
	   	$("#btndiv").removeAttr();
		
	    var str = "";
	    str += "<input type='button' class='ybs' value='a'>";
	    str += "<input type='button' class='ybs' value='b'>";
	    str += "<input type='button' class='ybs' value='c'>";
	    
	    $("#btndiv").html(str);
	}); 
	
	/* $(document).on("click", ".ybs", function(){
	    //$(this).hide();
	    alert("ddd");
	   	$("#btndiv").removeAttr();
		
	    var str = "";
	    str += "<input type='button' class='ybs' value='a'>";
	    str += "<input type='button' class='ybs' value='b'>";
	    str += "<input type='button' class='ybs' value='c'>";
	    
	    $("#btndiv").html(str);
	}); //동적으로 생성 */

});
</script>
<script>
function scriptFunc(){
	alert("스크립트메서드");
}
</script>

</head>
<body>
<input type="button" value="Script실행" onClick="scriptFunc()">
<br>
<form name="myform" method="post" action="/input_tag" >  <!--onSubmit="return btnClick2()" 한번에 submit과 image를 보낸다 -->
<input type="text" id="uid" class="uid" name="uid"><br>
<input type="password" name="upw" ><br>

<input type="button" id="runBtn" class="ybs" value="jQuery 실행">
<input type="button" id="runBtn2" class="ybs" value="jQuery 실행2">
<div id="btndiv"></div>


</form>
</body>
</html>