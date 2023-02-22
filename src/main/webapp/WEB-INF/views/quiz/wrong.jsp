<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@include file="../common/tag.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="/css/header.css" rel="stylesheet">
    <link href="/css/footer.css" rel="stylesheet">
    <link href="/css/container.css" rel="stylesheet">
    <link href="/css/quiz.css" rel="stylesheet">
    <script src="/js/util/ajax.js"></script>
    <script src="/js/quiz/wrong.js"></script>

    <title>퀴즈 풀기</title>
</head>
<body>
<div class="container">
    <%@include file="../common/header.jsp" %>
    <div class="content">
        <div>
            <div class="filter">
                <select class="quiz-filter">
                    <option value="5">5개씩 보기</option>
                    <option value="10">10개씩 보기</option>
                    <option value="20">20개씩 보기</option>
                </select>
            </div>
            <form action="<%=request.getContextPath()%>" id="quizForm" method=post>
            </form>
        </div><!-- 전체 div -->
    </div><!-- content -->
    <div class="paging">
        <nav aria-label="Page navigation example" style="margin: 10px;">
            <ul class="pagination justify-content-center">
                <li class="page-item"><div onclick="go_page(1); return false;" class="page-link">처음</div></li>
                <%-- <c:if test="${paging.prev}"> --%>
                <li class="page-item"><div onclick="go_page(${paging.startPage-1})" class="page-link">이전</div></li>
                <%--  </c:if> --%>
                <c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="num">
                    <li class="page-item" style="pagination-bg: #91ACCC"><span><div onclick="go_page(${num})" class="page-link">${num}</div></span></li>
                </c:forEach>
                <%-- <c:if test="${paging.next && paging.endPage>0}"> --%>
                <li class="page-item"><div onclick="go_page(${paging.endPage+1})" class="page-link">다음</div></li>
                <%--</c:if> --%>
                <li class="page-item"><div onclick="go_page(${maxpage})" class="page-link">끝</div></li>
            </ul>
        </nav>
    </div>
    <%@include file="../common/footer.jsp" %>
</div>
</body>

</html>
<style>

  .paging {
    display: flex;
    justify-content: center;
    width: 100%;
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