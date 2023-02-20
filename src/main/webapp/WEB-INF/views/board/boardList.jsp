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
<title> 커뮤니티 | 게시판 </title>
<style>
.tableList:hover {
	background-color: #91ACCC;
	color: white;
	cursor: pointer;
}
.page-link {
  color: #fff; 
  background-color: #91ACCC;
  border: 1px solid #ccc; 
}

.page-item.active .page-link {
 z-index: 1;
 color: #555;
 font-weight:bold;
 background-color: #f1f1f1;
 border-color: #ccc;
 
}

.page-link:focus, .page-link:hover {
  color: #000;
  background-color: #fafafa; 
  border-color: #ccc;
}

</style>
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
				<th> 작성자 </th>
				<th> 조회수 </th>
			</tr>
			<c:forEach items="${boardList }" var="list">
			<tr class="tableList" onClick="location.href='/board/${list.boardSeq}'">
				<td id ="boardSeq">${list.boardSeq }</td>
				<td>${list.category }</td>
				<td style="display : flex;">${list.title }</td>
				<td>${list.nickname }</td>
				<td>${list.viewcount }</td>
			</tr>
			</c:forEach>
			</table>
			
<nav aria-label="Page navigation example">
		<ul class="pagination justify-content-center">
    <%-- <c:if test="${paging.prev}"> --%>
        <li class="page-item"><a href='<c:url value="/board/list?page=${paging.startPage-1}"/>' class="page-link">이전</a></li>
   <%--  </c:if> --%>
    <c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="num">
        <li class="page-item" style="pagination-bg: #91ACCC"><span><a href='<c:url value="/board/list?page=${num}" />' class="page-link">${num}</a></span></li>
    </c:forEach>
    <%-- <c:if test="${paging.next && paging.endPage>0}"> --%>
        <li class="page-item"><a href='<c:url value="/board/list?page=${paging.endPage+1}" />'class="page-link">다음</a></li>
  <%--   </c:if> --%>
</ul>
</nav>
		
	</div>
<%@include file="../common/footer.jsp" %>
</div>
</body>


</html>