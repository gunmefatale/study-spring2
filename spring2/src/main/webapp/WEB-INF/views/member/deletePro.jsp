<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	
		<c:if test="${result == 1}">
			<c:redirect url="/member/main.do" />
		</c:if>
		<c:if test="${result != 1}">
			<script>
				alert("비밀번호가 맞지 않습니다...");
				history.go(-1);
			</script>
		</c:if>
	
	<body>
	
	</body>
</html> 