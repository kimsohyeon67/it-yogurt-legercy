<%@ include file="../common/tag.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html>
<html>
<head>
 <meta charset="UTF-8">
    <link href="/css/header.css" rel="stylesheet">
    <link href="/css/footer.css" rel="stylesheet">
    <link href="/css/container.css" rel="stylesheet">
     <link href="/css/admin.css" rel="stylesheet">
<title> 마이페이지 | 관리자 </title>
</head>
<body>

<div class="container">
<%@include file="../common/header.jsp" %>
    <div class="form">
		<h3 id="main" > 회원 관리 </h3> <br>
		<button id="" onclick="location.href='user'">회원관리</button>
		<button onclick="location.href='contents'">컨텐츠 관리</button>
	</div>
<%@include file="../common/footer.jsp" %>
</div>
</body>
</html>