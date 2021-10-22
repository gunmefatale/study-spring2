<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link href="/spring/resources/css/style.css" rel="stylesheet" type="text/css" >
	</head>
	<body>
		<br />
		<h1 align="center"> Main </h1>
		
		<c:if test="${sessionScope.sid == null}">
		<table>
			<tr>
				<td> 로그인 원하시면 버튼을 누르세요. <br />
					<button onclick="window.location='/spring/member/loginForm.do'"> 로그인 </button>
				</td>
			</tr>
			<tr>
				<td> 
					<button onclick="window.location='/spring/member/signupForm.do'"> 회원가입 </button>
				</td>
			</tr>
		</table>
		</c:if>
		
		<c:if test="${sessionScope.sid != null}">
		<table>
			<tr>
				<td> ${sessionScope.sid} 님 환영합니다. <br />
					<button onclick="window.location='/spring/member/logout.do'"> 로그아웃 </button>
				</td>
			</tr>
			<tr>
				<td> 
					<button onclick="window.location='/spring/member/mypage.do'"> 마이페이지 </button>
				</td>
			</tr>
		</table>
		</c:if>
		
	</body>
</html>