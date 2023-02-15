<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
				<c:forEach items="${quizList }" var="list">
				<div>
					<table>
						<tr><th style="height:70px;">몇 번 문제!</th></tr>
						<tr><td style="height:70px;">퀴즈 ${list.question}</td></tr>
						<tr><td>${list.choice1}</td></tr>
						<tr><td>${list.choice2}</td></tr>
						<tr><td>${list.choice3}</td></tr>
						<c:if test="${fn:length(list)>0}">
						<tr><td>${list.choice4}</td></tr>
						</c:if>
					</table>
				</div>	
				</c:forEach>	
				</form>	
			</div>
		</div>
		<%@include file="../common/footer.jsp"%>
	</div>

</body>
</html>