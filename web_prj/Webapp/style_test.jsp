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
    //$("#Btn").click(function(){
    //   todo
    //});
});
</script>

<style>
</style>

<link rel="stylesheet" href="/css/my.css">

</head>
<body>
	<table class="blueTable">
		<thead>
			<tr>
				<th>empno</th>
				<th>ename</th>
				<th>hiredate</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${KEY_LIST}" var="vovo">
			<tr>
				<td>${vovo.empno}</td>
				<td>${vovo.ename}</td>
				<td>${vovo.hiredate}</td>
			</tr>
		</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="3">
					<div class="links">
						<a href="#">&laquo;</a> <a class="active" href="#">1</a> <a
							href="#">2</a> <a href="#">3</a> <a href="#">4</a> <a href="#">&raquo;</a>
					</div>
				</td>
			</tr>
		</tfoot>
	</table>

<br>

<table class="blueTable" border=1>
<thead>
<tbody>
<tr>
<th>aa</th>
</tr>
</tbody>
</thead>
<tr><td>bb</td></tr>
<tfoot>
		<tr>
			<td>
				<div class="links">
					<a href="#">&laquo;</a> <a class="active" href="#">1</a> 
					<a href="#">2</a> <a href="#">3</a> <a href="#">4</a> <a href="#">&raquo;</a>
				</div>
			</td>
		</tr>
</tfoot>
</table>

<br>

<table class="mytable" border=1>
<tr><td>aa</td></tr>
<tr class="trh"><td>bb</td></tr>
</table>

<img src="/img/33.jpg" id="myimg" class="mytable2">

</body>
</html>