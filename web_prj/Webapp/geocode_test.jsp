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
	 $("#btn").click(function(){
				$.ajax({
						url:"https://maps.googleapis.com/maps/api/geocode/json?",
						type:"get",
						data:"address=가산동&key=AIzaSyD_Hz_uYHAvh3-ETmGyNfPg3IykZ56ZAdY",  //MYKEY="{"searchColumn":searchColumn, "searchStr":searchStr}"
						resultType:"json",
						success:function(resjson){
								console.log(resjson);	
								var htmlStr = "";
								
							  	$.map(resjson.results, function(vv, idx){
							  		var address = vv.formatted_address;
							  		var lat = vv.geometry.location.lat;
							  		var lng = vv.geometry.location.lng;
							  		console.log(address);
							  		console.log(lat);
							  		console.log(lng);
							  		htmlStr += address + ", " + lat + ", " + lng + "<br>";
							  	});
							  	//console.log(resjson.results[0].formatted_address);
							  	$("#resdiv").html(htmlStr);
								//$("#resdiv").html(addr+"<br>"+lat+","+lng);
						}
				});
	 	});
	});
</script>
</head>
<body>
<input type="button" id="btn" value="geocode">
<div id="resdiv"> </div>
</body>
</html>