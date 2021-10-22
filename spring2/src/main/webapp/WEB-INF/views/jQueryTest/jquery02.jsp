<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>jquery02</title>
		<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
		<script>
			$(document).ready(function() {
				$("h3").css("color", "red");
				$("#id1").css("color", "green");
				$(".cls1").css("color", "blue");
				
			});
			
		</script>
		
		
	</head>
	<body>
	
		<h3> hello jQuery </h3>
		<h3 id="id1"> id selector </h3>
		<h3 class="cls1"> class selector </h3>
	
	</body>
</html>