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
<style>
.tableList:hover {
	background-color: #91ACCC;
	color: white;
	cursor: pointer;
}
</style>
</head>
<body>

<div class="container">
<%@include file="../common/header.jsp" %>
     <div class="form">
		<h3 id="main" > 게시판 </h3> <br>
		<button id= "black" onclick="location.href='/board/list/1'">목록</button>
		<table class="form" border=3>
		<c:set value="${oneBoard }" var="oneboard"/>
			<tr>
				<th> 제목 </th>
				<td> ${oneboard.title } </td>
				<th> 작성자 </th>
				<td> ${oneboard.nickname } </td>
			</tr>
			<tr >
				<td colspan=4>${oneboard.content }<td>
			</tr>
			<%-- <tr class="tableList" onClick="location.href=''">
				<td id ="boardSeq">${list.boardSeq }</td>
				<td>${list.category }</td>
				<td style="display : flex;">${list.title }</td>
				<td>${list.nickname }</td>
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
			</tr> --%>
		</table>
	</div>
<%@include file="../common/footer.jsp" %>
</div>
</body>
</html>