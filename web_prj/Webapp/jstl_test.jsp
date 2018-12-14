<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.ArrayList, com.kosmo.web.EmpVO"
    %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
    	prefix="c"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>	
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
	function loopTest(){
		for(var i=0; i<5; i++){
			console.log(i);
		}
	}
</script>

<script>   //jquery 문법 루프
$(document).ready(function(){
	var arr = ["abc", "edf", "fas"];   //new Array();
	
	//for(int ix=0; idx<arr.length; idx++){
	//	String vv = arr[idx];
	//	out.println(idx + " : " + vv);
	//}
    $.each(arr, function(idx, vv){      //lamda(자바) 람다 메소드   / 콜백메서드(자바스크립트, jquery)   --> 이름 없는 1회용 메소드
    	console.log(idx + " : " + vv);
    });
    
    $(arr).each(function(idx, vv){
    	console.log(idx + " : " + vv);
    });
    
    $.each(arr, myfunc);
    $(arr).each(myfunc);
    
    function myfunc(idx, vv){
    	console.log(idx + " : " + vv);
    }
    //-----------------------------------
   	console.log("//---------------------------");
    var map = {"uid":"kim" , "upw":"111"};
    console.log(map.uid);
    var marr = $.makeArray(map);    //makeArray 배열화 시켜주는것
    console.log(marr);
    console.log("//---------------------------");
    //-----------------------------------
    		//json 표기법: 키땡땡 벨류
    		//type: 맵
  	var maps = [{"uid":"kim" , "upw":"111"},
  				{"uid":"lee" , "upw":"111"},
  				{"uid":"park" , "upw":"111"}];
    console.log(maps[0].uid);
    console.log(maps[1].uid);
    
    $.each(maps, function(idx, vv){  
    	console.log(".each maps : " + vv.uid);
    });
    
    $.map(maps, function(vv, idx){  // index랑 vv랑 위치가 바뀐다.
    	console.log(".map maps : " + vv.uid);
    });
    
    
    
    for(idx in maps){  
    	console.log(maps[idx].uid);
    }
    
    for(var idx=0; idx<maps.length; idx++){
    	console.log(maps[idx].uid);
    }

});

/* function myfunc(idx, vv){
	console.log(idx + " : " + vv);
} */

</script>

</head>
<body onLoad="loopTest()">
<%-- <%
int tot = Integer.parseInt(request.getAttribute("KEY_TOTAL").toString());
ArrayList<EmpVO> list = (ArrayList<EmpVO>)request.getAttribute("KEY_LIST");
out.println(tot);
for(int i=0; i<list.size();i++){
	out.println(list.get(i).getEname());
}
%>  --%>
	
el: ${KEY_TOTAL}건<br>
<c:forEach var="vovo" items="${KEY_LIST}">
	${vovo.ename}
	${vovo.empno}  <br>
</c:forEach>


<%
//String uid = request.getParameter("uid");
//out.println(uid);
%>
//get 주소 방식으로받은 param  <br>	
el로 받은 값 : ${param.uid} <br>	  

el로 받은 LIST.get(0) 값 : ${KEY_FR.ename} , ${KEY_FR.empno}<br>



<% for(int i=0; i<10; i++){
	//out.prinln(i);
}
%>

<c:forEach var="i" begin="0" end="9" step="1">
	${i}
</c:forEach>

<%if(10>9){%> 
	크다
<%} %>
<c:if test="${10 > 9}">
크다.
</c:if>

<c:if test="${name == 'a'}">
a가 나왓구나
</c:if>

</body>
</html>