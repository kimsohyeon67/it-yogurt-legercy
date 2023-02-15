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
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script>
$(document).ready(function(){
	$('input[type="checkbox"][name="chk"]').click(function(){
	    if($(this).prop('checked')){
	    	$('input[type="checkbox"][name="chk"]').prop('checked',false);
	    	$(this).prop('checked',true);
	    }
	});
	
});
</script>
</head>
<body>
<h1>퀴즈풀기</h1>
<div class="container">
		<%@include file="../common/header.jsp"%>
		<div class="content">
			<div>
				<form action=" ">
				<div>
				<c:forEach items="${quizList }" var="list">
				<c:set var="i" value="${i+1}"></c:set>
					<table>
						<tr><td style="height:90px;"><br>
								${i} 번 퀴즈<br><br> ${list.question}<br><br>
							</td></tr>
						<tr><td><input type="checkbox" value="1" id="chk1" name="chk">1. ${list.choice1}</td></tr>
						<tr><td><input type="checkbox" value="2" id="chk2" name="chk">2. ${list.choice2}</td></tr>
						<tr><td><input type="checkbox" value="3" id="chk3" name="chk">3. ${list.choice3}</td></tr>
						<c:if test="${list.choice4 ne ''}">
						<tr><td><input type="checkbox" value="4" id="chk4" name="chk">4. ${list.choice4}</td></tr>
						</c:if>
					</table>
				</c:forEach>	
				</div>	
				<div>
					<br><input type="submit" value="정답 확인">
				</div>
				</form>	
			</div>
		</div>
		<%@include file="../common/footer.jsp"%>
	</div>
</body>
</html>