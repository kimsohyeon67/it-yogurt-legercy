<%@ include file="../common/tag.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html>
<html>
<head>
 <meta charset="UTF-8">
    <link href="/css/header.css" rel="stylesheet">
    <link href="/css/footer.css" rel="stylesheet">
    <link href="/css/container.css" rel="stylesheet">
    <link href="/css/admin.css" rel="stylesheet">
<title>문제 관리</title>
</head>
<body>
<div class="container">
<%@include file="../common/header.jsp" %>
    <div class="content">
<form action ="contents" method="post">
<div>
<h4>카테고리</h4>
	<input type="hidden" name ="categorySeq" value="2" >
	<input type="hidden" name ="userSeq" value="2" >
</div>
	<div>
		정보글 등록
	</div>
	<div>
		제목 <br>
		<input type="text" id="title" name="title">
	</div>
	<div>
		내용 등록 <br>
		<textarea rows="8" cols="50" id="content" name="content"></textarea>
	</div>
	
	<div>
		퀴즈 등록
	</div>
	<div>
		제목 <br>
		<input type="text" id="question" name="question" >
	</div>
	<div>
		보기 문항 <br>
		1. <input type="text" id="choice1" name="choice1" ><br>
		2. <input type="text" id="choice2" name="choice2"><br>
		3. <input type="text" id="choice3" name="choice3"><br>
		4. <input type="text" id="choice4" name="choice4"><br>
	</div>
	<div>
		정답 <br>
		<input type="text" id="answer" name="answer"><br>
	</div>
	<div>
		해설<br>
		<textarea rows="3" cols="50" id="commentary" name="commentary"></textarea>
	</div>
	<input type="hidden" id="know_seq" name="know_seq" value="1">
	<input type="submit" value="등록">
</form>
</div>
<%@include file="../common/footer.jsp" %>
</div>
</body>
</html>