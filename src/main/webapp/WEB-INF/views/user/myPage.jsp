<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@include file="../common/tag.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="/css/header.css" rel="stylesheet">
<link href="/css/footer.css" rel="stylesheet">
<link href="/css/container.css" rel="stylesheet">
<!-- <link href="/css/login.css" rel="stylesheet"> -->
<link href="/css/quiz.css" rel="stylesheet">
<title>myPage</title>
<style type="text/css">
.myDiv{
height:80px;
border: 1px solid black;
margin: auto;
}
label {
    width: 180px;
    display: inline-block;
    margin-top: 23px;
    margin-left: 50px;
}
</style>
</head>
<body>
	<div class="container">
		<%@include file="../common/header.jsp"%>
		<div class="content">
		<div style="display: block; width:100%;">
		<form action="<%=request.getContextPath()%>/user/update/${userDto.userSeq}">
			<h1>마이페이지</h1><br>
			<div class="myDiv">
				<label>닉네임</label>
				<div style="display: inline;"> ${userDto.nickname}</div>
			</div>
			<div class="myDiv">
				<label>이메일</label>
				<div style="display: inline;"> ${userDto.email}</div>
			</div>
			<div class="myDiv">
				<label>phone</label>
				<div style="display: inline;"> ${userDto.phone}</div>
			</div>
			<div class="myDiv">
				<label>가입일자</label>
				<div style="display: inline;"> ${userDto.insertDate}</div>
			</div>
				<input type="button" value="정보수정하기" >
				<input type="button" value="오답노트">
			</form>
		</div>
		</div>
		<%@include file="../common/footer.jsp"%>
	</div>
</body>
</html>