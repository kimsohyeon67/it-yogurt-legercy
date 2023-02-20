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

<title> 관리자 | 유저관리 </title>
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
				<td><button class= "delUserBtn" style="border-color: #C0D8C0" onclick="clicked(${list.userSeq },'${list.nickname }')">탈퇴</button></td>
				<td><button class= "black" onclick="black(${list.userSeq },'${list.email }','${list.nickname }')">블랙</button></td>
			</tr>
			</c:forEach>
			<tr>
			<td colspan="7">
				<%
				int totalUserCnt = (int) request.getAttribute("totalUserCnt");
				int totalPage = 0;
				if (totalUserCnt % 10 == 0) {
					totalPage = totalUserCnt / 10;
				} else {
					totalPage = totalUserCnt / 10 + 1;
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
<script>

function clicked(clickedID,clickedName){
	if (window.confirm(clickedName +"회원을 탈퇴시키겠습니까?"+ "\n\n"+"모든 회원 데이터가 삭제됩니다.\n")){
		location.href="/admin/user/manage/"+clickedID;
		alert("회원탈퇴 되었습니다.");		
	}
	else {
		alert("회원 탈퇴가 취소되었습니다.");		
	}
}
function black(clickedID,clickedEmail,clickedName){
	if (window.confirm(clickedName +"회원을 블랙하시겠습니까?"+ "\n\n"+"모든 회원 데이터가 삭제됩니다.\n")){
	location.href="/admin/user/manage/"+clickedID+"/"+clickedEmail;
	alert("회원을 블랙했습니다.");
	}
	else {
		alert("블랙이 취소되었습니다.");		
	}
	
}
</script>
</html>