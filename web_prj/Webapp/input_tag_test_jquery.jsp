<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
	
})

$(document).ready(function(){
     $("#checkBtn").click(function(){
    	 
    	if($("#uid").val() == ""){
        	alert("id를 입력하시오.")
            $("#uid").focus();
        	return false;
        } else if($("#upw").val() == ""){
        	alert("pw를 입력하시오.")	
            $("#upw").focus();
        	return false;
        }
    	else{
        	$("[name=myform]").submit();
        	//$("#myform").submit();
        }  
    	
    	
    	
        //console.log("uid:"  + $("#uid").val());
        //console.log("uid:"  + $("#uid").val());
        
        /* console.log("uid:"  + $("#uid").val());
        console.log("upw:"  + $("#upw").val());
       	console.log("bseq:" + $("#bseq").val());
        console.log("ufile:"+ $("#ufile").val());
        console.log("tel:"  + $("#tel").val());
        console.log("tel:"  + $("#tel option:selected").val());
        console.log("content:" + $("#content").val());         //id로
        
        console.log("gen:" + $("input[type='radio'][name='gen']:checked").val());
        console.log("gen:" + $(":input:radio[name='gen']:checked").val());
        console.log("gen:" + $(":radio[name='gen']:checked").val());
        
        console.log("gen:" + $("[name='gen']:checked").val())  //나머진 name으로
        
        console.log("gen:" + $(".gen:checked").val());  */        //class
        
        
        $.each( $("[name='habit']:checked"), function(){
        	console.log($(this).val() + ":RADIO");
        }); 
        
        $.each( $(".hab:checked"), function(){
        	console.log($(this).val() + ":RADIO");
        });
        
        //// id접근에러 XXXXXXXXXXX ("gen:" $("#gen:checked").val());
        
        //alert("uid: " + $("#uid").val());
        //alert("tel: " + $("#tel").val("016"));
       	//alert("gen: " + $("#gen:checked").val());
        //alert("memo: " + $("#memo").val("sss"));
        
    });
});
</script>
</head>
<body>
<form name="myform" method="post" action="/input_tag_jquery" >  <!--onSubmit="return btnClick2()" 한번에 submit과 image를 보낸다 -->

<input type="text" id="uid" class="uid" name="uid"><br>
<input type="password" id="upw" name="upw"><br>

<input type="checkbox" name="habit" class="hab" value="book">독서
<input type="checkbox" name="habit" class="hab" value="mnt">등산
<input type="checkbox" name="habit" class="hab" value="fish">낚시
<br>

<input type="radio"  name="gen" class="gen" value="m">남성
<input type="radio" name="gen" class="gen" value="f">여성
<br>


<input type="hidden" id="bseq" name="bseq" value="1"><br>
<input type="file" id="ufile" name="ufile" value="첨부파일선택"><br>

<!-- / -->
<select id="tel" name="tel">
	<option value="011">SKT</option>
	<option value="019">LGT</option>
	<option value="016">KT</option>
</select> <br>

<textarea cols="40" rows="10"  id="content" name="content">여기 글씨...</textarea><br>

<!-- 버튼류 -->
<input type="button" id="checkBtn" value="일반버튼"><br>	


</form>

</body>
</html>