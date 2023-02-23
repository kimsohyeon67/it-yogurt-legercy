<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="/css/header.css" rel="stylesheet">
    <link href="/css/footer.css" rel="stylesheet">
    <link href="/css/container.css" rel="stylesheet">
    <link href="/css/login.css" rel="stylesheet">
    <link href="/css/knowledge.css" rel="stylesheet">
    <title>매일지식</title>
</head>
<style>
    #detailTbl {
        margin-top: 20%;
    }
</style>
<%@include file="../common/nav.jsp"%>
<body>
<div class="container">
    <div class="content">
        <!-- 퀴즈 푸는 화면 이동 form -->
        <form action=" <%=request.getContextPath()%>/quiz/${knowSeq}">
            <div>
                <!-- 퀴즈 목록 테이블 -->
                <table id="detailTbl">
                    <div>
                        <tr>
                            <td class="detailTd">IT > 프로그래밍언어 > JAVA </td>
                        </tr>
                    </div>
                    <div>
                        <tr style="height: 100px;">
                            <td class="detailTd"><h1>${title}</h1></td>
                        </tr>
                        <tr><td>작성자 : 관리자 ${sessionScope.user_seq}</td></tr>
                    </div>
                    <tr>
                        <td class="detailTd">${contents }</td>
                    </tr>
                    <tr>
                        <td class="detailTd"><input type="submit" value="퀴즈 풀러가기" id="subBtn">
                            <input type="hidden" value="${knowSeq}" name="knowSeq"></td>
                    </tr>
                </table>
            </div>
        </form>
    </div>
</div>
<%@include file="../common/footer.jsp"%>
</body>
</html>