<%--<%@ include file="common/tag.jsp" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <link href="/css/header.css" rel="stylesheet">
    <link href="/css/footer.css" rel="stylesheet">
    <link href="/css/container.css" rel="stylesheet">
    <link href="/css/user/login.css" rel="stylesheet">
    <script src="/js/jquery-3.6.1.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
    <title>Title</title>
</head>
<style>
    #box-check {
    }

</style>
<body>
<div class="container">
    <%@include file="../common/header.jsp" %>
    <div class="col" id="box-check">
        <div class="row pt-5 pd-5">
            <h4>로그인 하셔야 문제 풀이 기록이 저장됩니다. 로그인 하시겠습니끼?</h4>
            <button id="btn-login" type="button" onclick="location.href='/user?access=mail&knowSeq=${knowSeq}'" class="float-start btn btn-dark float-end me-5" style="width: 180px; height: 48px;">
                LOGIN
            </button>
            <button id="btn-quiz" type="button" onclick="location.href='/quiz/${knowSeq}'" class="float-start btn btn-dark float-end me-5" style="width: 180px; height: 48px;">
                문제만 풀래요!
            </button>
        </div>
    </div>
    <%@include file="../common/footer.jsp" %>
</div>
</body>
</html>