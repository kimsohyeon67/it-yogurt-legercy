<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="/css/header.css" rel="stylesheet">
<link href="/css/footer.css" rel="stylesheet">
<link href="/css/container.css" rel="stylesheet">
<link href="/css/login.css" rel="stylesheet">
<title>퀴즈 풀기</title>
</head>
<body>
<h1>퀴즈풀기</h1>
<div class="container">
		<%@include file="../common/header.jsp"%>
		<div class="content">
			<div>
				<form action=" ">
					<table>
						<tr><th style="height:70px;">몇 번 문제!</th></tr>
						<tr><td style="height:70px;">퀴즈 제목</td></tr>
						<tr><td>퀴즈 보기1</td></tr>
						<tr><td>퀴즈 보기2</td></tr>
						<tr><td>퀴즈 보기3</td></tr>
						<tr><td>퀴즈 보기4</td></tr>
					</table>
				</form>	
			</div>
		</div>
		<%@include file="../common/footer.jsp"%>
	</div>

</body>
</html>