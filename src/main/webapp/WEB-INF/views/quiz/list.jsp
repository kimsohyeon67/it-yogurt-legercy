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
#hideDiv {
	display: none;
}

#num {
	height: 90px;
}
</style>
<script>
	$(document).ready(function() {
		//해설  n
		$("input:submit").click(function(e) {
			var length = $('input[name=length]').val(); //문제 길이
			var chk1 = $('input[name=radio1]:checked').val(); //체크된 보기 번호
			var chk2 = $('input[name=radio2]:checked').val(); //체크된 보기 번호
			var chk3 = $('input[name=radio3]:checked').val(); //체크된 보기 번호
			var chk4 = $('input[name=radio4]:checked').val(); //체크된 보기 번호
			var answer = 0;
			
			if(chk1 != undefined){
				answer+=1;
			}
			if(chk2 != undefined){
				answer+=1;
			}
			if(chk3 != undefined){
				answer+=1;
			}
			if(chk4 != undefined){
				answer+=1;
			}
			
			if(length != answer){
				alert('답을 체크하세요.');
				e.preventDefault();
			}
// 			alert('답 길이'+answer);
			
// 			console.log('문제 길이'+length);
// 			alert(chk1);
// 			alert(chk2);
// 			alert(chk3);
// 			alert(chk4);
			
			

		});
		
	});
</script>
</head>
<body>
	<div class="container">
		<%@include file="../common/header.jsp"%>
		<div class="content">
<!-- 			<div> -->
<!-- 				<h2>퀴즈풀기</h2> -->
<!-- 			</div> -->
				<div>
				<form action="<%=request.getContextPath()%>/answer?knowSeq=${list.knowSeq}" id="quizForm">
					<c:forEach items="${quizList }" var="list">
						<c:set var="length" value="${fn:length(quizList) }" />
							<input type="hidden" value="${list.knowSeq}" name="knowSeq">
							<input type="hidden" value="${list.quizSeq}" name="quizSeq">
							<input type="hidden" value="1" name="userSeq">
							<input type="hidden" value="${length}" name="length"><!-- 퀴즈 몇 개인지 -->
							<c:set var="i" value="${i+1}" />
						<table>
									<tr>
										<td id="num"><br> <br> <br> Q. ${i}번<br>
											<br> ${list.question}<br> <br></td>
									</tr>
									<!-- 보기화면 -->
									<div id="${i}">
										<tr>
											<td><input type="radio" value="1" id="radio1"
												name="radio${i}" class="radio"> 1. ${list.choice1}</td>
										</tr>
										<tr>
											<td><input type="radio" value="2" id="radio2"
												name="radio${i}" class="radio"> 2. ${list.choice2}</td>
										</tr>
										<c:if test="${list.choice3 ne '' }">
											<tr>
												<td><input type="radio" value="3" id="radio3"
													name="radio${i}" class="radio"> 3. ${list.choice3}</td>
											</tr>
										</c:if>
										<c:if test="${list.choice4 ne '' }">
											<tr>
												<td><input type="radio" value="4" id="radio4"
													name="radio${i}" class="radio"> 4. ${list.choice4}</td>
											</tr>
										</c:if>
									</div>
									<!-- 정답 및 해설 -->
<!-- 									<tr> -->
<!-- 										<td> -->
<!-- 											<div class="hideDiv" style="display: none;"> -->
<!-- 												<br> -->
<!-- 												<b>내가 입력한 답: </b><br> -->
<%-- 												<br>정답입니다.<br>${list.commentary } --%>
<!-- 												<br> -->
<!-- 											</div> -->
<!-- 										</td> -->
<!-- 									</tr> -->
								</table>
							</c:forEach>
						<br> <input type="submit" id="checkAnswer" value="정답 확인">
				</form>
					</div><!-- 전체 div -->
		</div><!-- content -->
		<%@include file="../common/footer.jsp"%>
	</div>
</body>
</html>