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
				
				$("select").change(function() {
					console.log($(this));
					//$("h3").text($("select").val()); 
					$("h3").text($(this).val());		
				});
			});		
		</script>
		
	</head>
	<body>
		
		<h3> 과목선택 </h3>
		<select>
			<option>java</option>
			<option>jsp</option>
			<option>spring</option>
			<option>project</option>
			<option>python</option>
		</select>
		
	</body>
</html>