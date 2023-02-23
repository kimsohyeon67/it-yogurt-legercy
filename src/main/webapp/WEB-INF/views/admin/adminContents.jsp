<%@ include file="../common/tag.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html>
<html>
<head>
 <meta charset="UTF-8">
 	<script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
    <link href="/css/header.css" rel="stylesheet">
    <link href="/css/footer.css" rel="stylesheet">
    <link href="/css/container.css" rel="stylesheet">
    <link href="/css/admin.css" rel="stylesheet">
    <link href="/css/user/signup.css" rel="stylesheet">
    <script src="/js/user/signup.js"></script>
    <script src="/js/util/ajax.js"></script>
    <script src="/js/util/util.js"></script>
<title>관리자 | 문제 관리</title>
</head>
<style>
	#content-form {
		margin-top: 20%;
	}
</style>
<%@include file="../common/nav.jsp" %>
<body>

<div class="container mt-5" style="margin-top:100px;">
	<div class="form" id="content-form">
		<button id="" onclick="location.href='/admin/user'">회원관리</button>
		<button onclick="location.href='/admin/contents'">컨텐츠 관리</button>
	</div>
		<form action ="contents" method="post" class="form">

				<div >
                	<label for="main"><h4>카테고리</h4></label><br>
                		<select name="main" id="main">

                		</select>
               			 <select name="middle" id="middle">

                		</select>
                		<select name="sub" id="sub">

                		</select>
                		<div class="input-group mb-3">
                		<input type="text" name="detail" class="form-control">
						</div>
				</div>
					<input type="hidden" name ="categorySeq" value="2" >
					<input type="hidden" name ="userSeq" value="2" >
					
			<div>
				<h3>정보글 등록 </h3>
			</div>
				제목<br>
				<div class="input-group mb-3">
				<input type="text" id="title" name="title" class="form-control" >
				</div>
			
				내용 등록 <br>
			<textarea rows="8" cols="50" id="content" name="content"></textarea>
			
			<div>
			 	<h3>퀴즈 등록</h3>
			</div>
				제목 <br>
				<div class="input-group mb-3">
					<input type="text" id="question" name="question" class="form-control"><br>
				</div>
			
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

<script type="text/javascript">
$(document).ready(function () {
	// 카테고리 가져오기
	  window.ajax.request("/category", {}, CategorySetting, category_error)
	// 카테고리 변경 시
  $("select").on("change", function (event) {
    let type = $(this).attr("id");
    let type_value = $(this).val();
    window.ajax.request(`/category/${type}`,
        {data: {type: "GET", type_value: type_value}}, CategoryTypeSuccess,
        category_error)
  })
  
})
let error = (request) => {
  alert(request.responseJSON.errorMessage);
}

</script>
<%@include file="../common/footer.jsp" %>
</html>