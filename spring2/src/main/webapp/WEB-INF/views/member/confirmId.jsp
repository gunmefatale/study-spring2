<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    

    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>ID 중복확인</title>
		<link href="/spring/resources/css/style.css" rel="stylesheet" type="text/css" >
	</head>
	
	<body>
		<br />
		<c:if test="${result == 1}">	<!-- db에 id가 존재하는 경 -->
			<table>
				<tr>
					<td>${trialId}, 이미 사용중인 아이디 입니다. </td>
				</tr>
			</table>
			<br />
			<form action="/spring/member/confirmId.do" method="get">
				<table>
					<tr>
						<td> 다른 아이디를 선택하세요. <br />
							<input type="text" name="id" />
							<input type="submit" value="ID중복확인" /> 
						</td>
					</tr>
				</table>
			</form>
		</c:if>	
		<c:if test="${result != 1}">	<!-- id가 존재하지 않는 경우 즉, 사용가능한 경우 -->
			<table>
				<tr>
					<td>입력하신 ${trialId},는 사용가능한 아이디 입니다. <br />
						<input type="button" value="닫기" onclick="setId()"/>
					</td>
				</tr>
			</table>
		</c:if>
		
		<script>
			function setId(){
				// signupForm 페이지의 id 태그 값 변경해주기 
				opener.document.inputForm.id.value = "${trialId}";  
				self.close(); // 팝업창 닫기
			}
		</script>
		
	</body>
</html>