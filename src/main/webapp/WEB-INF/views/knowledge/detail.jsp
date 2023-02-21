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
<link href="/css/knowledge.css" rel="stylesheet">
<title>매일지식</title>
</head>
<body>
	<div class="container">
		<%@include file="../common/header.jsp"%>
		<div class="content">
				<form action=" <%=request.getContextPath()%>/quiz/${knowSeq}">
					<div>
						<table>
						<div>
							<tr>
								<td id="category">IT > 프로그래밍언어 > JAVA</td>
							</tr>
							</div>
							<div>
							<tr style="height: 100px;">
								<td><b>${title}</b></td>
							</tr>
							</div>
							<tr>
								<td id="contents">${contents }</td>
							</tr>
							<tr>
								<td><input type="submit" value="퀴즈 풀러가기" id="subBtn">
								<input type="hidden" value="${knowSeq}" name="knowSeq"></td>
							</tr>
						</table>
					</div>
				</form>	
			</div>
		<%@include file="../common/footer.jsp"%>
	</div>
</body>
</html>