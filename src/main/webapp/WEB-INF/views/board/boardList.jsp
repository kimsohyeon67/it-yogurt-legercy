<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/tag.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
 <meta charset="UTF-8">
    <link href="/css/header.css" rel="stylesheet">
    <link href="/css/footer.css" rel="stylesheet">
    <link href="/css/container.css" rel="stylesheet">
     <link href="/css/admin.css" rel="stylesheet">
<title>관리자</title>
</head>
<body>

<div class="container">
<%@include file="../common/header.jsp" %>
     <div class="form">
		<h3 id="main" > 게시판 </h3> <br>
		<table class="form" border=3>
			<tr>
				<th> 번호 </th>
				<th> 카테고리 </th>
				<th> 제목 </th>
				<th> 닉네임 </th>
				<th> 조회수 </th>
			</tr>
			<c:forEach items="${boardList }" var="list">
			<tr>
				<td id ="boardSeq">${list.boardSeq }</td>
				<td>${list.categorySeq }</td>
				<td style="display : flex" >${list.title }</td>
				<td>${list.userSeq }</td>
				<td>${list.viewcount }</td>
			</tr>
			</c:forEach>
			<tr>
			<td colspan="5">
				<%
				int totalBoardCnt = (int) request.getAttribute("totalBoardCnt");
				int totalPage = 0;
				if (totalBoardCnt % 10 == 0) {
					totalPage = totalBoardCnt / 10;
				} else {
					totalPage = totalBoardCnt / 10 + 1;
				}
				for (int i = 1; i <= totalPage; i++) {
				%>
				<a href="<%=i%>"><%=i%>페이지</a>
				<%
				}
				%>
			</td>
			</tr>
		</table>
	</div>
<%@include file="../common/footer.jsp" %>
</div>
</body>
</html>