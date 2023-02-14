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
<title>매일지식</title>
</head>
<body>
	<div class="container">
		<%@include file="../common/header.jsp"%>
		<div class="content">
			<div>
				<table>
				<tr><td>IT > 프로그래밍언어 > JAVA</td></tr>
					<tr style="height:100px;">
						<td>${title}</td>
					</tr>
					<tr>
						<td>${contents }</td>
					</tr>
				</table>
			</div>
		</div>
		<%@include file="../common/footer.jsp"%>
	</div>
</body>
</html>