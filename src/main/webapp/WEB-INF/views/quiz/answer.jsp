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
<link href="/css/quiz.css" rel="stylesheet">
<title>정답 보기</title>

</head>
<body>
	<div class="container">
		<%@include file="../common/header.jsp"%>
		<div class="content">
			<div>
				<table>
					<c:set var="length" value="${fn:length(quizList) }" />
					<c:forEach items="${quizList }" var="list">
					
						<!-- 퀴즈번호 기재하기 위한 변수 선언 -->
						<c:set var="i" value="${i+1}" />
							<tr>
								<td id="num"><br> <br> <br> 
								Q. ${i}번<br><br>
								문제: ${list.question}<br> <br></td>
							</tr>
							
								<!-- 보기화면 -->
								<div id="${i}">
									<tr><td> 1. ${list.choice1}</td></tr>
									<tr><td> 2. ${list.choice2}</td></tr>
									<tr><td> 3. ${list.choice3}</td></tr>
									<tr><td> 4. ${list.choice4}</td></tr>
								</div>
								
								<!-- 정답 및 해설 -->
								<tr>
									<td>
										<div class="hideDiv">
										<br><b>정답: ${list.answer }</b><br>
										<c:forEach items="${learnList}" var="learn" begin="${i-1}" end="${i-1}">
												<br><b>내가 입력한 답: ${learn.userChoice}</b><br>
												
												<!-- isRight가 1이면 정답 0이면 오답 -->
												<c:choose>
													<c:when test="${learn.isRight == 1}">
														<br>정답입니다.<br>
													</c:when>
													<c:otherwise>
														<br>틀렸습니다.<br>
													</c:otherwise>
												</c:choose>
											</c:forEach>
											
												${list.commentary }
											
											</div>
										</td>
									</tr>
								</c:forEach>
							</table>
					</div><!-- 전체 div -->
		</div><!-- content -->
		<%@include file="../common/footer.jsp"%>
	</div>
</body>
</html>