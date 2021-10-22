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
				$("button").click(function() {
					$("img").attr("src", "/spring/resources/imgs/gogh02.jpeg")		
				});
			});
		</script>
		
		
	</head>
	<body>
	
		<button>click!!!</button>	<br />
		<img src="/spring/resources/imgs/gogh01.png" width="350">
	
	</body>
</html>