<%@ include file="../common/tag.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
 <meta charset="UTF-8">
    <link href="/css/header.css" rel="stylesheet">
    <link href="/css/footer.css" rel="stylesheet">
    <link href="/css/container.css" rel="stylesheet">
     <link href="/css/admin.css" rel="stylesheet">

<title>유저 관리</title>
</head>
<body>

<div class="container">
<%@include file="../common/header.jsp" %>
    <div class="form">
		<button id="" onclick="location.href='/admin/user/1'">회원관리</button>
		<button onclick="location.href='/admin/contents'">컨텐츠 관리</button> <br><br>
		<h3 id="main" > 전체 회원 </h3> <br>
		<table class="form" border=3>
			<tr>
				<th> 번호 </th>
				<th> 이메일 </th>
				<th> 닉네임 </th>
				<th> 신고 </th>
				<th> 마지막 로그인 </th>
				<th> 탈퇴  </th>
				<th> 블랙 </th>
			</tr>
			<c:forEach items="${userList }" var="list">
			<tr>
				<td id ="userSeq">${list.userSeq }</td>
				<td>${list.email }</td>
				<td>${list.nickname }</td>
				<td>${list.declaration }</td>
				<td>${list.lastloginDate }</td>
				<td><button id= "delUserBtn" style="border-color: #C0D8C0" onclick="location.href='/admin/user/manage/${list.userSeq }'">탈퇴</button></td>
				<td><button id= "black" onclick="location.href='/admin/user/manage/${list.userSeq }/${list.email }'">블랙</button></td>
			</tr>
			</c:forEach>
			<tr>
			<td colspan="7">
				<%
				int totalCnt = (int) request.getAttribute("totalCnt");
				int totalPage = 0;
				if (totalCnt % 10 == 0) {
					totalPage = totalCnt / 10;
				} else {
					totalPage = totalCnt / 10 + 1;
				}
				for (int i = 1; i <= totalPage; i++) {
				%>
				<a href="<%=i%>"><%=i%>페이지</a>
				<%
				}
				%>
			</td>
			</tr>
		</table>
	</div>
<%@include file="../common/footer.jsp" %>
</div>
</body>
</html>