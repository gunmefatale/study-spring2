<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		
		<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
		<script>
			$(document).ready(function() {
				$("li:nth-child(2)").css("color", "red");
				$("li").attr("class", "test");
			});
		</script>
		
	</head>
	<body>
	
		<ul>
			<li>text1 text1 text1</li>
			<li>text2 text2 text2</li>
			<li>text3 text3 text3</li>
			<li>text4 text4 text4</li>
		</ul>
	
	</body>
</html>