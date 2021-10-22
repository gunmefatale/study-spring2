<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원가입</title>
		
		<link href="/spring/resources/css/style.css" rel="stylesheet" type="text/css" >
		
		<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
		<script>
			/*
			function confirmId(inputForm){  
				if(inputForm.id.value == "" || !inputForm.id.value) {
					alert("아이디를 입력하세요");
					return;
				}
				// 팝업 띄우기
				var url = "/spring/member/confirmId.do?id=" + inputForm.id.value; 
				open(url, "confirmId", "toolbar=no, location=no, status=no, menubar=no, scrollbars=no, resizable=no, width=300, height=200"); 
			}
			*/
			
			// ajax
			$(document).ready(function() {
				
				// <input> 태그의 id="id" 속성값을 가지고 있는 란에 변화가 있을때 동작.
				$("#id").change(function() {
					// 변수 생성하여 사용자가 id 입력란에 작성한 id값 꺼내기
					var idVal = $("#id").val();
					// web 브라우저 f12 관리자 모드에 console에 변수 값 띄우
					console.log("id : " + idVal);
					
					// ajax 사용 선언 
					$.ajax({
						// 요청주소 
						url : "/spring/member/ajaxIdAvail.do",
						// 타입 설정 
						type : "post",
						// data 설정 
						data : {id : idVal},
						// success 실행할 코드들 
						success : function(data) {			// data 매개변수 = Controller에서 return해준 결과가 대입 
							console.log("success!!!");
							console.log("data : " + data);
							// 결과를 idCheckRes 태그에 적용 코드 작성 
							$("#idCheckRes").val(data);
						},
						// error 시 실행될 코드들 
						error : function(e) {
							console.log("error...");
							console.log(e);
						}
						
					}); // close of the 'ajax'
					
				});	// close of the 'change'
				
			}); // close of the 'ready'
			
		</script>
		
	</head>
	<body>
		<br />
		<h1 align="center"> 회원가입 </h1>
	
		<form action="/spring/member/signupPro.do" method="post" name="inputForm" >
			<table>
				<tr>
					<td>ID * </td>
					<td>
						<input type="text" name="id" id="id" /> 
					</td>
				</tr>
				<tr>
					<td>아이디중복체크 ajax</td>
					<td>
						<input type="text" id="idCheckRes" disabled /> 	<%-- disabled : 비활성화 --%>
					</td>
				</tr>
				<tr>
					<td>아이디중복체크</td>
					<td>
						<input type="button" value="아이디 중복 확인" onclick="confirmId(this.form)" /> 
					</td>
				</tr>
				<tr>
					<td>Password * </td>
					<td>
						<input type="password" name="pw" /> 
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
						<input type="text" name="name" /> 
					</td>
				</tr>
				<tr>
					<td>Age </td>
					<td>
						<input type="text" name="age" />
					</td>
				</tr>
				<tr>
					<td>Email </td>
					<td>
						<input type="text" name="email" /> 
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center"> 
						<input type="submit" value="가입" /> 
						<input type="reset" value="재작성" /> 
						<input type="button" value="취소" onclick="window.location='/spring/member/main.do'"/> 
					</td>
				</tr>
			</table>
		</form>
	
	</body>
</html>