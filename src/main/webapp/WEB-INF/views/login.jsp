<%--<%@ include file="common/tag.jsp" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <link href="/css/header.css" rel="stylesheet">
    <link href="/css/footer.css" rel="stylesheet">
    <link href="/css/container.css" rel="stylesheet">
    <link href="/css/login.css" rel="stylesheet">
    <title>Title</title>
</head>
<body>
<div class="container">
    <%@include file="common/header.jsp" %>
    <div class="content">
        <div class="login">
            <input type="text" id="email" placeholder="이메일을 입력하세요.">
            <br>
            <input type="password" id="pw" placeholder="비밀번호를 입력하세요">
        </div>
        <div class="sns_login">
            <div class="sns_login_kakao_btn">
                <img src="/image/kakao.png">
            </div>
            <div class="sns_login_naver_btn">
                <img src="/image/naver.png">
            </div>
            <div class="sns_login_google_btn">
                <img src="/image/google.png">
            </div>
        </div>
    </div>
    <%@include file="common/footer.jsp" %>
</div>
</body>
</html>