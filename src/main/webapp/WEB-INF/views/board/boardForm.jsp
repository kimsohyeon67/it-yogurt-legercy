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
<title> 커뮤니티 | 게시판 | 글쓰기 </title>
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
		<button id= "black" onclick="location.href='/board/list'">목록</button>
     		<form action="form" method="post">
				<div class="mb-3">
				  <label for="exampleFormControlInput1" class="form-label">제목</label>
				  <input type="text" class="form-control" id="title" name ="title" placeholder="제목">
				</div>
				<div class="mb-3">
				  <label for="exampleFormControlTextarea1" class="form-label">내용</label>
				  <textarea class="form-control" id="content" rows="3" name="content"></textarea>
				</div>
				<input type="hidden" name="userSeq" value="5">
				<input type="hidden" name="categorySeq" value="5">
				<button type="submit" class="btn btn-primary" style="background-color: #91ACCC;">등록</button>
			</form>
	</div>
<%@include file="../common/footer.jsp" %>
</div>
</body>
</html>