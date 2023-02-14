<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html> 
<head>
<script src="<%=request.getContextPath() %>resources/static/js/jquery-3.6.1.min.js"></script>
<style type="text/css">
table{

text-align: center;
}
</style>
<meta charset="EUC-KR">
<title>매일지식 컨텐츠</title>
</head>  
<body>
<h1 style="text-align: center;">매일지식 목록</h1>
<table border=3 >
<tr><td>번호</td><td>제목</td><td>작성일자</td><td>조회수</td></tr>
<c:forEach items="${knowledgeList }" var="list">
<tr>
<td>${list.knowSeq}</td>
<td><a href="<%=request.getContextPath()%>/detail?knowSeq=${list.knowSeq}">${list.title}</a></td>
<td>${list.insertDate }</td>
<td>${list.viewcount }</td>

</tr>
</c:forEach>

</table>
</body>
</html>