<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
var num=10;
function btnClick(aa, bb){
	alert("dddd"+(num+aa)+bb);
	console.log("dddd"+(num+aa)+bb);
}

function btnClick2(){
	var f = myform;  //document.myform;
	var uid = f.uid.value;
	var upw = f.upw.value;
	if (uid == "") {
			alert("id를 입력하세요");
			f.uid.focus();
			return false;
		} else if (upw == "") {
			alert("password를 입력하세요");
			f.upw.focus();
			return false;
		} else {
			f.submit(); //submit 효과를 볼 수 있다.
			alert(uid + ", " + upw);
			//f.target="myframe";  //페이지 이동이 가능하다.
		}
	}
</script>
</head>
<body>
<iframe name="myframe" width="600" height="450" frameborder="0" style="border:0" allowfullscreen></iframe>  <!-- 나의 창으로 볼때만 쓰고 아니면 왠만하면 사용안하는게 좋다.-->
<iframe src="https://www.google.com/maps/embed?pb" width="600" height="450" frameborder="0" style="border:0" allowfullscreen></iframe>

//InputTagServlet    /input_tag
<form name="myform" method="post" action="/input_tag" onSubmit="return btnClick2()">  <!--onSubmit="return btnClick2()" 한번에 submit과 image를 보낸다 -->

<input type="text" id="uid" class="uid" name="uid"><br>
<input type="password" name="upw"><br>

<input type="checkbox" name="habit" value="book">독서
<input type="checkbox" name="habit" value="mnt">등산
<input type="checkbox" name="habit" value="fish">낚시
<br>

<input type="radio" name="gen" value="m">남성
<input type="radio" name="gen" value="f">여성
<br>


<input type="hidden" name="bseq" value="1"><br>
<input type="file" name="ufile" value="첨부파일선택"><br>

<!-- / -->
<select name="tel">
	<option value="011">SKT</option>
	<option value="019">LGT</option>
	<option value="016">KT</option>
</select> <br>

<textarea cols="40" rows="10" name="content">여기 글씨...</textarea><br>

<!-- 버튼류 -->
<input type="reset" value="리셋버튼">
<input type="button"  value="일반버튼" onClick="btnClick2()">
<a href="http://www.homejjang.com">네이버</a>
<a href="/aa.html" >aa</a>
<a href="#" onclick="btnClick(80, 'hello')" >click</a>
<a href="javascript:btnClick2()">click</a>
<input type="image"  src="/img/33.jpg" width="200" height="200">

<img type="image" onClick="btnClick2()" src="/img/33.jpg" style="cursor:pointer">
<input type="submit"  value="서브밋버튼"><br>  <!-- onClick="return btnClick2()" -->

</form>
</body>
</html>