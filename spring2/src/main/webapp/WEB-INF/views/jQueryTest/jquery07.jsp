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
				
				$("#s").click(function() {
					//$("img").show();
					//$("img").fadeIn();
					//$("img").slideDown();
					//$("img").fadeToggle();
					//$("img").slideToggle();
					$("img").fadeTo("slow", 0.5);
				});
				$("#h").click(function() {
					//$("img").hide();
					//$("img").fadeOut();
					//$("img").slideUp();
					
				});
				
			});
		</script>
		
	</head>
	<body>
	
		<button id="s">show</button>	
		<button id="h">hide</button>	<br />
		<img src="/spring/resources/imgs/gogh01.png" width="350">
	
	</body>
</html>