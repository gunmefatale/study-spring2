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
				
				/* <input>태그에 커서 깜빡거리는거 해주기. 즉, focus해주기. */
				$("#id1").focus();
				
				$("button").click(function() {
					/* var txt = $("#id1");
					alert(txt); */
					alert($("#id1").val());
					$("h3").text($("id1").val());
					
					/* <input>태그에 입력값 없애주기. ""로 해주기. */					
					$("#id1").val("");
				});
			});
		</script>
		
	</head>
	<body>
	
		<h3> 입력값 확인 하기 </h3>	
		<input type="text" name="id" id="id1" />
		<button>check</button>
	
	</body>
</html>