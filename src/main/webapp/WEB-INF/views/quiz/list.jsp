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
<link href="/css/login.css" rel="stylesheet">
<title>퀴즈 풀기</title>
<style type="text/css">
#hideDiv{
 display: none;
}

#num{
 height:90px;
}


</style>
<script>

$(document).ready(function(){
	$("input:submit").click(function(){
		if($("#hideDiv").css("display") == "none"){
		    $("#hideDiv").show();
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
			<div style="margin: auto;">
				<form action="<%=request.getContextPath()%>/answer?knowSeq=${knowSeq}">
				<c:forEach items="${quizList }" var="list">
				<input type="hidden" value="${list.knowSeq}" name="knowSeq">
				<div>
				<c:set var="i" value="${i+1}"></c:set>
					<table>
						<tr><td id="num"><br><br><br>
								${i} 번 퀴즈<br><br> ${list.question}<br><br>
							</td></tr>
						<div id="${i}" >
							<tr><td><input type="radio" value="1" id="radio1" name="radio${i}">1. ${list.choice1}</td></tr>
							<tr><td><input type="radio" value="2" id="radio2" name="radio${i}">2. ${list.choice2}</td></tr>
							<tr><td><input type="radio" value="3" id="radio3" name="radio${i}">3. ${list.choice3}</td></tr>
								<c:if test="${list.choice4 ne ''}">
									<tr><td><input type="radio" value="4" id="radio4" name="radio">4. ${list.choice4}</td></tr>
								</c:if>
						</div>
						<tr><td>
						<div id="hideDiv">
							<br>정답입니당<br>
							왜냐하면 어쩌구 저쩌구라서 입니당<br>
						</div>
						</td></tr>
					</table>
				</div>	
				</c:forEach>	
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