<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>jQuery</title>
		
		<!-- download 방법 -->
		<!-- <script src="/spring/resources/js/jquery-3.6.0.min.js"></script> -->
		
		<!-- cdn 방식 -->
		<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
		
		<!-- jQuery 기본 구조 -->
		<script>
			/* test() 메서드 만들어서 버튼클릭시 실행 */
			/* function test() {
				console.log("javaScript test call");
				alert("js btn 클릭!");
			} */
		
			
			/* $(document).ready(function() {
				// 해당 구역 안에 javaScript, jQuery, aJax등 사용 구역 
				$(".btn2").click(function() {
					console.log("jQuery click event call");
					alert("jQuery btn click")
				});
			}); */
			
			
			/* $(document).ready(function() {
				// 해당 구역 안에 javaScript, jQuery, aJax등 사용 구역 
				$("#btn1").click(function() {
					console.log("jQuery click event call");
					alert("jQuery btn click")
				});
			});  */
			
			/* $(document).ready(function() {
				// 해당 구역 안에 javaScript, jQuery, aJax등 사용 구역 
				$("#btn1").click(function() {
					console.log("jQuery click event call");
					alert("jQuery btn click")
				});
			});  */
			
			
			/* $(document).ready(function() {
				// 해당 구역 안에 javaScript, jQuery, aJax등 사용 구역 
				$("button").click(function() {
					console.log("jQuery click event call");
					alert("jQuery btn click")
				});
			}); */
			
			
			$(document).ready(function() {
				// 해당 구역 안에 javaScript, jQuery, aJax등 사용 구역 
				$("#btn1").click(function() {
					console.log("jQuery click event call");
					alert("jQuery btn click")
				});
			});
		</script>
		
	</head>
	<body>
		
		<h1> jQuery01 page </h1>
		
		<!-- <button class="btn1" onclick="test()">btn1</button>
		<button class="btn2">btn2</button> -->
		
		<button class="btn1">btn1</button>
		<button class="btn1">btn2</button>
		
		<!-- <button id="btn1">btn2</button>
		<button id="btn2">btn2</button> -->
		<button>btn3</button>
		
	</body>
</html>