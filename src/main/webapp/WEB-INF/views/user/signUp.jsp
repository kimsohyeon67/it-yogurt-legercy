<%--<%@ include file="common/tag.jsp" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <script src="/js/jquery-3.6.1.min.js"></script>
    <link href="/css/header.css" rel="stylesheet">
    <link href="/css/footer.css" rel="stylesheet">
    <link href="/css/container.css" rel="stylesheet">
    <link href="/css/user/signup.css" rel="stylesheet">
    <script src="/js/user/signup.js"></script>
    <script src="/js/util/ajax.js"></script>
    <script src="/js/util/util.js"></script>
    <title>Title</title>
</head>
<body>
<div class="container">
    <%@include file="../common/header.jsp" %>
    <div class="content">
        <form id="signup_form" class="form" type="POST" href="/user/1">
            <div class="form-input">
                <label for="email">이메일</label>
                <input type="text" name="email" id="email" placeholder="이메일을 입력해주세요.">
            </div>
            <div class="form-input">
                <label for="password">비밀번호</label>
                <input type="password" name="password" id="password" placeholder="비밀번호를 입력해주세요">
            </div>
            <div class="form-input">
                <label for="password_check">비밀번호 확인</label>
                <input type="password" name="password_check" id="password_check"
                       placeholder="비밀번호를 한번 더 입력해주세요">
            </div>
            <div class="form-input">
                <label for="nickname">닉네임</label>
                <input type="text" name="nickname" id="nickname" placeholder="닉네임을 입력해주세요.">
            </div>
            <div class="form-input">
                <label for="phone">전화번호</label>
                <input type="tel" name="phone" id="phone"
                       placeholder="번호를 입력해주세요."></div>
            <div class="form-input">
                <label for="category_main">카테고리</label>
                <select name="category_main" id="category_main">

                </select>
                <select name="category_middle" id="category_middle">

                </select>
                <select name="category_sub" id="category_sub">

                </select>
            </div>
            <div class="form-input">
                <div class="subscribe">
                    <p>IT-Yogurt에서 제공하는 IT 지식을 메일로 받는데 동의합니다.</p>
                    <input type="checkbox" name="subscribe" id="subscribe" value="구독 동의">동의
                </div>
                <div class="signup_button">
                    <input type="submit" value="회원가입">
                </div>
            </div>
        </form>
    </div>
    <%@include file="../common/footer.jsp" %>
</div>
</body>
</html>