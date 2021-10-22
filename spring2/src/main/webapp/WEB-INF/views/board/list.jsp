<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
	<head> 
		<meta charset="UTF-8">
		<title>게시판</title>
		<link href="/spring/resources/css/style.css" rel="stylesheet" type="text/css">
	</head>
	
	<body>
		<br />
		<div align="right"> 
			<c:if test="${sessionScope.sid == null}">
				<button onclick="window.location='/spring/member/loginForm.do'">로그인</button>
			</c:if>
			<c:if test="${sessionScope.sid != null}">
				<button onclick="window.location='/spring/member/logout.do'">로그아웃</button>
			</c:if>
		</div>
		
		<h1 align="center"> 게시판 </h1>
		
		<c:if test="${count == 0}">
		<table>
			<tr>
				<td><button onclick="window.location='/spring/board/writeForm.do'"> 글쓰기 </button></td>
			</tr>
			<tr>
				<td align="center">게시글이 없습니다.</td>
			</tr>
		</table>
		</c:if>
		
		<c:if test="${count != 0}">
		<table>
			<tr>
				<td colspan="5" align="right"><button onclick="window.location='/spring/board/writeForm.do'"> 글쓰기 </button></td>
			</tr>
			<tr>
				<td>No.</td>
				<td>제  목</td>
				<td> num / ref / re_step / re_level </td>
				<td>작성자</td>
				<td>시  간</td>
				<td>조회수</td>
			</tr>
			<c:forEach var="article" items="${articleList}">
				<tr>
					<td>${number}
						<c:set var="number" value="${number - 1}" /> 
					</td>
					<td align="left">
						<c:set var="wid" value="0" />
						<c:if test="${article.re_level > 0}">
							<c:set var="wid" value="${10 * article.re_level}" />
							<img src="/spring/resources/imgs/tabImg.PNG" width="${wid}" />
							<img src="/spring/resources/imgs/replyImg.png" width="11" /> 
						</c:if>
						<a href="/spring/board/content.do?num=${article.num}&pageNum=${pageNum}"> ${article.subject} </a>
					</td>
					<td> ${article.num} / ${article.ref} / ${article.re_step} / ${article.re_level} </td>
					<td><a href="mailto:${article.email}"> ${article.writer} </a></td>
					<td> ${article.reg} </td>
					<td> ${article.readcount} </td>
				</tr>
			</c:forEach>
		</table>
		</c:if>
		
		<br /> <br /> 
		<%-- 페이지 번호 --%>
		<div align="center">
		<c:if test="${count > 0}">
			<c:set var="pageBlock" value="3" />
			<fmt:parseNumber var="res" value="${count / pageSize}" integerOnly="true" />
			<c:set var="pageCount" value="${res + (count % pageSize == 0 ? 0 : 1)}" />
			<fmt:parseNumber var="result" value="${(currentPage-1)/pageBlock}" integerOnly="true" />
			<fmt:parseNumber var="startPage" value="${result * pageBlock + 1}"/>
			<fmt:parseNumber var="endPage" value="${startPage + pageBlock -1}" />
			<c:if test="${endPage > pageCount}">
				<c:set var="endPage" value="${pageCount}" /> 
			</c:if>
			
			<%-- 검색했을때 페이지번호들 --%>
			<c:if test="${sel != null && search != null}">
				<c:if test="${startPage > pageBlock}">
					<a href="/spring/board/list.do?pageNum=${startPage-pageBlock}&sel=${sel}&search=${search}" class="pageNums"> &lt; &nbsp;</a>
				</c:if>
				<c:forEach var="i" begin="${startPage}" end="${endPage}" step="1">
					<a href="/spring/board/list.do?pageNum=${i}&sel=${sel}&search=${search}" class="pageNums"> &nbsp; ${i} &nbsp; </a>
				</c:forEach>
				<c:if test="${endPage < pageCount}">
					&nbsp; <a href="/spring/board/list.do?pageNum=${startPage+pageBlock}&sel=${sel}&search=${search}" class="pageNums"> &gt; </a>
				</c:if>
			</c:if>
			
			<%-- 검색 안했을때 페이지번호들   --%> 
			<c:if test="${sel == null || search == null}">
				<c:if test="${startPage > pageBlock}">
					<a href="/spring/board/list.do?pageNum=${startPage-pageBlock}" class="pageNums"> &lt; &nbsp;</a>
				</c:if>
				<c:forEach var="i" begin="${startPage}" end="${endPage}" step="1">
					<a href="/spring/board/list.do?pageNum=${i}" class="pageNums"> &nbsp; ${i} &nbsp; </a>
				</c:forEach>
				<c:if test="${endPage < pageCount}">
					&nbsp; <a href="/spring/board/list.do?pageNum=${startPage+pageBlock}" class="pageNums"> &gt; </a>
				</c:if>
			</c:if>
			
		</c:if> <%-- end:count > 0 --%>
		
		
		<br /> <br />
		<%-- 작성자/내용 검색 --%>
		<form action="/spring/board/list.do">
			<select name="sel">
				<option value="writer">작성자</option>
				<option value="content">내용</option>
			</select>
			<input type="text" name="search" />
			<input type="submit" value="검색" />
		</form> <%-- /spring/board/list.do?sel=writer&search=aaa --%>
		<br />
		
		<h3 style="color:grey"> 현재페이지 : ${pageNum} </h3>
		<br /> 
		<c:if test="${sel != null && search != null}">
			<button onclick="window.location='/spring/board/list.do'"> 전체 게시글 보기 </button> <br />
		</c:if>
		<button onclick="window.location='/spring/member/main.do'"> 메인으로 </button>
		</div>
		
	</body>
</html>
