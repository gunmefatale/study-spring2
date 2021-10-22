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
	<%-- // check == 0 : 비로그인  check == 1 : 로그인 --%>
	<%-- <c:if test="${check == 0}">
		<script>
			alert("로그인후 이용해주세요"); 
			window.location = "/spring/member/loginForm.do";
		</script>
	</c:if> --%>
	
	<%-- <c:if test="${check != 0}"> --%>
	<body>
		<br />
		<h1 align="center"> 회원 정보 수정</h1>
		<form action="/spring/member/modifyPro.do" method="post" >
			<table>
				<tr>
					<td>ID * </td>
					<td>
						${member.id}
					</td>
				</tr>
				<tr>
					<td>Password * </td>
					<td>
						<input type="password" name="pw" value="${member.pw}" /> 
					</td>
				</tr>
				<tr>
					<td>Password Confirm * </td>
					<td>
						<input type="password" name="pwCh" /> 
					</td>
				</tr>
				<tr>
					<td>Name * </td>
					<td>
						<input type="text" name="name" value="${member.name}" />
					</td>
				</tr>
				<tr>
					<td>Age </td>
					<td>
						<input type="text" name="age" value="${member.age}"/>
					</td>
				</tr>
				<tr>
					<td>Email </td>
					<td>
						<input type="text" name="email" value="${member.email}"/>
					</td>
				</tr>
				<%-- <tr>
					<td>Photo </td>
					<td>
						<c:if test="${member.photo != null}">
							<img src="/web/save/${member.photo}" width="150" />
						</c:if>
						<c:if test="${member.photo == null}">
							<img src="/web/save/default.png" width="150"/>
						</c:if>
					
						<input type="file" name="photo" />
						<input type="hidden" name="exPhoto" value="${member.photo}" /> 이전 저장된 사진 정보
					</td>
				</tr> --%>
				<tr>
					<td colspan="2" align="center"> 
						<input type="submit" value="수정" /> 
						<input type="button" value="취소" onclick="window.location='/spring/member/main.do'"/> 
					</td>
				</tr>
			</table>
		</form>
	</body>
	<%-- </c:if> --%>

</html>