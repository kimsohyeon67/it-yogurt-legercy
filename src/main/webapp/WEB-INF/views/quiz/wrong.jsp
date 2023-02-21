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

    <title>퀴즈 풀기</title>
    <script>
      $(document).ready(function () {
        $("input:submit").click(function (e) {
          var length = $('input[name=length]').val(); //문제 길이
          var empty_check = {};
          for (let i = 0; i < length; i++) {
            empty_check[i + 1] = $(`input[name=radio${i+1}]:checked`).val(); //체크된 보기 번호
          }
          for (key in empty_check) {
            if (!empty_check[key]) {
              alert('답을 체크하세요.');
              e.preventDefault();
              return;
            } else {
              $("form").attr("action", "/-");
            }
          }
        })

        $(".pagination-number-button").on("click", function (e) {
          let params = (new URL(document.location)).searchParams;
          let limit = parseInt(params.get('limit')) || 5;
          let currentPage = $(this).attr("id") || 1;

          window.ajax.request(
              `\${window.location.pathname}/list?currentPage=\${currentPage}&limit=\${limit}`,
              success)
        })

        $(".filter .quiz-filter").on("change", function (e) {
          let params = (new URL(document.location)).searchParams;
          let limit = parseInt(params.get('limit')) || 5;
          let currentPage = $(this).attr("id") || 1;

          window.ajax.request(
              `\${window.location.pathname}/list?currentPage=\${currentPage}&limit=\${limit}`, {},
              success)
        })
      })

      let success = (result) => {
        let list = result.quizList;
        for (let i = 0, count = 0; i < list.length; i++, count++) {
          $("#quizForm").append(`
            <table id="\${i}">
              <tr id="quizListTbl">
                 <td id="num"><br><br><br> Q. \${i}번<br>
                      <br>\${list[i].question}<br><br></td>
              </tr>
            </table>`)
          // 보기화면
          $("#" + i).append(`
            <tr>
                <td><input type="radio" value="1" id="radio\${count}"
                            name="radio\${i}" class="radio"> 1. \${list[i].choice1}</td>
            </tr>
            <tr>
                <td><input type="radio" value="2" id="radio2"
                            name="radio\${i}" class="radio"> 2. \${list[i].choice2}</td>
            </tr>`)
          if (list[i].choice3 != '') {
            $("#" + i).append(`
                <tr>
                    <td><input type="radio" value="3" id="radio3"
                               name="radio\${i}" class="radio"> 3. \${list[i].choice3}
                    </td>
                </tr>`)
          }
          if (list[i].choice4 != '') {
            $("#" + i).append(`
              <tr>
                <td><input type="radio" value="4" id="radio4"
                       name="radio\${i}" class="radio"> 4. \${list[i].choice4}
                </td>
            </tr>`)
          }
        }
      }
    </script>
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
                <%--                <c:forEach items="${quizList}" var="list">--%>
                <%--                    <c:set var="length" value="${fn:length(quizList) }"/>--%>
                <%--                    <input type="hidden" value="${list.knowSeq}" name="knowSeq">--%>
                <%--                    <input type="hidden" value="${list.quizSeq}" name="quizSeq">--%>
                <%--                    <input type="hidden" value="1" name="userSeq">--%>
                <%--                    <input type="hidden" value="${length}" name="length"><!-- 퀴즈 몇 개인지 -->--%>
                <%--                    <c:set var="i" value="${i+1}"/>--%>
<%--                <table id="quiz-table">--%>
                    <%--                        <tr id="quizListTbl">--%>
                    <%--                            <td id="num"><br> <br> <br> Q. ${i}번<br>--%>
                    <%--                                <br> ${list.question}<br> <br></td>--%>
                    <%--                        </tr>--%>
                    <%--                        <!-- 보기화면 -->--%>
                    <%--                        <div id="${i}">--%>
                    <%--                            <tr>--%>
                    <%--                                <td><input type="radio" value="1" id="radio1"--%>
                    <%--                                           name="radio${i}" class="radio"> 1. ${list.choice1}</td>--%>
                    <%--                            </tr>--%>
                    <%--                            <tr>--%>
                    <%--                                <td><input type="radio" value="2" id="radio2"--%>
                    <%--                                           name="radio${i}" class="radio"> 2. ${list.choice2}</td>--%>
                    <%--                            </tr>--%>
                    <%--                            <c:if test="${list.choice3 ne '' }">--%>
                    <%--                                <tr>--%>
                    <%--                                    <td><input type="radio" value="3" id="radio3"--%>
                    <%--                                               name="radio${i}" class="radio"> 3. ${list.choice3}--%>
                    <%--                                    </td>--%>
                    <%--                                </tr>--%>
                    <%--                            </c:if>--%>
                    <%--                            <c:if test="${list.choice4 ne '' }">--%>
                    <%--                                <tr>--%>
                    <%--                                    <td><input type="radio" value="4" id="radio4"--%>
                    <%--                                               name="radio${i}" class="radio"> 4. ${list.choice4}--%>
                    <%--                                    </td>--%>
                    <%--                                </tr>--%>
                    <%--                            </c:if>--%>
                    <%--                        </div>--%>
<%--                </table>--%>
                <!-- 정답 및 해설 -->
                <!-- <tr> -->
                <!-- <td> -->
                <!-- <div class="hideDiv" style="display: none;"> -->
                <!-- <br> -->
                <!-- <b>내가 입력한 답: </b><br> -->
                <%-- 												<br>정답입니다.<br>${list.commentary } --%>
                <!-- <br> -->
                <!-- </div> -->
                <!-- </td> -->
                <!-- </tr> -->
                <%--                </c:forEach>--%>
<%--                <br> <input type="submit" id="checkAnswer" value="정답 확인">--%>
            </form>
            <div class="pagination">
                <div class="pagination-left-button">◀</div>
                <c:forEach var="i" begin="${start}" end="${end}" step="1">
                    <div class="pagination-number-button" id="${i}">${i}</div>
                </c:forEach>
                <div class="pagination-left-button">▶</div>
            </div>
        </div><!-- 전체 div -->
    </div><!-- content -->
    <%@include file="../common/footer.jsp" %>
</div>
</body>
</html>