<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link href="/spring/resources/css/style.css" rel="stylesheet" type="text/css" >
	</head>
	
	<body>
		<br />
		<h1 align="center"> mypage </h1>
		<table>
			<tr>
				<td>
					<b>${sessionScope.sid}</b> <br /><br />
				 	<%-- <img src="/spring/save/${photo}" width="250"/>  --%>
				</td>
			</tr>
			<tr>
				<td>
	 				<button onclick="window.location='/spring/member/modifyForm.do'">회원 정보 수정</button>
	 				<button onclick="window.location='/spring/member/deleteForm.do'">회원 탈퇴</button>
	 				<button onclick="window.location='/spring/member/main.do'">메인</button>
				</td>
			</tr>
		</table>
		
	</body>
</html> 