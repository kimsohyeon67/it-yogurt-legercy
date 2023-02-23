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
<title>관리자 | 문제 관리</title>
</head>
<style>
	#content-form {
		margin-top: 20%;
	}
</style>
<%@include file="../common/nav.jsp" %>
<body>

<div class="container">
	<div class="form" id="content-form">
		<button id="" onclick="location.href='/admin/user'">회원관리</button>
		<button onclick="location.href='/admin/contents'">컨텐츠 관리</button>
	</div>
		<form action ="contents" method="post" class="form">

				<h4>카테고리</h4>
					<input type="hidden" name ="categorySeq" value="2" >
					<input type="hidden" name ="userSeq" value="2" >
					
			
			<h5>정보글 등록 </h5>
			
				제목 <br>
				<input type="text" id="title" name="title">
			
			
				내용 등록 <br>
			<textarea rows="8" cols="50" id="content" name="content"></textarea>
			
	
			 <h5>퀴즈 등록</h5>
		
				제목 <br>
			<input type="text" id="question" name="question" ><br>
			
			
				보기 문항 <br>
				1. <input type="text" id="choice1" name="choice1" ><br>
				2. <input type="text" id="choice2" name="choice2"><br>
				3. <input type="text" id="choice3" name="choice3"><br>
				4. <input type="text" id="choice4" name="choice4"><br>
			
			
				정답 <br>
				<input type="text" id="answer" name="answer"><br>
			
				해설<br>
				<textarea rows="3" cols="50" id="commentary" name="commentary"></textarea>
			
			
			<input type="hidden" id="knowSeq" name="knowSeq" value=${knowSeq }>
		<input type="submit" value="등록">
		
		</form>
	
</div>
</body>
<%@include file="../common/footer.jsp" %>
</html>